package vipsffm

import app.photofox.vipsffm.generated.VipsRaw
import com.squareup.javapoet.ArrayTypeName
import com.squareup.javapoet.ClassName
import com.squareup.javapoet.CodeBlock
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.TypeName
import com.squareup.javapoet.TypeSpec
import org.slf4j.LoggerFactory
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassModel
import java.lang.classfile.MethodModel
import java.lang.classfile.attribute.InnerClassesAttribute
import java.lang.constant.ClassDesc
import java.lang.constant.MethodTypeDesc
import java.nio.file.Files
import java.nio.file.Path
import java.util.Locale
import javax.lang.model.SourceVersion
import javax.lang.model.element.Modifier

object GenerateHelpers {

    private val logger = LoggerFactory.getLogger(GenerateHelpers::class.java)
    private val vipsValidatorType = ClassName.get("app.photofox.vipsffm.helper", "VipsValidation")
    private val vipsInvokerType = ClassName.get("app.photofox.vipsffm.helper", "VipsInvoker")
    private val vipsErrorType = ClassName.get("app.photofox.vipsffm.helper", "VipsError")
    private val vipsOptionType = ClassName.get("app.photofox.vipsffm.helper", "VipsOption")
    private val vipsOutputPointerType = ClassName.get("app.photofox.vipsffm.helper", "VipsOutputPointer")
    private val vipsRawType = ClassName.get("app.photofox.vipsffm.generated", "VipsRaw")
    private val memorySegmentType = ClassName.get("java.lang.foreign", "MemorySegment")
    private val stringType = ClassName.get("java.lang", "String")
    private val vipsOptionArrayType = ArrayTypeName.of(vipsOptionType)

    @JvmStatic
    fun main(args: Array<String>) {
        logger.info("generating helpers...")

        val basePath = Path.of("core/build/classes/java/main/")
        val sourceBasePath = Path.of("core/src/main/java/app/photofox/vipsffm/generated/")
        val vipsRawSourcePath = sourceBasePath.resolve("VipsRaw.java")
        val vipsRawSecondSourcePath = sourceBasePath.resolve("VipsRaw_1.java")
        val vipsSourceExternDefinitions = (Files.readAllLines(vipsRawSourcePath, Charsets.UTF_8) + Files.readAllLines(
            vipsRawSecondSourcePath,
            Charsets.UTF_8
        ))
            .filter { it.contains("* extern") }
            .map { it.trim().removePrefix("* extern ") }
            .toSet()
        val vipsRawClassModel = ClassFile.of().parse(basePath.resolve("app/photofox/vipsffm/generated/VipsRaw.class"))
        val vipsRawSecondClassModel =
            ClassFile.of().parse(basePath.resolve("app/photofox/vipsffm/generated/VipsRaw_1.class"))

        val simpleMethods = buildSimpleMethods(vipsRawClassModel, vipsSourceExternDefinitions)
        val variadicMethods = buildVariadicMethods(
            vipsRawClassModel,
            basePath,
            vipsSourceExternDefinitions
        ) + buildVariadicMethods(
            vipsRawSecondClassModel,
            basePath,
            vipsSourceExternDefinitions
        )

        logger.info("generated methods:")
        (simpleMethods + variadicMethods).forEach {
            logger.info("  ${it.name}")
        }

        buildVipsFile(simpleMethods, variadicMethods)

        logger.info("done 🎉")
    }

    private fun buildVariadicMethods(
        vipsRawClassModel: ClassModel,
        basePath: Path,
        vipsSourceExternDefinitions: Set<String>
    ): List<MethodSpec> {
        val candidateClasses = vipsRawClassModel.elementList().mapNotNull {
            if (it is InnerClassesAttribute) {
                return@mapNotNull it.classes().filter {
                    it.innerName().get().startsWith("vips_")
                }
            }
            return@mapNotNull null
        }.flatten()

        val variadicMethods = candidateClasses.mapNotNull {
            // type information for variadic functions are in the `apply` function in their static inner class
            val innerClassName = it.innerClass().asInternalName()
            val innerClassModel = ClassFile.of().parse(basePath.resolve("${innerClassName}.class"))
            val applyMethodCandidates = innerClassModel.methods().filter { it.methodName().stringValue() == "apply" }
            if (applyMethodCandidates.size < 1) {
                return@mapNotNull null
            }
            if (applyMethodCandidates.size > 1) {
                throw RuntimeException("expected one apply method")
            }
            val applyMethod = applyMethodCandidates.first()
            val rawMethodName = it.innerName().get().stringValue()
            val externMetadata = findExternMetadata(rawMethodName, vipsSourceExternDefinitions)

            return@mapNotNull buildVipsMethod(
                rawMethodName,
                true,
                applyMethod,
                externMetadata
            )
        }
        return variadicMethods
    }

