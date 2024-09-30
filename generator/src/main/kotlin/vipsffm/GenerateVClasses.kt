package vipsffm

import app.photofox.vipsffm.jextract.GEnumClass
import app.photofox.vipsffm.jextract.GEnumValue
import app.photofox.vipsffm.jextract.VipsRaw
import com.squareup.javapoet.AnnotationSpec
import com.squareup.javapoet.ArrayTypeName
import com.squareup.javapoet.ClassName
import com.squareup.javapoet.CodeBlock
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeName
import com.squareup.javapoet.TypeSpec
import org.slf4j.LoggerFactory
import vipsffm.GenerateVipsHelperClass.fromSnakeToJavaStyle
import java.lang.foreign.Arena
import java.nio.file.Path
import java.util.Arrays
import java.util.Locale
import java.util.Objects
import javax.lang.model.element.Modifier

object GenerateVClasses {

    private val logger = LoggerFactory.getLogger(GenerateVClasses::class.java)
    private val vipsHelperType = ClassName.get("app.photofox.vipsffm", "VipsHelper")
    private val vipsInvokerType = ClassName.get("app.photofox.vipsffm", "VipsInvoker")
    private val vipsErrorType = ClassName.get("app.photofox.vipsffm", "VipsError")
    private val vipsOptionType = ClassName.get("app.photofox.vipsffm", "VipsOption")
    private val vipsOptionVarargType = ArrayTypeName.of(vipsOptionType)
    private val memorySegmentType = ClassName.get("java.lang.foreign", "MemorySegment")
    private val arenaType = ClassName.get("java.lang.foreign", "Arena")
    private val stringType = ClassName.get("java.lang", "String")
    private val listType = ClassName.get("java.util", "List")
    private val vimageType = ClassName.get("app.photofox.vipsffm", "VImage")
    private val vsourceType = ClassName.get("app.photofox.vipsffm", "VSource")
    private val vtargetType = ClassName.get("app.photofox.vipsffm", "VTarget")
    private val vInterpolateType = ClassName.get("app.photofox.vipsffm", "VInterpolate")
    private val vEnumType = ClassName.get("app.photofox.vipsffm", "VEnum")
    private val vblobType = ClassName.get("app.photofox.vipsffm", "VBlob")
    private val listStringType = ParameterizedTypeName.get(listType, stringType)
    private val boxedBooleanType = ClassName.get("java.lang", "Boolean")
    private val boxedIntType = ClassName.get("java.lang", "Integer")
    private val boxedLongType = ClassName.get("java.lang", "Long")
    private val boxedDoubleType = ClassName.get("java.lang", "Double")
    private val vipsOptionIntType = ClassName.get("app.photofox.vipsffm", "VipsOption.Int")
    private val vipsOptionBooleanType = ClassName.get("app.photofox.vipsffm", "VipsOption.Boolean")
    private val vipsOptionDoubleType = ClassName.get("app.photofox.vipsffm", "VipsOption.Double")
    private val vipsOptionLongType = ClassName.get("app.photofox.vipsffm", "VipsOption.Long")
    private val vipsOptionStringType = ClassName.get("app.photofox.vipsffm", "VipsOption.String")
    private val vipsOptionImageType = ClassName.get("app.photofox.vipsffm", "VipsOption.Image")
    private val vipsOptionSourceType = ClassName.get("app.photofox.vipsffm", "VipsOption.Source")
    private val vipsOptionTargetType = ClassName.get("app.photofox.vipsffm", "VipsOption.Target")
    private val vipsOptionBlobType = ClassName.get("app.photofox.vipsffm", "VipsOption.Blob")
    private val vipsOptionArrayDoubleType = ClassName.get("app.photofox.vipsffm", "VipsOption.ArrayDouble")
    private val vipsOptionArrayIntType = ClassName.get("app.photofox.vipsffm", "VipsOption.ArrayInt")
    private val vipsOptionArrayImageType = ClassName.get("app.photofox.vipsffm", "VipsOption.ArrayImage")
    private val vipsOptionInterpolateType = ClassName.get("app.photofox.vipsffm", "VipsOption.Interpolate")
    private val vipsOptionEnumType = ClassName.get("app.photofox.vipsffm", "VipsOption.Enum")
    private val vipsValidatorType = ClassName.get("app.photofox.vipsffm", "VipsValidation")
    private val vNamedEnumType = ClassName.get("app.photofox.vipsffm", "VNamedEnum")

