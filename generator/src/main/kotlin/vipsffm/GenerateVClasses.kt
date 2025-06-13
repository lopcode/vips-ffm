package vipsffm

import app.photofox.vipsffm.jextract.GEnumClass
import app.photofox.vipsffm.jextract.GEnumValue
import app.photofox.vipsffm.jextract.VipsRaw
import com.palantir.javapoet.ArrayTypeName
import com.palantir.javapoet.ClassName
import com.palantir.javapoet.CodeBlock
import com.palantir.javapoet.FieldSpec
import com.palantir.javapoet.JavaFile
import com.palantir.javapoet.MethodSpec
import com.palantir.javapoet.ParameterSpec
import com.palantir.javapoet.ParameterizedTypeName
import com.palantir.javapoet.TypeName
import com.palantir.javapoet.TypeSpec
import org.slf4j.LoggerFactory
import vipsffm.GenerateVipsHelperClass.fromSnakeToJavaStyle
import java.lang.foreign.Arena
import java.nio.file.Path
import java.util.Arrays
import java.util.Locale
import java.util.Objects
import javax.lang.model.element.Modifier
import kotlin.io.path.writeText

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
    private val vipsRawType = ClassName.get("app.photofox.vipsffm.jextract", "VipsRaw")
    private val vNamedEnumType = ClassName.get("app.photofox.vipsffm", "VNamedEnum")
    private val deprecatedAnnotationType = ClassName.get("java.lang", "Deprecated")
    private val inputStreamType = ClassName.get("java.io", "InputStream")
    private val outputStreamType = ClassName.get("java.io", "OutputStream")
    private val listStringType = ParameterizedTypeName.get(listType, stringType)
    private val vipsImageMapFnType = ClassName.get("app.photofox.vipsffm.jextract", "VipsImageMapFn")

    @JvmStatic fun main(args: Array<String>) {
        val discoveredOperations = Arena.ofConfined().use {
            DiscoverVipsOperations.run(it)
        }
        val operations = discoveredOperations.operations

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
                discoverEnumClass(arena, it, discoveredOperations.enums)
            }
        }
        discoveredEnums.forEach {
            buildEnumClass(it, operations, discoveredEnums)
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
            if (operation.isDeprecated) {
                // skip
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
            .addParameter(ClassName.OBJECT, "o")
            .returns(TypeName.BOOLEAN)
            .addStatement("if (this == o) return true")
            .addStatement("if (!(o instanceof \$T vImage)) return false", vimageType)
            .addStatement("return Objects.equals(arena, vImage.arena) && Objects.equals(address, vImage.address)")
            .build()
        val unsafeStructAddress = MethodSpec.methodBuilder("getUnsafeStructAddress")
            .addJavadoc("Gets the raw [MemorySegment] (C pointer) for this VipsImage struct")
            .addJavadoc("\n\nThe memory address' lifetime is bound to the scope of the [#arena]")
            .addJavadoc("\n\nUsage of the memory address is strongly discouraged, but it is available if some functionality is missing and you need to use it with [VipsHelper]")
            .addStatement("return this.address")
            .returns(memorySegmentType)
            .addModifiers(Modifier.PUBLIC)
            .build()
        val vipsClass = TypeSpec.classBuilder(vimageType.topLevelClassName())
            .addJavadoc("A generated wrapper representing a VipsImage. Do not edit.")
            .addJavadoc("\n[libvips api docs](https://www.libvips.org/API/current/api-index-full.html)")
            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
            .addMethod(ctor)
            .addMethod(hashCode)
            .addMethod(equals)
            .addMethod(unsafeStructAddress)
            .addMethods(operationMethods)
            .addMethods(imageMethods)
            .addField(arenaType, "arena", Modifier.PRIVATE, Modifier.FINAL)
            .addField(memorySegmentType, "address", Modifier.FINAL)
            .build()
        val javaFile = JavaFile.builder("app.photofox.vipsffm", vipsClass)
            .build()
            .toString()
            .let {
                JavadocMarkdownConversion.convert(it)
            }
        val targetGeneratedSourceRoot = Path.of("core/src/main/java/app/photofox/vipsffm")
        targetGeneratedSourceRoot.resolve("VImage.java").writeText(javaFile, Charsets.UTF_8)
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

        var firstSpottedImageInputIndex = -1
        val filteredPoetArgs = poetArguments.filterIndexed { index, poetArg ->
            val argSpec = requiredArguments[index]
            val isImageInput = argSpec.isInput && (argSpec.type == GValueType.VipsImage)
            if (isImageInput && (firstSpottedImageInputIndex < 0)) {
                // discard first image input - it'll be "this image"
                firstSpottedImageInputIndex = index
                return@filterIndexed false
            }
            val keepArg = !argSpec.isOutput
            keepArg
        }

        val firstOutput = poetArguments.filterIndexed { index, poetArg ->
            val argSpec = requiredArguments[index]
            argSpec.isOutput && argSpec.isRequired
        }.firstOrNull()

        val returnType = firstOutput?.type() ?: TypeName.VOID
        method.returns(returnType)
        method.varargs(true)
        method.addException(vipsErrorType)
        method.addModifiers(Modifier.PUBLIC)

        var referencedSelf = false
        poetArguments.forEachIndexed { index, poetArg ->
            val argSpec = requiredArguments[index]
            val poetArgType = poetArg.type()
            val vipsOptionType = mapPoetTypeToVipsOptionType(poetArgType, argSpec)
            if (argSpec.isOutput) {
                method.addStatement("var ${poetArg.name()}Option = \$T(\"${argSpec.name}\")", vipsOptionType)
            } else if (argSpec.isInput) {
                if (poetArg.type() == vimageType && !filteredPoetArgs.contains(poetArg)) {
                    // it's an image type, and doesn't refer to "this image"
                    referencedSelf = true
                    method.addStatement("var ${poetArg.name()}Option = \$T(\"${argSpec.name}\", this)", vipsOptionType)
                } else if (poetArg.type() == vEnumType) {
                    method.addStatement(
                        "var ${poetArg.name()}Option = \$T(\"${argSpec.name}\", ${poetArg.name()}.getRawValue())",
                        vipsOptionType
                    )
                } else {
                    method.addStatement(
                        "var ${poetArg.name()}Option = \$T(\"${argSpec.name}\", ${poetArg.name()})",
                        vipsOptionType
                    )
                }
            }
        }
        method.addStatement("var callArgs = new \$T<>(\$T.asList(args))", ArrayList::class.java, Arrays::class.java)
        poetArguments.forEachIndexed { index, poetArg ->
            val argSpec = requiredArguments[index]
            method.addStatement("callArgs.add(${poetArg.name()}Option)")
        }
        method.addStatement("\$T.invokeOperation(arena, \"${spec.nickname}\", callArgs)", vipsInvokerType);
        if (returnType != TypeName.VOID) {
            method.addStatement("return ${firstOutput!!.name()}Option.valueOrThrow()")
        }

        generateMethodJavadoc(method, methodName, spec, operations, enums)
        if (!referencedSelf) {
            method.addJavadoc("\n@param arena The arena that bounds resulting memory allocations during this operation")
        }
        poetArguments.forEachIndexed { index, poetArg ->
            if (!filteredPoetArgs.contains(poetArg)) {
                return@forEachIndexed
            }
            val argSpec = requiredArguments[index]
            var argNameSection = poetArg.name()
            if (argSpec.isEnum) {
                val enumName = (argSpec.type as GValueType.Unknown).rawName
                argNameSection += " [\$T]"
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
            var optionName = "[${vipsOptionType.simpleNames().first()}]"
            if (it.isEnum) {
                val enumName = (it.type as GValueType.Unknown).rawName
                optionName += " [\$T]"
                method.addJavadoc("\n@optionalArg ${it.name} $optionName ${it.blurb.capitalizeVipsText()}", ClassName.get("app.photofox.vipsffm.enums", enumName))
            } else {
                method.addJavadoc("\n@optionalArg ${it.name} $optionName ${it.blurb.capitalizeVipsText()}")
            }
        }

        if (!referencedSelf) {
            method.addModifiers(Modifier.STATIC)
            method.addParameter(
                ParameterSpec.builder(arenaType, "arena").build()
            )
        }
        method.addParameters(filteredPoetArgs)
        method.addParameter(vipsOptionVarargType, "args")

        return method.build()
    }

    private fun generateMethodJavadoc(
        method: MethodSpec.Builder,
        methodName: String,
        spec: VipsOperation,
        operations: List<VipsOperation>,
        enums: List<DiscoveredEnum>
    ) {
        if (spec.gir?.doc == null) {
            method.addJavadoc(spec.description.capitalizeVipsText())
            return
        }

        val pair = buildJavadoc(spec.gir.doc, methodName, operations, enums)
        var girDoc = pair.first
        val referencedClassNames = pair.second

        method.addJavadoc(girDoc, *referencedClassNames.toTypedArray())
    }

    private fun generateEnumJavadoc(
        enum: TypeSpec.Builder,
        methodName: String,
        doc: String?,
        operations: List<VipsOperation>,
        enums: List<DiscoveredEnum>
    ) {
        if (doc == null) {
            return
        }

        val pair = buildJavadoc(doc, methodName, operations, enums)
        val girDoc = pair.first
        val referencedClassNames = pair.second

        enum.addJavadoc(girDoc, *referencedClassNames.toTypedArray())
    }

    data class ClassMatch(
        val className: ClassName,
        val matchPosition: Int
    )

    private fun buildJavadoc(
        doc: String,
        name: String,
        operations: List<VipsOperation>,
        enums: List<DiscoveredEnum>
    ): Pair<String, List<ClassName>> {
        var girDoc = doc.replace("$", "$$")

        val classReferences = mutableListOf<ClassMatch>()

        val seeAlsoReferences = mutableListOf<String>()
        // parse known "sections"
        // example: ::: tip "Optional arguments"
        girDoc = girDoc.replace("\n?:::(.*)\n([\\s\\S]+?)(?:$|\n\n)".toRegex()) { match ->
            val sectionName = match.groups[1]?.value?.trim() ?: ""
            val sectionDetail = match.groups[2]?.value?.trim() ?: ""
            when {
                sectionName.startsWith("tip") -> {
                    val tipName = sectionName
                        .removePrefix("tip")
                        .trim(' ', '"')
                    when (tipName.lowercase(Locale.ENGLISH)) {
                        // verifying the docs are laid out how we expect
                        "optional arguments" -> Unit
                        // avoid unexpected surprises across versions
                        else -> throw RuntimeException("unknown tip type: $tipName")
                    }
                }
                sectionName == "seealso" -> {
                    // expect a comma separated list of references
                    val seeAlsos = sectionDetail
                        .split(",")
                        .map { it.trim(' ', '.', ',', '\n') }
                        .filter { it.isNotBlank() }
                    if (seeAlsos.isEmpty()) {
                        throw RuntimeException("unexpected empty seealso list")
                    }
                    seeAlsoReferences.addAll(seeAlsos)
                }
                else -> throw RuntimeException("unexpected section type: $sectionName")
            }
            "" // always remove sections
        }

        // replace gir markdown references
        girDoc = girDoc.replace("\\[([A-Za-z0-9-_]+)@([A-Za-z0-9-_.:]+)]".toRegex()) { match ->
            return@replace convertGirReferenceToPoetReference(
                match.value,
                match.range.first,
                enums,
                operations,
                classReferences
            )
        }

        girDoc = girDoc.replace("([\\n\\s]+)@([A-Za-z0-9-_]+)".toRegex()) { match ->
            // single @ references
            val whitespace = match.groups[1]!!.value
            val matchName = match.groups[2]!!.value
            "$whitespace`$matchName`"
        }

        if (seeAlsoReferences.isNotEmpty()) {
            val references = seeAlsoReferences.joinToString(", ") {
                convertGirReferenceToPoetReference(
                    it,
                    girDoc.length,
                    enums,
                    operations,
                    classReferences
                )
            }
            girDoc += "\nSee also: $references"
        }

        val orderedClassReferences = classReferences.sortedBy { it.matchPosition }.map { it.className }
        return Pair(girDoc, orderedClassReferences)
    }

    private fun convertGirReferenceToPoetReference(
        match: String,
        matchPosition: Int,
        enums: List<DiscoveredEnum>,
        operations: List<VipsOperation>,
        classReferences: MutableList<ClassMatch>
    ): String {
        // examples:
        // * [ctor@Image.new_from_file]
        // * [enum@Vips.BandFormat.UCHAR]
        // * "@something" - references a local parameter
        val trimmed = match.removeSurrounding("[", "]")
        val matchType = trimmed.substringBefore('@', "")
        val matchName = trimmed.substringAfter('@', "")
        if (matchType.isBlank() && matchName.isBlank()) {
            throw RuntimeException("unexpected format for reference: $match")
        }

        return when (matchType) {
            "enum" -> {
                var matchParts = matchName.split(".")
                if (matchParts[0] == "Vips") {
                    matchParts = matchParts.drop(1)
                }
                val enumName = matchParts[0]
                val matchedParentEnum = enums.firstOrNull {
                    it.gir.name.equals(enumName, ignoreCase = true)
                }
                if (matchedParentEnum == null) {
                    throw RuntimeException("unknown enum: $matchParts")
                }
                val classReference = ClassMatch(
                    ClassName.get("app.photofox.vipsffm.enums", matchedParentEnum.name),
                    matchPosition
                )
                if (matchParts.size == 1) {
                    // a direct reference to an enum
                    classReferences += classReference
                    return "[\$T]"
                }
                // otherwise, includes an enum value reference
                val enumValue = matchParts[1]
                val matchedValue =
                    matchedParentEnum.values.firstOrNull { it.nickname.equals(enumValue, ignoreCase = true) }
                if (matchedValue != null) {
                    classReferences += classReference
                    return "[\$T#${matchedValue.name.removePrefix("VIPS_")}]"
                }
                "`$matchName`" // fallback
            }

            "method", "func", "ctor" -> {
                val matchParts = matchName.split(".")
                if (matchParts[0] == "Image") {
                    val submatchName = matchParts[1]
                    val matchedOperation = operations.firstOrNull {
                        it.nickname.equals(submatchName, ignoreCase = true)
                    }
                    if (matchedOperation == null) {
                        return "`$matchName`"
                    }
                    val methodName = matchedOperation.nickname.fromSnakeToJavaStyle()
                    classReferences += ClassMatch(vimageType, matchPosition)
                    return "[\$T#$methodName]"
                }
                "`$matchName`" // fallback
            }
            "class" -> "`$matchName`"
            "struct" -> "`$matchName`"
            "const" -> "`$matchName`"
            "alias" -> "`$matchName`"
            "flags" -> "`$matchName`"
            "signal" -> "`$matchName`"
            else -> {
                throw RuntimeException("unsupported gir lookup type: $matchType")
            }
        }
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
                if (poetArgType is ParameterizedTypeName && poetArgType.rawType() == listType) {
                    val parameterizedType = poetArgType.typeArguments().first()
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
        val newFromSourceNoOptionsMethod = MethodSpec.methodBuilder("newFromSource")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(arenaType, "arena")
            .addParameter(vsourceType, "source")
            .addParameter(vipsOptionVarargType, "options")
            .returns(vimageType)
            .varargs(true)
            .addException(vipsErrorType)
            .addStatement("return newFromSource(arena, source, \"\", options)")
            .build()
        val newFromBytesMethod = MethodSpec.methodBuilder("newFromBytes")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(arenaType, "arena")
            .addParameter(ArrayTypeName.of(TypeName.BYTE), "bytes")
            .addParameter(stringType, "optionString")
            .addParameter(vipsOptionVarargType, "options")
            .returns(vimageType)
            .varargs(true)
            .addException(vipsErrorType)
            .addStatement("var source = \$T.newFromBytes(arena, bytes)", vsourceType)
            .addStatement("return newFromSource(arena, source, optionString, options)")
            .addJavadoc("Creates a new VImage from raw bytes. Note that this is quite inefficient, use [VImage#newFromFile] and friends instead.")
            .build()
        val newFromBytesNoOptionsMethod = MethodSpec.methodBuilder("newFromBytes")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(arenaType, "arena")
            .addParameter(ArrayTypeName.of(TypeName.BYTE), "bytes")
            .addParameter(vipsOptionVarargType, "options")
            .returns(vimageType)
            .varargs(true)
            .addException(vipsErrorType)
            .addStatement("var source = \$T.newFromBytes(arena, bytes)", vsourceType)
            .addStatement("return newFromSource(arena, source, options)")
            .addJavadoc("See [VImage#newFromBytes]")
            .build()
        val newFromStreamMethod = MethodSpec.methodBuilder("newFromStream")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(arenaType, "arena")
            .addParameter(inputStreamType, "stream")
            .addParameter(stringType, "optionString")
            .addParameter(vipsOptionVarargType, "options")
            .returns(vimageType)
            .varargs(true)
            .addException(vipsErrorType)
            .addStatement("var source = \$T.newFromInputStream(arena, stream)", vsourceType)
            .addStatement("return newFromSource(arena, source, optionString, options)")
            .addJavadoc("""
                Creates a new VImage from an [InputStream]. This uses libvips' "custom streaming" feature and is
                therefore quite efficient, avoiding the need to make extra full copies of the image's data.
                You could, for example, use this function to create an image directly from an API call, thumbnail it,
                and then upload directly to an S3-compatible API efficiently in memory - all without creating a local
                file.
                """.trimIndent())
            .build()
        val newFromStreamNoOptionsMethod = MethodSpec.methodBuilder("newFromStream")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(arenaType, "arena")
            .addParameter(inputStreamType, "stream")
            .addParameter(vipsOptionVarargType, "options")
            .returns(vimageType)
            .varargs(true)
            .addException(vipsErrorType)
            .addStatement("var source = \$T.newFromInputStream(arena, stream)", vsourceType)
            .addStatement("return newFromSource(arena, source, options)")
            .addJavadoc("See [VImage#newFromStream]")
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
            .addStatement("return out")
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
        val writeToStreamMethod = MethodSpec.methodBuilder("writeToStream")
            .addModifiers(Modifier.PUBLIC)
            .addParameter(outputStreamType, "stream")
            .addParameter(stringType, "suffix")
            .varargs(true)
            .addParameter(vipsOptionVarargType, "options")
            .addException(vipsErrorType)
            .addStatement("var target = \$T.newFromOutputStream(arena, stream)", vtargetType)
            .addStatement("this.writeToTarget(target, suffix, options)")
            .addJavadoc("""
                Writes this VImage to an [OutputStream]. This uses libvips' "custom streaming" feature and is
                therefore quite efficient, avoiding the need to make extra full copies of the image's data.
                You could, for example, use this function to create an image directly from an API call, thumbnail it,
                and then upload directly to an S3-compatible API efficiently in memory - all without creating a local
                file.
            """.trimIndent())
            .build()
        val newImageMethod = MethodSpec.methodBuilder("newImage")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(arenaType, "arena")
            .addException(vipsErrorType)
            .returns(vimageType)
            .addStatement("var newImagePointer = \$T.image_new(arena)", vipsHelperType)
            .addStatement("return new \$T(arena, newImagePointer)", vimageType)
            .build()

        val getSetMethods = buildImageGetSetMethods()

        return listOf(
            widthMethod,
            heightMethod,
            alphaMethod,
            newFromFileMethod,
            newFromSourceMethod,
            newFromSourceNoOptionsMethod,
            newFromBytesMethod,
            newFromBytesNoOptionsMethod,
            newFromStreamMethod,
            newFromStreamNoOptionsMethod,
            writeToFileMethod,
            writeToImageMethod,
            writeToTargetMethod,
            writeToStreamMethod,
            newImageMethod
        ) + getSetMethods
    }

    private fun buildImageGetSetMethods(): List<MethodSpec> {
        // image_get_(string|int|double)
        // image_set_(string|int|double)
        // image_set_array_(string|int|double)
        // image_set_array_(string|int|double)

        val methods = mutableListOf<MethodSpec>()

        val types = listOf("string", "int", "double", "blob", "image")
        types.forEach { typeName ->
            val titlecasedTypename = typeName.replaceFirstChar { it.titlecaseChar() }
            val poetValueType = when (typeName) {
                "string" -> stringType
                "int" -> boxedIntType
                "double" -> boxedDoubleType
                "blob" -> vblobType
                "image" -> vimageType
                else -> throw RuntimeException("unexpected type")
            }
            val setMethod = MethodSpec.methodBuilder("set")
                .addModifiers(Modifier.PUBLIC)
                .addParameter(stringType, "name")
                .addParameter(poetValueType, "value")
                .apply {
                    when (poetValueType) {
                        vblobType -> {
                            this.addStatement(
                                "\$T.image_set_$typeName(arena, this.address, name, \$T.NULL, value.address, value.byteSize())",
                                vipsHelperType,
                                memorySegmentType
                            )
                        }
                        vimageType -> {
                            this.addStatement(
                                "\$T.image_set_$typeName(arena, this.address, name, value.address)",
                                vipsHelperType
                            )
                        }
                        else -> {
                            this.addStatement(
                                "\$T.image_set_$typeName(arena, this.address, name, value)",
                                vipsHelperType
                            )
                        }
                    }
                }
                .addStatement("return this")
                .addJavadoc("""
                    Helper function to set the metadata stored at `name` on this image, of type `$typeName`
                    
                    See also: [libvips header docs](https://www.libvips.org/API/current/libvips-header.html)
                """.trimIndent())
                .returns(vimageType)
                .build()
            val getMethod = MethodSpec.methodBuilder("get$titlecasedTypename")
                .addModifiers(Modifier.PUBLIC)
                .addParameter(stringType, "name")
                .returns(poetValueType)
                .addStatement("var type = \$T.image_get_typeof(arena, this.address, name)", vipsHelperType)
                .addCode(
                    CodeBlock.builder()
                        .beginControlFlow("if (type == 0)")
                        .addStatement("return null")
                        .endControlFlow()
                        .build()
                )
                .addStatement("var outPointer = arena.allocate(\$T.C_POINTER)", vipsRawType)
                .apply {
                    when (poetValueType) {
                        vblobType -> {
                            this.addStatement("var outLengthPointer = arena.allocate(\$T.C_LONG)", vipsRawType)
                            this.addStatement("var result = \$T.image_get_$typeName(arena, this.address, name, outPointer, outLengthPointer)", vipsHelperType)
                        }
                        else -> {
                            this.addStatement("var result = \$T.image_get_$typeName(arena, this.address, name, outPointer)", vipsHelperType)
                        }
                    }
                }
                .addJavadoc("""
                    Helper function to get the metadata stored at `name` on this image, of type `$typeName`, or `null`
                    if not present

                    See also: [libvips header docs](https://www.libvips.org/API/current/libvips-header.html)
                """.trimIndent())
                .addCode(
                    CodeBlock.builder()
                        .beginControlFlow("if (!\$T.isValidResult(result))", vipsValidatorType)
                        .addStatement("\$T.throwVipsError(\"image_get_$typeName\")", vipsValidatorType)
                        .endControlFlow()
                        .build()
                )
                .addCode(
                    CodeBlock.builder()
                        .beginControlFlow("if (!\$T.isValidPointer(outPointer))", vipsValidatorType)
                        .addStatement("throw new VipsError(\"failed to read value of type $typeName from field: \" + name)")
                        .endControlFlow()
                        .build()
                )
                .apply {
                    when (poetValueType) {
                        stringType -> {
                            // const char **
                            this.addStatement("var dereferenced = outPointer.get(\$T.C_POINTER, 0)", vipsRawType)
                            this.addStatement("return dereferenced.getString(0)")
                        }
                        boxedIntType -> {
                            // int *
                            this.addStatement("return outPointer.get(\$T.C_INT, 0)", vipsRawType)
                        }
                        boxedDoubleType -> {
                            // double *
                            this.addStatement("return outPointer.get(\$T.C_DOUBLE, 0)", vipsRawType)
                        }
                        vblobType -> {
                            // void **
                            this.addStatement("var blobAddress = outPointer.get(\$T.C_POINTER, 0)", vipsRawType)
                            this.addStatement("return new VBlob(arena, blobAddress)")
                        }
                        vimageType -> {
                            // VImage **
                            this.addStatement("var imageAddress = outPointer.get(\$T.C_POINTER, 0).reinterpret(arena, \$T::g_object_unref)", vipsRawType, vipsRawType)
                            this.addStatement("return new VImage(arena, imageAddress)")
                        }
                        else -> throw RuntimeException("unexpected type")
                    }
                }
                .build()
            methods.add(getMethod)
            methods.add(setMethod)
        }

        // javapoet doesn't natively support block lambdas, so we have to do some of this manually
        // it's worth it to be able to use vips_image_map
        val fieldsLambda = CodeBlock.builder()
            .add("(_, name, _, _) -> {\n").indent()
            .add("if (!\$T.isValidPointer(name)) {\n", vipsValidatorType).indent()
            .add("return \$T.NULL;\n", memorySegmentType)
            .unindent().add("}\n")
            .add("fieldNameStrings.add(name.getString(0));\n")
            .add("return \$T.NULL;\n", memorySegmentType)
            .unindent().add("}")
            .build()
        val lambdaCall = CodeBlock.builder()
            .addStatement("\$T.Function fn = \$L", vipsImageMapFnType, fieldsLambda)
            .build()
        val fieldsMethod = MethodSpec.methodBuilder("getFields")
            .addModifiers(Modifier.PUBLIC)
            .returns(listStringType)
            .addStatement("var fieldNameStrings = new ArrayList<String>()")
            .addCode(lambdaCall)
            .addStatement("var callbackPointer = \$T.allocate(fn, arena)", vipsImageMapFnType)
            .addStatement("\$T.vips_image_map(this.address, callbackPointer, \$T.NULL)", vipsRawType, memorySegmentType)
            .addStatement("return fieldNameStrings")
            .addJavadoc("""
                Returns a list of all metadata entry names for this image
                
                See also: [libvips header docs](https://www.libvips.org/API/current/libvips-header.html)
            """.trimIndent())
            .build()

        methods.add(fieldsMethod)

        return methods
    }

    data class DiscoveredEnum(
        val name: String,
        val values: List<EnumValue>,
        val gir: DiscoverVipsOperations.GIRRepository.GIREnumeration
    )

    data class EnumValue(
        val name: String,
        val nickname: String,
        val rawValue: Int,
        val gir: DiscoverVipsOperations.GIRRepository.GIREnumerationMember
    )

    private fun discoverEnumClass(
        arena: Arena,
        parentName: String,
        enums: List<VipsEnum>
    ): DiscoveredEnum {
        val gtype = VipsRaw.g_type_from_name(arena.allocateFrom(parentName))
        val genumclass = VipsRaw.g_type_class_ref(gtype)
        val numValues = GEnumClass.n_values(genumclass)
        val valuesPointer = GEnumClass.values(genumclass)

        val girEnum = enums.first { it.gir.cType == parentName }

        val values = (0 ..< numValues).map { index ->
            val enumValuePointer = valuesPointer.asSlice(index * GEnumValue.layout().byteSize())
            val enumValueName = GEnumValue.value_name(enumValuePointer).getString(0)
            val enumValueRawValue = GEnumValue.value(enumValuePointer)
            val enumValueNickname = GEnumValue.value_nick(enumValuePointer).getString(0)

            val girEnumValue = girEnum.gir.members.first { it.cIdentifier == enumValueName }

            EnumValue(
                name = enumValueName,
                nickname = enumValueNickname,
                rawValue = enumValueRawValue,
                gir = girEnumValue
            )
        }
        return DiscoveredEnum(
            name = parentName,
            values = values,
            gir = girEnum.gir,
        )
    }

    private fun buildEnumClass(
        spec: DiscoveredEnum,
        operations: List<VipsOperation>,
        enums: List<DiscoveredEnum>
    ) {
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
            val constantSpec = TypeSpec.anonymousClassBuilder("\$S, \$S, \$L",it.name, it.nickname, it.rawValue)
            generateEnumJavadoc(constantSpec, it.name, it.gir.doc, operations, enums)
            enumClassBuilder.addEnumConstant(
                it.name.removePrefix("VIPS_"),
                constantSpec.build()
            )
        }
        generateEnumJavadoc(enumClassBuilder, parentName, spec.gir.doc, operations, enums)
        val enumClass = enumClassBuilder.build()
        val enumFile = JavaFile.builder("app.photofox.vipsffm.enums", enumClass)
            .build()
            .toString()
            .let {
                JavadocMarkdownConversion.convert(it)
            }
        val targetGeneratedSourceRoot = Path.of("core/src/main/java/app/photofox/vipsffm/enums")
        targetGeneratedSourceRoot.resolve("$parentName.java").writeText(enumFile, Charsets.UTF_8)
    }
}

private fun String.capitalizeVipsText(): String {
    return this.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(
            Locale.getDefault()
        ) else it.toString()
    }
}