    private fun buildVipsMethod(
        rawMethodName: String,
        isVariadic: Boolean,
        methodModel: MethodModel,
        externMetadata: ExternFunctionMetadata
    ): MethodSpec? {
        val newName = rawMethodName
            .removePrefix("vips_")
            .fromSnakeToJavaStyle()
        val qualifiedReturnType = methodModel.methodTypeSymbol().returnType()
        val typeDisplayName = qualifiedReturnType.displayName()
        val defaultReturnPoetType = classDescToPoetType(qualifiedReturnType, typeDisplayName)

        val methodTypeSymbol = methodModel.methodTypeSymbol()
        val args = buildPoetArgs(methodTypeSymbol, externMetadata)

        val vipsFunctionArgs = args.toMutableList()
        if (isVariadic) {
            vipsFunctionArgs.removeLast()
            vipsFunctionArgs += ParameterSpec.builder(vipsOptionArrayType, "invokerArgs").build()
        }
        val vipsFunctionArgsJoined = vipsFunctionArgs.joinToString {
            if (it.type == stringType) {
                it.name.removeSuffix("String")
            } else if (it.name == "out") {
                "${it.name}Pointer"
            } else {
                it.name
            }
        }

        var returnPoetType = defaultReturnPoetType
        val methodBuilder = MethodSpec.methodBuilder(newName)
            .addJavadoc(
            """
                Binding for:
                {@snippet lang=c :
                ${externMetadata.rawExternDefinition}
                }
            """.trimIndent()
            )
            .addParameters(args)
            .addException(vipsErrorType)
            .addModifiers(Modifier.PUBLIC)
            .returns(returnPoetType)

        if (isVariadic) {
            methodBuilder.varargs(true)
        }

        args.forEachIndexed { index, parameter ->
            val externArgMetadata = externMetadata.arguments[index]
            if (externArgMetadata.name == "out") {
                methodBuilder.addStatement("var outPointer = out.pointerOrNull\$\$internal()")
            } else if (externArgMetadata.pointerDepth == 1) {
                if (parameter.type == stringType) {
                    val newName = parameter.name.removeSuffix("String")
                    methodBuilder.addStatement("var $newName = arena.allocateFrom(${parameter.name})")
                } else {
                    methodBuilder.addCode(
                        makeInputValidatorCodeBlock(parameter.name, vipsValidatorType, rawMethodName)
                    )
                }
            }
        }

        if (isVariadic) {
            methodBuilder.addCode(
                CodeBlock.builder()
                    .addStatement("var layouts = \$T.makeInvokerVarargLayouts(options)", vipsInvokerType)
                    .addStatement("var invoker = \$T.$rawMethodName.makeInvoker(layouts)", vipsRawType)
                    .addStatement("var invokerArgs = \$T.makeInvokerVarargObjects(arena, options)", vipsInvokerType)
                    .build()
            )
        }

        if (returnPoetType != TypeName.VOID) {
            if (isVariadic) {
                methodBuilder
                    .addStatement("var result = invoker.apply($vipsFunctionArgsJoined)")
            } else {
                methodBuilder
                    .addStatement("var result = \$T.$rawMethodName($vipsFunctionArgsJoined)", VipsRaw::class.java)
            }

            if (returnPoetType == TypeName.INT) {
                // int return types denote a success/failure
                // we throw VipsError including error context on a failure
                // so instead we return void, and completion indicates success
                methodBuilder.addCode(makeResultValidatorCodeBlock(vipsValidatorType, rawMethodName))
                methodBuilder.returns(TypeName.VOID)
                returnPoetType = TypeName.VOID
            }

            args.forEachIndexed { index, parameterSpec ->
                val externArgMetadata = externMetadata.arguments[index]
                addDeallocCodeblockIfOutType(externArgMetadata, parameterSpec.name, methodBuilder)
            }

            if (returnPoetType == memorySegmentType) {
                methodBuilder.addCode(
                    makeOutputPointerValidatorCodeBlock(
                        "result",
                        vipsValidatorType,
                        rawMethodName
                    )
                )
            }

            val externType = externMetadata.returnType
            addDeallocCodeblockIfOutType(externType, "result", methodBuilder)
        } else {
            if (isVariadic) {
                methodBuilder
                    .addStatement("invoker.apply($vipsFunctionArgsJoined)")
            } else {
                methodBuilder
                    .addStatement("\$T.$rawMethodName($vipsFunctionArgsJoined)", VipsRaw::class.java)
            }
        }

        args.forEachIndexed { index, parameterSpec ->
            val externArgMetadata = externMetadata.arguments[index]
            if (parameterSpec.type == vipsOutputPointerType) {
                methodBuilder.addStatement("var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0)")
                val type = ClassName.get("app.photofox.vipsffm.generated", externArgMetadata.type)
                if (externArgMetadata.pointerDepth == 2) {
                    methodBuilder.addStatement(
                        "var reinterpretedOutPointer = \$T.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref)",
                        type
                    )
                    methodBuilder.addStatement("out.setReinterpretedPointer\$\$internal(reinterpretedOutPointer)")
                } else if (externArgMetadata.pointerDepth == 1) {
                    // todo: how do unknown types get reinterpreted?
                    methodBuilder.addStatement("out.setReinterpretedPointer\$\$internal(resultingOutPointer)")
                } else {
                    throw RuntimeException("unexpected pointer depth: ${externArgMetadata.pointerDepth}")
                }
            }
        }

        if (returnPoetType != TypeName.VOID) {
            if (externMetadata.returnType.type == "const char" && externMetadata.returnType.pointerDepth == 1) {
                methodBuilder.addStatement("return result.getString(0)") // todo: charset
                methodBuilder.returns(stringType)
            } else {
                methodBuilder.addStatement("return result")
            }
        }

        return methodBuilder.build()
    }