    @JvmStatic fun main(args: Array<String>) {
        val operations = Arena.ofConfined().use {
            DiscoverVipsOperations.run(it)
        }

        logger.info("found ${operations.size} operations:")
        operations.forEach { op ->
            val inputArgs = op.args.filter { it.isRequired && it.isInput }
            val outputArgs = op.args.filter { it.isOutput }
            val optionalArgs = op.args.filter { !it.isRequired }
            logger.info("  ${op.nickname} - args: ${inputArgs.size} input, ${outputArgs.size} output, ${optionalArgs.size} optional")
        }

        val enums = operations.map {
            it.args
        }.flatten().filter {
            it.isEnum
        }.map {
            (it.type as GValueType.Unknown).rawName
        }.toSet()

        val discoveredEnums = Arena.ofConfined().use { arena ->
            enums.map {
                discoverEnumClass(arena, it)
            }
        }
        discoveredEnums.forEach {
            buildEnumClass(it)
        }

        generateVImageClass(operations, discoveredEnums)
    }

    private fun generateVImageClass(
        operations: List<VipsOperation>,
        enums: List<DiscoveredEnum>
    ) {
        val operationMethods = operations.mapNotNull { operation ->
            val hasImageInput = operation.args.any { it.isInput && it.isRequired && it.type == GValueType.VipsImage }
            val hasImageOutput =
                operation.args.any { it.isOutput && it.isRequired && (it.type == GValueType.VipsImage || it.type == GValueType.VipsArrayImage) }
            if (!(hasImageInput || hasImageOutput)) {
                logger.info("skipping \"${operation.nickname}\" - no image inputs or outputs")
                return@mapNotNull null
            }
            buildOperationMethod(operation, operations, enums)
        }

        val imageMethods = buildImageMethods()

        val ctor = MethodSpec.constructorBuilder()
            .addParameter(arenaType, "arena")
            .addParameter(memorySegmentType, "address")
            .addException(vipsErrorType)
            .addCode(
                CodeBlock.builder()
                    .beginControlFlow("if (!\$T.isValidPointer(address))", vipsValidatorType)
                    .addStatement("throw new VipsError(\"invalid pointer used for creation\")")
                    .endControlFlow()
                    .build()
            )
            .addStatement("this.arena = arena")
            .addStatement("this.address = address")
            .build()
        val hashCode = MethodSpec.methodBuilder("hashCode")
            .addAnnotation(Override::class.java)
            .addModifiers(Modifier.PUBLIC)
            .returns(TypeName.INT)
            .addStatement("return \$T.hash(arena, address)", Objects::class.java)
            .build()
        val equals = MethodSpec.methodBuilder("equals")
            .addAnnotation(Override::class.java)
            .addModifiers(Modifier.PUBLIC)
            .addParameter(TypeName.OBJECT, "o")
            .returns(TypeName.BOOLEAN)
            .addStatement("if (this == o) return true")
            .addStatement("if (!(o instanceof \$T vImage)) return false", vimageType)
            .addStatement("return Objects.equals(arena, vImage.arena) && Objects.equals(address, vImage.address)")
            .build()
        val unsafeDeprecatedAddress = MethodSpec.methodBuilder("getUnsafeAddress")
            .addJavadoc("@deprecated See {@link #getUnsafeStructAddress}")
            .addStatement("return this.getUnsafeStructAddress()")
            .returns(memorySegmentType)
            .addModifiers(Modifier.PUBLIC)
            .addAnnotation(
                AnnotationSpec.builder(ClassName.get("java.lang", "Deprecated"))
                    .addMember("since", "\"0.5.10\"")
                    .addMember("forRemoval", "true")
                    .build()
            )
            .build()
        val unsafeStructAddress = MethodSpec.methodBuilder("getUnsafeStructAddress")
            .addJavadoc("Gets the raw {@link MemorySegment} (C pointer) for this VipsImage struct")
            .addJavadoc("\nThe memory address' lifetime is bound to the scope of the {@link #arena}")
            .addJavadoc("\nUsage of the memory address is strongly discouraged, but it is available if some functionality is missing and you need to use it with {@link VipsHelper}")
            .addStatement("return this.address")
            .returns(memorySegmentType)
            .addModifiers(Modifier.PUBLIC)
            .build()
        val vipsClass = TypeSpec.classBuilder(vimageType.topLevelClassName())
            .addJavadoc("A generated wrapper representing a VipsImage. Do not edit.")
            .addJavadoc("\n@see <a href=\"https://www.libvips.org/API/current/api-index-full.html\">libvips api docs</a>")
            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
            .addMethod(ctor)
            .addMethod(hashCode)
            .addMethod(equals)
            .addMethod(unsafeDeprecatedAddress)
            .addMethod(unsafeStructAddress)
            .addMethods(operationMethods)
            .addMethods(imageMethods)
            .addField(arenaType, "arena", Modifier.PRIVATE, Modifier.FINAL)
            .addField(memorySegmentType, "address", Modifier.FINAL)
            .build()
        val javaFile = JavaFile.builder("app.photofox.vipsffm", vipsClass)
            .build()
        val targetedGeneratedSourceRoot = Path.of("core/src/main/java")
        javaFile.writeToPath(targetedGeneratedSourceRoot, Charsets.UTF_8)
    }

