package vipsffm

import com.squareup.javapoet.ArrayTypeName
import com.squareup.javapoet.ClassName
import com.squareup.javapoet.CodeBlock
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
    private val vipsValidatorType = ClassName.get("app.photofox.vipsffm", "VipsValidation")

    @JvmStatic fun main(args: Array<String>) {
        System.loadLibrary("vips")

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

        generateVImageClass(operations)
    }

    private fun generateVImageClass(operations: List<VipsOperation>) {
        val operationMethods = operations.mapNotNull { operation ->
            val hasImageInput = operation.args.any { it.isInput && it.isRequired && it.type == GValueType.VipsImage }
            val hasImageOutput =
                operation.args.any { it.isOutput && it.isRequired && (it.type == GValueType.VipsImage || it.type == GValueType.VipsArrayImage) }
            if (!(hasImageInput || hasImageOutput)) {
                logger.info("skipping \"${operation.nickname}\" - no image inputs or outputs")
                return@mapNotNull null
            }
            buildOperationMethod(operation)
        }

        val imageMethods = buildImageMethods()

        val ctor = MethodSpec.constructorBuilder()
            .addParameter(arenaType, "arena")
            .addParameter(memorySegmentType, "address")
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
        val unsafeAddress = MethodSpec.methodBuilder("getUnsafeAddress")
            .addJavadoc("Gets the raw [MemorySegment] (C pointer) for this image")
            .addJavadoc("\nThe memory address' lifetime is bound to the scope of the [arena]")
            .addJavadoc("\nUsage of the memory address is strongly discouraged, but it is available if some functionality is missing and you need to use it with [VipsHelper]")
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
            .addMethod(unsafeAddress)
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

    private fun buildOperationMethod(spec: VipsOperation): MethodSpec {
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
        method.addJavadoc(spec.description.capitalizeVipsText())

        poetArguments.forEachIndexed { index, poetArg ->
            if (!filteredPoetArgs.contains(poetArg)) {
                return@forEachIndexed
            }
            val argSpec = requiredArguments[index]
            method.addJavadoc("\n@param ${poetArg.name} ${argSpec.blurb.capitalizeVipsText()}")
        }
        method.addJavadoc("\n@param args Array of VipsOption to apply to this operation")
        spec.args.forEach {
            if (it.isRequired || it.name == "nickname" || it.name == "description") {
                return@forEach
            }
            val poetType = mapArgSpecToPoetType(it)!!
            val vipsOptionType = mapPoetTypeToVipsOptionType(poetType, spec)
            val optionName = "{@link ${vipsOptionType.simpleNames().first()}}"
            method.addJavadoc("\n@optionalArg ${it.name} $optionName ${it.blurb.capitalizeVipsText()}")
        }

        poetArguments.forEachIndexed { index, poetArg ->
            val argSpec = requiredArguments[index]
            val poetArgType = poetArg.type
            val vipsOptionType = mapPoetTypeToVipsOptionType(poetArgType, spec)
            if (argSpec.isOutput) {
                method.addStatement("var ${poetArg.name}Option = \$T(\"${poetArg.name}\")", vipsOptionType)
            } else if (argSpec.isInput) {
                if (poetArg.type == vimageType) {
                    method.addStatement("var ${poetArg.name}Option = \$T(\"${poetArg.name}\", this)", vipsOptionType)
                } else {
                    method.addStatement(
                        "var ${poetArg.name}Option = \$T(\"${poetArg.name}\", ${poetArg.name})",
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

    private fun mapPoetTypeToVipsOptionType(
        poetArgType: TypeName,
        spec: VipsOperation
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
            vblobType -> vipsOptionBlobType
            else -> {
                if (poetArgType is ParameterizedTypeName && poetArgType.rawType == listType) {
                    val parameterizedType = poetArgType.typeArguments.first()
                    when (parameterizedType) {
                        boxedDoubleType -> vipsOptionArrayDoubleType
                        boxedIntType -> vipsOptionArrayIntType
                        vimageType -> vipsOptionArrayImageType
                        else -> throw RuntimeException("unknown array type for option in operation \"${spec.nickname}\": ${poetArgType}")
                    }
                } else {
                    throw RuntimeException("unknown type for option in operation \"${spec.nickname}\": ${poetArgType}")
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
            is GValueType.Unknown -> {
                if (it.type.rawName.startsWith("Vips")) {
                    // presume enum type
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
            .addStatement("var address = \$T.image_new_from_file(arena, path, options)", vipsHelperType)
            .addStatement("return new \$T(arena, address)", vimageType)
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
            .addStatement("var address = \$T.image_new_from_source(arena, source.address, optionString, options)", vipsHelperType)
            .addStatement("return new \$T(arena, address)", vimageType)
            .build()
        val writeToFileMethod = MethodSpec.methodBuilder("writeToFile")
            .addModifiers(Modifier.PUBLIC)
            .addParameter(stringType, "path")
            .addParameter(vipsOptionVarargType, "options")
            .varargs(true)
            .addException(vipsErrorType)
            .addStatement("\$T.image_write_to_file(this.arena, this.address, path, options)", vipsHelperType)
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
            .addStatement("var result = \$T.image_write_to_target(this.arena, this.address, suffix, target.address, options)", vipsHelperType)
            .addCode(
                CodeBlock.builder()
                    .beginControlFlow("if (!\$T.isValidResult(result))", vipsValidatorType)
                    .addStatement("\$T.throwVipsError(\"writeToTarget\")", vipsValidatorType)
                    .endControlFlow()
                    .build()
            )
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
}

private fun String.capitalizeVipsText(): String {
    return this.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(
            Locale.getDefault()
        ) else it.toString()
    }
}