    private fun buildPoetArgs(
        methodTypeSymbol: MethodTypeDesc,
        externMetadata: ExternFunctionMetadata
    ): List<ParameterSpec> {
        val args = methodTypeSymbol.parameterArray().mapIndexedNotNull { index, parameter ->
            val externArgMetadata = externMetadata.arguments[index]
            if (externArgMetadata.type == "...") {
                ParameterSpec.builder(vipsOptionArrayType, "options").build()
            } else if (externArgMetadata.pointerDepth > 0 && externArgMetadata.name == "out") {
                ParameterSpec.builder(vipsOutputPointerType, externArgMetadata.name).build()
            } else if (parameter.displayName() == "MemorySegment" &&
                externArgMetadata.type == "const char" &&
                externArgMetadata.pointerDepth == 1
            ) {
                ParameterSpec.builder(stringType, "${externArgMetadata.name}String").build()
            } else {
                val typeName = classDescToPoetType(parameter, parameter.displayName())
                ParameterSpec.builder(typeName, externArgMetadata.name).build()
            }
        }
        return args
    }

    private fun addDeallocCodeblockIfOutType(
        externType: ExternType,
        parameterName: String,
        methodBuilder: MethodSpec.Builder
    ) {
        if (primitivesToPoetTypes.keys.contains(externType.type)) {
            // todo: dealloc primitives with a reinterpret?
            return
        }

        // newly allocated return types have a depth of 1
        val isNewReturnAlloc = (externType.name.isBlank() && externType.pointerDepth == 1 && externType.type != "const char")

        if (isNewReturnAlloc) {
            methodBuilder.addCode(
                CodeBlock.builder()
                    .addStatement(
                        "${externType.type}.reinterpret($parameterName, arena, \$T::g_object_unref)",
                        vipsRawType
                    )
                    .build()
            )
        }
    }