    private fun buildOperationMethod(
        spec: VipsOperation,
        operations: List<VipsOperation>,
        enums: List<DiscoveredEnum>
    ): MethodSpec {
        logger.info("building operation $spec")
        val requiredArguments = spec.args.filter { it.isRequired }
        val methodName = spec.nickname.fromSnakeToJavaStyle()
        val method = MethodSpec.methodBuilder(methodName)
        val poetArguments = requiredArguments.mapNotNull {
            val name = it.name.fromSnakeToJavaStyle()
            val argType = mapArgSpecToPoetType(it)
            if (argType == null) {
                throw RuntimeException("unsupported type in method \"${it.name}\": ${it.type}")
            }
            ParameterSpec.builder(argType, name).build()
        }

        val filteredPoetArgs = poetArguments.filterIndexed { index, poetArg ->
            val argSpec = requiredArguments[index]
            val isNotOutput = !argSpec.isOutput
            val isNotImageInput = !(argSpec.isInput && (argSpec.type == GValueType.VipsImage))
            isNotOutput && isNotImageInput
        }
        method.addParameters(filteredPoetArgs)

        val firstOutput = poetArguments.filterIndexed { index, poetArg ->
            val argSpec = requiredArguments[index]
            argSpec.isOutput && argSpec.isRequired
        }.firstOrNull()

        val returnType = firstOutput?.type ?: TypeName.VOID
        method.returns(returnType)
        method.addParameter(vipsOptionVarargType, "args")
        method.varargs(true)
        method.addException(vipsErrorType)
        method.addModifiers(Modifier.PUBLIC)
        generateMethodJavadoc(method, spec, operations, enums)

        poetArguments.forEachIndexed { index, poetArg ->
            if (!filteredPoetArgs.contains(poetArg)) {
                return@forEachIndexed
            }
            val argSpec = requiredArguments[index]
            var argNameSection = poetArg.name
            if (argSpec.isEnum) {
                val enumName = (argSpec.type as GValueType.Unknown).rawName
                argNameSection += " {@link \$T}"
                method.addJavadoc("\n@param $argNameSection ${argSpec.blurb.capitalizeVipsText()}", ClassName.get("app.photofox.vipsffm.enums", enumName))
            } else {
                method.addJavadoc("\n@param $argNameSection ${argSpec.blurb.capitalizeVipsText()}")
            }
        }
        method.addJavadoc("\n@param args Array of VipsOption to apply to this operation")
        spec.args.forEach {
            if (it.isRequired || it.name == "nickname" || it.name == "description") {
                return@forEach
            }
            val poetType = mapArgSpecToPoetType(it) ?: throw RuntimeException("unexpected null poet type for arg spec: $it")
            val vipsOptionType = mapPoetTypeToVipsOptionType(poetType, it)
            var optionName = "{@link ${vipsOptionType.simpleNames().first()}}"
            if (it.isEnum) {
                val enumName = (it.type as GValueType.Unknown).rawName
                optionName += " {@link \$T}"
                method.addJavadoc("\n@optionalArg ${it.name} $optionName ${it.blurb.capitalizeVipsText()}", ClassName.get("app.photofox.vipsffm.enums", enumName))
            } else {
                method.addJavadoc("\n@optionalArg ${it.name} $optionName ${it.blurb.capitalizeVipsText()}")
            }
        }

        poetArguments.forEachIndexed { index, poetArg ->
            val argSpec = requiredArguments[index]
            val poetArgType = poetArg.type
            val vipsOptionType = mapPoetTypeToVipsOptionType(poetArgType, argSpec)
            if (argSpec.isOutput) {
                method.addStatement("var ${poetArg.name}Option = \$T(\"${argSpec.name}\")", vipsOptionType)
            } else if (argSpec.isInput) {
                if (poetArg.type == vimageType) {
                    method.addStatement("var ${poetArg.name}Option = \$T(\"${argSpec.name}\", this)", vipsOptionType)
                } else if (poetArg.type == vEnumType) {
                    method.addStatement(
                        "var ${poetArg.name}Option = \$T(\"${argSpec.name}\", ${poetArg.name}.getRawValue())",
                        vipsOptionType
                    )
                } else {
                    method.addStatement(
                        "var ${poetArg.name}Option = \$T(\"${argSpec.name}\", ${poetArg.name})",
                        vipsOptionType
                    )
                }
            }
        }
        method.addStatement("var callArgs = new \$T<>(\$T.asList(args))", ArrayList::class.java, Arrays::class.java)
        poetArguments.forEachIndexed { index, poetArg ->
            val argSpec = requiredArguments[index]
            method.addStatement("callArgs.add(${poetArg.name}Option)")
        }
        method.addStatement("\$T.invokeOperation(arena, \"${spec.nickname}\", callArgs)", vipsInvokerType);
        if (returnType != TypeName.VOID) {
            method.addStatement("return ${firstOutput!!.name}Option.valueOrThrow()")
        }

        return method.build()
    }

    private fun generateMethodJavadoc(
        method: MethodSpec.Builder,
        spec: VipsOperation,
        operations: List<VipsOperation>,
        enums: List<DiscoveredEnum>
    ) {
        if (spec.gir?.doc == null) {
            method.addJavadoc(spec.description.capitalizeVipsText())
            return
        }

        var girDoc = spec.gir.doc.replace("$", "$$")

        val referencedClassNames = mutableListOf<ClassName>()

        girDoc = girDoc.replace("Optional arguments:\n\n?(\\*?(.+)\n)+".toRegex(), "")

        girDoc = girDoc.replace("@([A-Za-z0-9-_]*)".toRegex()) { match ->
            val referencedName = match.groups[1]!!.value
            val matchedArg = spec.args.firstOrNull {
                val girDocsNormalisedName = it.name.replace("-", "_")
                referencedName == girDocsNormalisedName
            }
            if (matchedArg != null) {
                if (matchedArg.isRequired) {
                    "{@param ${matchedArg.name.fromSnakeToJavaStyle()}}"
                } else {
                    "{@optionalArg ${matchedArg.name.fromSnakeToJavaStyle()}}"
                }
            } else {
                "<code>@$referencedName</code>"
            }
        }

        girDoc = girDoc.replace("vips_([A-Za-z0-9-_]*)\\(\\)".toRegex()) { match ->
            val newName = match.groups[1]!!.value.removePrefix("image").fromSnakeToJavaStyle()
            if (spec.nickname == newName) {
                newName
            } else if (operations.any { it.nickname == newName }) {
                "{@link #$newName}"
            } else {
                "<code>vips_${match.groups[1]!!.value}</code>"
            }
        }

        girDoc = girDoc.replace("#(VIPS_[A-Z0-9-_]*)".toRegex()) { match ->
            val identifierName = match.groups[1]!!.value
            val matchedParentEnum = enums.firstOrNull {
                it.values.any {
                    it.name == identifierName
                }
            }
            val matchedValue = matchedParentEnum?.values?.first { it.name == identifierName }
            if (matchedValue != null) {
                val enumName = "\$T#${matchedValue.name.removePrefix("VIPS_")}"
                referencedClassNames += ClassName.get("app.photofox.vipsffm.enums", matchedParentEnum.name)
                "{@link $enumName}"
            } else {
                "<code>$identifierName</code>"
            }
        }

        girDoc = girDoc.replace("%([A-Za-z0-9-_]*)".toRegex()) { match ->
            val matchedValue = match.groups[1]!!.value
            if (matchedValue.isBlank()) {
                match.groups[0]!!.value
            } else {
                "<code>$matchedValue</code>"
            }
        }

        girDoc = "<p>" + girDoc.replace("\n\n", "</p>\n\n<p>")
            .trim() + "</p>"

        girDoc = girDoc.replace("<(link|function)".toRegex(), "<code")
                        .replace("</(link|function)>".toRegex(), "</code>")
                        .replace("<table>".toRegex(), "<pre>{@code\n<table>")
                        .replace("</table>".toRegex(), "</table>\n}</pre>")
                        .replace("<emphasis>".toRegex(), "<b>")
                        .replace("</emphasis>".toRegex(), "</b>")
                        .replace("<=".toRegex(), "&le;")
                        .replace(">=".toRegex(), "&ge;")
                        .replace("<( |[0-9])".toRegex(), "&lt;$1")
                        .replace("( |[0-9])>".toRegex(), "$1&gt;")
                        .replace("<p>|[", "<pre>{@code ")
                        .replace("]|", "}</pre>")
                        .replace("</p>\n\n<p>(\\s)+".toRegex(), "\n\n$1")
                        .replace("<p><pre>".toRegex(), "<pre>")
                        .replace("</pre></p>".toRegex(), "</pre>")
                        .replace("([ \n])(linkend|foreground)=\"([A-Za-z0-9-_]*)\"".toRegex(), "") // todo - filter all unknown attributes?

        method.addJavadoc(girDoc, *referencedClassNames.toTypedArray())
    }