    private fun buildVipsFile(
        simpleMethods: List<MethodSpec>,
        variadicMethods: List<MethodSpec>,
    ) {
        logger.info("writing file...")
        val vipsValidatorType = ClassName.get("app.photofox.vipsffm.helper", "VipsValidation")

        val arenaType = ClassName.get("java.lang.foreign", "Arena")
        val stringType = ClassName.get("java.lang", "String")
        val primaryCtor = MethodSpec.constructorBuilder()
            .addParameter(arenaType, "arena")
            .addStatement("this(arena, \"vips-ffm\", false)")
            .addModifiers(Modifier.PUBLIC)
            .build()
        val secondaryCtor = MethodSpec.constructorBuilder()
            .addParameter(arenaType, "arena")
            .addParameter(stringType, "name")
            .addParameter(TypeName.BOOLEAN, "allowUntrusted")
            .addStatement("this.arena = arena")
            .addStatement("Vips.init(arena, name, allowUntrusted)")
            .addModifiers(Modifier.PUBLIC)
            .build()
        val initHelper = MethodSpec.methodBuilder("init")
            .returns(TypeName.VOID)
            .addParameters(
                listOf(
                    ParameterSpec.builder(arenaType, "arena").build(),
                    ParameterSpec.builder(stringType, "argv0").build(),
                    ParameterSpec.builder(TypeName.BOOLEAN, "allowUntrusted").build()
                )
            )
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addStatement("var nameCString = arena.allocateFrom(argv0)")
            .addStatement("var result = VipsRaw.vips_init(nameCString)")
            .addCode(
                makeResultValidatorCodeBlock(vipsValidatorType, "vips_init")
            )
            .addStatement("VipsRaw.vips_block_untrusted_set(allowUntrusted ? 0 : 1)")
            .build()
        val vipsClass = TypeSpec.classBuilder("Vips")
            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
            .addMethod(primaryCtor)
            .addMethod(secondaryCtor)
            .addMethod(initHelper)
            .addMethods(simpleMethods)
            .addMethods(variadicMethods)
            .addField(arenaType, "arena", Modifier.PRIVATE)
            .build()
        val javaFile = JavaFile.builder("app.photofox.vipsffm.generated", vipsClass)
            .build()
        val targetGeneratedSourceRoot = Path.of("helper/src/main/java/")
        javaFile.writeToPath(targetGeneratedSourceRoot, Charsets.UTF_8)
    }

    private fun makeResultValidatorCodeBlock(vipsValidatorType: ClassName, methodName: String): CodeBlock? =
        CodeBlock.builder()
            .beginControlFlow("if (!\$T.isValidResult(result))", vipsValidatorType)
            .addStatement("\$T.throwVipsError(\"$methodName\")", vipsValidatorType)
            .endControlFlow()
            .build()

    private fun buildSimpleMethods(
        model: ClassModel,
        vipsSourceExternDefinitions: Set<String>
    ): List<MethodSpec> {
        val simpleMethods = model.methods().filter {
            it.methodName().startsWith("vips_")
                && !it.methodName().contains("$")
        }.map {
            val externMetadata = findExternMetadata(it.methodName().stringValue(), vipsSourceExternDefinitions)

            val rawMethodName = it.methodName().stringValue()
            val qualifiedReturnType = it.methodTypeSymbol().returnType()

            return@map buildVipsMethod(rawMethodName, false, it, externMetadata)!!
        }
        return simpleMethods
    }

    private fun makeInputValidatorCodeBlock(
        argName: String,
        vipsValidatorType: ClassName?,
        rawMethodName: String?
    ): CodeBlock? = CodeBlock.builder()
        .beginControlFlow("if(!\$T.isValidPointer($argName))", vipsValidatorType)
        .addStatement(
            "\$T.throwInvalidInputError(\"${rawMethodName}\", \"$argName\")",
            vipsValidatorType
        )
        .endControlFlow()
        .build()

    private fun makeOutputPointerValidatorCodeBlock(
        pointerArgName: String,
        vipsValidatorType: ClassName?,
        rawMethodName: String?
    ): CodeBlock? = CodeBlock.builder()
        .beginControlFlow("if(!\$T.isValidPointer(${pointerArgName}))", vipsValidatorType)
        .addStatement(
            "\$T.throwInvalidOutputError(\"${rawMethodName}\", \"${pointerArgName}\")",
            vipsValidatorType
        )
        .endControlFlow()
        .build()

    private val primitivesToPoetTypes = mapOf(
        "void" to TypeName.VOID,
        "boolean" to TypeName.BOOLEAN,
        "byte" to TypeName.BYTE,
        "short" to TypeName.SHORT,
        "int" to TypeName.INT,
        "long" to TypeName.LONG,
        "char" to TypeName.CHAR,
        "float" to TypeName.FLOAT,
        "double" to TypeName.DOUBLE
    )

    private fun classDescToPoetType(
        qualifiedReturnType: ClassDesc,
        typeDisplayName: String?
    ): TypeName {
        val poetType = if (qualifiedReturnType.isPrimitive) {
            primitivesToPoetTypes[typeDisplayName] ?: throw RuntimeException("unknown primitive type: $typeDisplayName")
        } else {
            ClassName.get(qualifiedReturnType.packageName(), qualifiedReturnType.displayName())
        }
        return poetType
    }

    data class ExternFunctionMetadata(
        val rawExternDefinition: String,
        val returnType: ExternType,
        val arguments: List<ExternType>
    )

    data class ExternType(
        val raw: String,
        val name: String,
        val type: String,
        val pointerDepth: Int
    ) {
        override fun toString(): String {
            return "$type ${"*".repeat(pointerDepth)}$name"
        }
    }

    // Given a candidate function name, find its corresponding `extern` definition, and compute API metadata
    private fun findExternMetadata(
        candidateName: String,
        vipsSourceExternDefinitions: Set<String>
    ): ExternFunctionMetadata {
        val candidateDefinitions = vipsSourceExternDefinitions.filter {
            it.contains("$candidateName(") // char *vips_linear(
        }
        if (candidateDefinitions.size != 1) {
            throw RuntimeException("unexpected number of candidate definitions found: ${candidateDefinitions.size} $candidateName")
        }
        val candidateDefinition = candidateDefinitions.first()
        val returnTypeRaw = candidateDefinition.substringBefore(candidateName).toExternType()
        val arguments = candidateDefinition.substringAfter(candidateName)
            .trim('(', ')')
            .split(",")
            .map { it.trim() }
            .filterNot { it.isBlank() }
            .map { it.toExternType() }

        return ExternFunctionMetadata(
            rawExternDefinition = candidateDefinition,
            returnType = returnTypeRaw,
            arguments = arguments
        )
    }

    // sometimes, after transformation, names collide with java keywords
    // eg vips_case -> case
    //    vips_boolean -> boolean
    // this suffix gets added to colliding types
    private const val collissionSuffix = "1" // todo: better suffix for collisions?

    private fun String.toExternType(): ExternType {
        if (this.contains('*')) {
            val type = this.substringBefore('*').trim()
            var name = this.substringAfterLast('*').trim()
            if (primitivesToPoetTypes.keys.contains(name)) {
                name += collissionSuffix
            }
            return ExternType(this, name, type, this.count { it == '*' })
        } else {
            val type = this.substringBeforeLast(' ').trim()
            var name = this.substringAfterLast(' ').trim()
            if (primitivesToPoetTypes.keys.contains(name)) {
                name += collissionSuffix
            }
            return ExternType(this, name, type, 0)
        }
    }

    private fun String.fromSnakeToJavaStyle(): String {
        if (this.length == 1) {
            return this
        }
        val candidate = this
            .split('_')
            .filterNot { it.isBlank() }
            .joinToString("") { it.replaceFirstChar { it.uppercase(Locale.ENGLISH) } }
            .replaceFirstChar { it.lowercase(Locale.ENGLISH) }
        return if (SourceVersion.isKeyword(candidate)) {
            "${candidate}$collissionSuffix"
        } else {
            candidate
        }
    }
}