    private fun mapPoetTypeToVipsOptionType(
        poetArgType: TypeName,
        spec: VipsOperationArgument
    ): ClassName {
        val vipsOptionType = when (poetArgType) {
            stringType -> vipsOptionStringType
            boxedIntType, TypeName.INT -> vipsOptionIntType
            boxedBooleanType, TypeName.BOOLEAN -> vipsOptionBooleanType
            boxedDoubleType, TypeName.DOUBLE -> vipsOptionDoubleType
            boxedLongType, TypeName.LONG -> vipsOptionLongType
            vimageType -> vipsOptionImageType
            vsourceType -> vipsOptionSourceType
            vtargetType -> vipsOptionTargetType
            vInterpolateType -> vipsOptionInterpolateType
            vEnumType -> vipsOptionEnumType
            vblobType -> vipsOptionBlobType
            else -> {
                if (poetArgType is ParameterizedTypeName && poetArgType.rawType == listType) {
                    val parameterizedType = poetArgType.typeArguments.first()
                    when (parameterizedType) {
                        boxedDoubleType -> vipsOptionArrayDoubleType
                        boxedIntType -> vipsOptionArrayIntType
                        vimageType -> vipsOptionArrayImageType
                        else -> throw RuntimeException("unknown array type for option \"${spec.name}\": $poetArgType")
                    }
                } else if (spec.isEnum) {
                    vipsOptionEnumType
                } else {
                    throw RuntimeException("unknown type for option \"${spec.name}\": $poetArgType")
                }
            }
        }
        return vipsOptionType
    }

    private fun mapArgSpecToPoetType(
        it: VipsOperationArgument
    ): TypeName? {
        val argType = when (it.type) {
            is GValueType.Boolean -> TypeName.BOOLEAN
            is GValueType.Int -> TypeName.INT
            is GValueType.UInt64 -> TypeName.LONG
            is GValueType.Double -> TypeName.DOUBLE
            is GValueType.CharArray -> stringType
            is GValueType.Enum -> TypeName.INT
            is GValueType.Flags -> TypeName.INT
            is GValueType.Object -> null
            is GValueType.VipsImage -> vimageType
            is GValueType.VipsArrayInt -> ParameterizedTypeName.get(listType, boxedIntType)
            is GValueType.VipsArrayDouble -> ParameterizedTypeName.get(listType, boxedDoubleType)
            is GValueType.VipsArrayImage -> ParameterizedTypeName.get(listType, vimageType)
            is GValueType.VipsRefString -> stringType
            is GValueType.VipsBlob -> vblobType
            is GValueType.VipsSource -> vsourceType
            is GValueType.VipsTarget -> vtargetType
            is GValueType.VipsInterpolate -> vInterpolateType
            is GValueType.Unknown -> {
                if (it.isEnum) {
                    ClassName.get("app.photofox.vipsffm.enums", it.type.rawName)
                } else if (it.type.rawName.startsWith("Vips")) {
                    // presume unknown, non-enum types are flags
                    TypeName.INT
                } else {
                    null
                }
            }
        }
        return argType
    }

    private fun buildImageMethods(): List<MethodSpec> {
        val widthMethod = MethodSpec.methodBuilder("getWidth")
            .addModifiers(Modifier.PUBLIC)
            .returns(TypeName.INT)
            .addException(vipsErrorType)
            .addStatement("return \$T.image_get_width(this.address)", vipsHelperType)
            .build()
        val heightMethod = MethodSpec.methodBuilder("getHeight")
            .addModifiers(Modifier.PUBLIC)
            .returns(TypeName.INT)
            .addException(vipsErrorType)
            .addStatement("return \$T.image_get_height(this.address)", vipsHelperType)
            .build()
        val alphaMethod = MethodSpec.methodBuilder("hasAlpha")
            .addModifiers(Modifier.PUBLIC)
            .returns(TypeName.BOOLEAN)
            .addException(vipsErrorType)
            .addStatement("return \$T.image_hasalpha(this.address)", vipsHelperType)
            .build()
        val newFromFileMethod = MethodSpec.methodBuilder("newFromFile")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(arenaType, "arena")
            .addParameter(stringType, "path")
            .addParameter(vipsOptionVarargType, "options")
            .returns(vimageType)
            .varargs(true)
            .addException(vipsErrorType)
            .addStatement("var filename = \$T.filename_get_filename(arena, path)", vipsHelperType)
            .addStatement("var filenameOptions = \$T.filename_get_options(arena, filename)", vipsHelperType)
            .addStatement("var loader = \$T.foreign_find_load(arena, filename)", vipsHelperType)
            .addStatement("var filenameOption = \$T(\"filename\", filename)", vipsOptionStringType)
            .addStatement("var outOption = \$T(\"out\")", vipsOptionImageType)
            .addStatement("var callArgs = new ArrayList<>(Arrays.asList(options))")
            .addStatement("callArgs.add(filenameOption)")
            .addStatement("callArgs.add(outOption)")
            .addStatement("\$T.invokeOperation(arena, loader, filenameOptions, callArgs)", vipsInvokerType)
            .addStatement("return outOption.valueOrThrow()")
            .build()
        val newFromSourceMethod = MethodSpec.methodBuilder("newFromSource")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(arenaType, "arena")
            .addParameter(vsourceType, "source")
            .addParameter(stringType, "optionString")
            .addParameter(vipsOptionVarargType, "options")
            .returns(vimageType)
            .varargs(true)
            .addException(vipsErrorType)
            .addStatement("var loader = \$T.foreign_find_load_source(source.address)", vipsHelperType)
            .addStatement("var sourceOption = \$T(\"source\", source)", vipsOptionSourceType)
            .addStatement("var outOption = \$T(\"out\")", vipsOptionImageType)
            .addStatement("var callArgs = new ArrayList<>(Arrays.asList(options))")
            .addStatement("callArgs.add(sourceOption)")
            .addStatement("callArgs.add(outOption)")
            .addStatement("\$T.invokeOperation(arena, loader, optionString, callArgs)", vipsInvokerType)
            .addStatement("return outOption.valueOrThrow()")
            .build()
        val writeToFileMethod = MethodSpec.methodBuilder("writeToFile")
            .addModifiers(Modifier.PUBLIC)
            .addParameter(stringType, "path")
            .addParameter(vipsOptionVarargType, "options")
            .varargs(true)
            .addException(vipsErrorType)
            .addStatement("var filename = \$T.filename_get_filename(arena, path)", vipsHelperType)
            .addStatement("var filenameOptions = \$T.filename_get_options(arena, filename)", vipsHelperType)
            .addStatement("var loader = \$T.foreign_find_save(arena, filename)", vipsHelperType)
            .addStatement("var filenameOption = \$T(\"filename\", filename)", vipsOptionStringType)
            .addStatement("var inOption = \$T(\"in\", this)", vipsOptionImageType)
            .addStatement("var callArgs = new ArrayList<>(Arrays.asList(options))")
            .addStatement("callArgs.add(filenameOption)")
            .addStatement("callArgs.add(inOption)")
            .addStatement("\$T.invokeOperation(arena, loader, filenameOptions, callArgs)", vipsInvokerType)
            .build()
        val writeToImageMethod = MethodSpec.methodBuilder("write")
            .addModifiers(Modifier.PUBLIC)
            .addParameter(vimageType, "out")
            .addException(vipsErrorType)
            .returns(vimageType)
            .addStatement("\$T.image_write(this.address, out.address)", vipsHelperType)
            .addStatement("return out", vimageType)
            .build()
        val writeToTargetMethod = MethodSpec.methodBuilder("writeToTarget")
            .addModifiers(Modifier.PUBLIC)
            .addParameter(vtargetType, "target")
            .addParameter(stringType, "suffix")
            .varargs(true)
            .addParameter(vipsOptionVarargType, "options")
            .addException(vipsErrorType)
            .addStatement("var loader = \$T.foreign_find_save_target(arena, suffix)", vipsHelperType)
            .addStatement("var inOption = \$T(\"in\", this)", vipsOptionImageType)
            .addStatement("var targetOption = \$T(\"target\", target)", vipsOptionTargetType)
            .addStatement("var callArgs = new ArrayList<>(Arrays.asList(options))")
            .addStatement("callArgs.add(inOption)")
            .addStatement("callArgs.add(targetOption)")
            .addStatement("\$T.invokeOperation(arena, loader, callArgs)", vipsInvokerType)
            .build()
        val newImageMethod = MethodSpec.methodBuilder("newImage")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(arenaType, "arena")
            .addException(vipsErrorType)
            .returns(vimageType)
            .addStatement("var newImagePointer = \$T.image_new(arena)", vipsHelperType)
            .addStatement("return new \$T(arena, newImagePointer)", vimageType)
            .build()
        return listOf(
            widthMethod,
            heightMethod,
            alphaMethod,
            newFromFileMethod,
            newFromSourceMethod,
            writeToFileMethod,
            writeToImageMethod,
            writeToTargetMethod,
            newImageMethod
        )
    }

    data class DiscoveredEnum(
        val name: String,
        val values: List<EnumValue>
    )

    data class EnumValue(
        val name: String,
        val nickname: String,
        val rawValue: Int
    )

    private fun discoverEnumClass(arena: Arena, parentName: String): DiscoveredEnum {
        val gtype = VipsRaw.g_type_from_name(arena.allocateFrom(parentName))
        val genumclass = VipsRaw.g_type_class_ref(gtype)
        val numValues = GEnumClass.n_values(genumclass)
        val valuesPointer = GEnumClass.values(genumclass)

        val values = (0 ..< numValues).map { index ->
            val enumValuePointer = valuesPointer.asSlice(index * GEnumValue.layout().byteSize())
            val enumValueName = GEnumValue.value_name(enumValuePointer).getString(0)
            val enumValueRawValue = GEnumValue.value(enumValuePointer)
            val enumValueNickname = GEnumValue.value_nick(enumValuePointer).getString(0)

            EnumValue(
                name = enumValueName,
                nickname = enumValueNickname,
                rawValue = enumValueRawValue
            )
        }
        return DiscoveredEnum(
            name = parentName,
            values = values
        )
    }

    private fun buildEnumClass(spec: DiscoveredEnum) {
        val parentName = spec.name
        logger.info("generating enum ${spec.name}")

        val enumClassBuilder = TypeSpec.enumBuilder(parentName)
            .addModifiers(Modifier.PUBLIC)
            .addField(
                FieldSpec.builder(stringType, "parentName")
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                    .initializer("\$S", parentName)
                    .build()
            )
            .addField(
                FieldSpec.builder(stringType, "vipsName")
                    .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
                    .build()
            )
            .addField(
                FieldSpec.builder(stringType, "vipsNickname")
                    .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
                    .build()
            )
            .addField(
                FieldSpec.builder(TypeName.INT, "rawValue")
                    .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
                    .build()
            )
            .addSuperinterface(vNamedEnumType)
            .addMethod(
                MethodSpec.constructorBuilder()
                    .addParameter(ParameterSpec.builder(stringType, "vipsName").build())
                    .addParameter(ParameterSpec.builder(stringType, "vipsNickname").build())
                    .addParameter(ParameterSpec.builder(TypeName.INT, "rawValue").build())
                    .addStatement("this.vipsName = vipsName")
                    .addStatement("this.vipsNickname = vipsNickname")
                    .addStatement("this.rawValue = rawValue")
                    .build()
            )
            .addMethod(
                MethodSpec.methodBuilder("getName")
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override::class.java)
                    .returns(stringType)
                    .addStatement("return this.vipsName")
                    .build()
            )
            .addMethod(
                MethodSpec.methodBuilder("getNickname")
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override::class.java)
                    .returns(stringType)
                    .addStatement("return this.vipsNickname")
                    .build()
            )
            .addMethod(
                MethodSpec.methodBuilder("getRawValue")
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override::class.java)
                    .returns(TypeName.INT)
                    .addStatement("return this.rawValue")
                    .build()
            )
        spec.values.forEach {
            enumClassBuilder.addEnumConstant(
                it.name.removePrefix("VIPS_"),
                TypeSpec.anonymousClassBuilder("\$S, \$S, \$L",it.name, it.nickname, it.rawValue).build()
            )
        }
        val enumClass = enumClassBuilder.build()
        val enumFile = JavaFile.builder("app.photofox.vipsffm.enums", enumClass)
            .build()
        val targetedGeneratedSourceRoot = Path.of("core/src/main/java")
        enumFile.writeToPath(targetedGeneratedSourceRoot, Charsets.UTF_8)
    }
}

private fun String.capitalizeVipsText(): String {
    return this.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(
            Locale.getDefault()
        ) else it.toString()
    }
}
