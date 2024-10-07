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
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassModel
import java.lang.classfile.MethodModel
import java.lang.classfile.attribute.InnerClassesAttribute
import java.lang.classfile.constantpool.Utf8Entry
import java.lang.constant.ClassDesc
import java.lang.constant.MethodTypeDesc
import java.nio.file.Files
import java.nio.file.Path
import java.util.Locale
import javax.lang.model.SourceVersion
import javax.lang.model.element.Modifier

object GenerateVipsHelperClass {

    private val logger = LoggerFactory.getLogger(GenerateVipsHelperClass::class.java)
    private val vipsValidatorType = ClassName.get("app.photofox.vipsffm", "VipsValidation")
    private val vipsInvokerType = ClassName.get("app.photofox.vipsffm", "VipsInvoker")
    private val vipsErrorType = ClassName.get("app.photofox.vipsffm", "VipsError")
    private val vipsOptionType = ClassName.get("app.photofox.vipsffm", "VipsOption")
    private val vipsRawType = ClassName.get("app.photofox.vipsffm.jextract", "VipsRaw")
    private val vImageType = ClassName.get("app.photofox.vipsffm", "VImage")
    private val memorySegmentType = ClassName.get("java.lang.foreign", "MemorySegment")
    private val arenaType = ClassName.get("java.lang.foreign", "Arena")
    private val stringType = ClassName.get("java.lang", "String")
    private val listType = ClassName.get("java.util", "List")
    private val listStringType = ParameterizedTypeName.get(listType, stringType)
    private val vipsOptionArrayType = ArrayTypeName.of(vipsOptionType)

    @JvmStatic
    fun main(args: Array<String>) {
        logger.info("generating helpers...")

        val basePath = Path.of("core/build/classes/java/main/")
        val sourceBasePath = Path.of("core/src/main/java/app/photofox/vipsffm/jextract/")
        val vipsRawSourcePath = sourceBasePath.resolve("VipsRaw.java")
        val vipsSourceExternDefinitions = Files.readAllLines(vipsRawSourcePath, Charsets.UTF_8)
            .filter { it.contains("* extern") }
            .map { it.trim().removePrefix("* extern ") }
            .toSet()
        val vipsRawClassModel = ClassFile.of().parse(basePath.resolve("app/photofox/vipsffm/jextract/VipsRaw.class"))

        val simpleMethods = buildSimpleMethods(
            vipsRawClassModel,
            vipsRawType,
            vipsSourceExternDefinitions
        )
        val variadicMethods = buildVariadicMethods(
            vipsRawClassModel,
            vipsRawType,
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
        classModel: ClassModel,
        poetClass: ClassName,
        basePath: Path,
        vipsSourceExternDefinitions: Set<String>
    ): List<MethodSpec> {
        val candidateClasses = classModel.elementList().mapNotNull {
            if (it is InnerClassesAttribute) {
                return@mapNotNull it.classes().filter {
                    val name = it.innerName().get()
                    isVipsMethodNameInScope(name)
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
            if (externMetadata == null) {
                logger.info("skipping $it - no extern metadata found")
                return@mapNotNull null
            }

            return@mapNotNull buildVipsMethod(
                rawMethodName,
                poetClass,
                true,
                applyMethod,
                externMetadata
            )
        }
        return variadicMethods
    }

    private fun buildVipsMethod(
        rawMethodName: String,
        rawPoetClass: ClassName,
        isVariadic: Boolean,
        methodModel: MethodModel,
        externMetadata: ExternFunctionMetadata
    ): MethodSpec? {
        val newName = rawMethodName
            .removePrefix("vips_")
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
        val vipsFunctionArgsJoined = vipsFunctionArgs.mapIndexed { index, parameterSpec ->
            val externArgMetadata = externMetadata.arguments.getOrNull(index)
            if (parameterSpec.type == listStringType) {
                parameterSpec.name.removeSuffix("StringArray")
            } else if (parameterSpec.type == stringType) {
                parameterSpec.name.removeSuffix("String")
            } else if (externArgMetadata?.type == "gboolean" && externArgMetadata.pointerDepth == 0) {
                parameterSpec.name.removeSuffix("Boolean")
            } else {
                parameterSpec.name
            }
        }.joinToString()

        var returnPoetType = defaultReturnPoetType
        val arenaArg = ParameterSpec.builder(arenaType, "arena").build()
        val methodBuilder = MethodSpec.methodBuilder(newName)
            .addJavadoc(
            """
                Binding for:
                {@snippet lang=c :
                ${externMetadata.rawExternDefinition}
                }
            """.trimIndent()
            )
            .addException(vipsErrorType)
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .returns(returnPoetType)

        if (isVariadic) {
            methodBuilder.varargs(true)
        }

        var usedArena = false

        args.forEachIndexed { index, parameter ->
            val externArgMetadata = externMetadata.arguments[index]
            if (externArgMetadata.type == "gboolean" && parameter.type == TypeName.BOOLEAN) {
                methodBuilder.addStatement("var ${parameter.name.removeSuffix("Boolean")} = ${parameter.name} ? 1 : 0")
            } else if (externArgMetadata.pointerDepth >= 1) {
                if (parameter.type == listStringType) {
                    val newName = parameter.name.removeSuffix("StringArray")
                    methodBuilder.addStatement("var $newName = \$T.makeCharStarArray(arena, ${newName}StringArray)", vipsInvokerType)
                    usedArena = true
                } else if (parameter.type == stringType) {
                    val newName = parameter.name.removeSuffix("String")
                    methodBuilder.addStatement("var $newName = arena.allocateFrom(${parameter.name})")
                    usedArena = true
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
                    .addStatement("var invoker = \$T.$rawMethodName.makeInvoker(layouts)", rawPoetClass)
                    .addStatement("var invokerArgs = \$T.makeInvokerVarargObjects(arena, options)", vipsInvokerType)
                    .build()
            )
            usedArena = true
        }

        if (returnPoetType != TypeName.VOID) {
            if (isVariadic) {
                methodBuilder
                    .addStatement("var result = invoker.apply($vipsFunctionArgsJoined)")
            } else {
                methodBuilder
                    .addStatement("var result = \$T.$rawMethodName($vipsFunctionArgsJoined)", rawPoetClass)
            }

            if (returnPoetType == TypeName.INT) {
                if (externMetadata.returnType.type == "gboolean") {
                    methodBuilder.returns(TypeName.BOOLEAN)
                    returnPoetType = TypeName.BOOLEAN
                }
            }

            args.forEachIndexed { index, parameterSpec ->
                val externArgMetadata = externMetadata.arguments[index]
                val deallocUsedArena = addDeallocCodeblockIfOutType(externArgMetadata, parameterSpec.type, parameterSpec.name, methodBuilder)
                if (deallocUsedArena) {
                    usedArena = true
                }
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
            val deallocUsedArena = addDeallocCodeblockIfOutType(externType, returnPoetType, "result", methodBuilder)
            if (deallocUsedArena) {
                usedArena = true
            }
        } else {
            if (isVariadic) {
                methodBuilder
                    .addStatement("invoker.apply($vipsFunctionArgsJoined)")
            } else {
                methodBuilder
                    .addStatement("\$T.$rawMethodName($vipsFunctionArgsJoined)", rawPoetClass)
            }
        }

        if (returnPoetType != TypeName.VOID) {
            if (externMetadata.returnType.type == "char" && externMetadata.returnType.pointerDepth == 1) {
                methodBuilder.addStatement("return result.getString(0)") // todo: charset
                methodBuilder.returns(stringType)
            } else if (externMetadata.returnType.type == "gboolean") {
                methodBuilder.addStatement("return result == 1")
            } else {
                methodBuilder.addStatement("return result")
            }
        }

        val parameters = if (usedArena) {
            listOf(arenaArg) + args
        } else {
            args
        }
        methodBuilder.addParameters(parameters)

        return methodBuilder.build()
    }

    private fun buildPoetArgs(
        methodTypeSymbol: MethodTypeDesc,
        externMetadata: ExternFunctionMetadata
    ): List<ParameterSpec> {
        val args = methodTypeSymbol.parameterArray().mapIndexedNotNull { index, parameter ->
            val externArgMetadata = externMetadata.arguments[index]
            val externArgName = if (externArgMetadata.name.isBlank()) {
                "unnamed$index"
            } else {
                externArgMetadata.name
            }
            if (externArgMetadata.type == "...") {
                ParameterSpec.builder(vipsOptionArrayType, "options").build()
            } else if (parameter.displayName() == "MemorySegment" &&
                (externArgMetadata.type == "char" || externArgMetadata.type == "gchar") &&
                externArgMetadata.pointerDepth == 1 &&
                externArgMetadata.isArray
            ) {
                ParameterSpec.builder(listStringType, "${externArgName}StringArray").build()
            } else if (parameter.displayName() == "MemorySegment" &&
                (externArgMetadata.type == "char" || externArgMetadata.type == "gchar") &&
                externArgMetadata.pointerDepth == 1
            ) {
                ParameterSpec.builder(stringType, "${externArgName}String").build()
            } else if (externArgMetadata.type == "gboolean" && externArgMetadata.pointerDepth == 0) {
                ParameterSpec.builder(TypeName.BOOLEAN, "${externArgName}Boolean").build()
            } else {
                val typeName = classDescToPoetType(parameter, parameter.displayName())
                ParameterSpec.builder(typeName, externArgName).build()
            }
        }
        return args
    }

    private fun addDeallocCodeblockIfOutType(
        externType: ExternType,
        poetType: TypeName,
        name: String,
        methodBuilder: MethodSpec.Builder
    ): Boolean {
        if (externType.pointerDepth < 1) {
            return false
        }

        if (poetType.isPrimitive) {
            methodBuilder.addCode(
                CodeBlock.builder()
                    .addStatement(
                        "$name = $name.reinterpret(arena, \$T::g_free)",
                        vipsRawType
                    )
                    .build()
            )
            return true
        }

        // newly allocated return types have a depth of 1
        val isNewReturnAlloc = (externType.name.isBlank() && externType.pointerDepth == 1 && externType.type != "char")

        if (isNewReturnAlloc) {
            methodBuilder.addCode(
                CodeBlock.builder()
                    .addStatement(
                        "$name = $name.reinterpret(arena, \$T::g_object_unref)",
                        vipsRawType
                    )
                    .build()
            )
            return true
        }

        return false
    }

    private fun buildVipsFile(
        simpleMethods: List<MethodSpec>,
        variadicMethods: List<MethodSpec>,
    ) {
        logger.info("writing file...")

        val initHelper = MethodSpec.methodBuilder("init")
            .returns(TypeName.VOID)
            .addParameters(
                listOf(
                    ParameterSpec.builder(arenaType, "arena").build(),
                    ParameterSpec.builder(TypeName.BOOLEAN, "allowUntrusted").build()
                )
            )
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addStatement("var nameCString = arena.allocateFrom(\"vips-ffm\")")
            .addStatement("var result = VipsRaw.vips_init(nameCString)")
            .addCode(
                makeResultValidatorCodeBlock(vipsValidatorType, "vips_init")
            )
            .addStatement("VipsRaw.vips_block_untrusted_set(allowUntrusted ? 0 : 1)")
            .build()
        val vipsClass = TypeSpec.classBuilder("VipsHelper")
            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
            .addMethod(initHelper)
            .addMethods(simpleMethods)
            .addMethods(variadicMethods)
            .addJavadoc("<p>Generated helpers to wrap {@link \$T} JExtract definitions</p>", vipsRawType)
            .addJavadoc("\n\n<p>Validation of input pointers is performed, but prefer usage of {@link \$T} and friends which do not expose raw pointers</p>", vImageType)
            .addJavadoc("\n\n<p><b>Nothing in this class is guaranteed to stay the same across minor versions - use at your own risk!</b></p>")
            .build()
        val javaFile = JavaFile.builder("app.photofox.vipsffm", vipsClass)
            .build()
        val targetGeneratedSourceRoot = Path.of("core/src/main/java/")
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
        poetClass: ClassName,
        vipsSourceExternDefinitions: Set<String>
    ): List<MethodSpec> {
        val simpleMethods = model.methods().filter {
            val name = it.methodName()
            isVipsMethodNameInScope(name)
        }.mapNotNull {
            val externMetadata = findExternMetadata(it.methodName().stringValue(), vipsSourceExternDefinitions)
            if (externMetadata == null) {
                logger.info("skipping ${it.methodName()} - no extern metadata found")
                return@mapNotNull null
            }

            val rawMethodName = it.methodName().stringValue()

            return@mapNotNull buildVipsMethod(rawMethodName, poetClass, false, it, externMetadata)
        }
        return simpleMethods
    }

    private fun isVipsMethodNameInScope(name: Utf8Entry): Boolean {
        if (name.stringValue() == "g_signal_connect_data") {
            return true
        }

        return name.startsWith("vips_")
                && !name.startsWith("vips__")
                && !name.contains("$")
                && !name.contains("vips_g")
                && !name.contains("vips_dbuf")
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
        val pointerDepth: Int,
        val isArray: Boolean,
        val isConst: Boolean
    ) {
        override fun toString(): String {
            return "$type ${"*".repeat(pointerDepth)}$name"
        }
    }

    // Given a candidate function name, find its corresponding `extern` definition, and compute API metadata
    private fun findExternMetadata(
        candidateName: String,
        vipsSourceExternDefinitions: Set<String>
    ): ExternFunctionMetadata? {
        val candidateDefinitions = vipsSourceExternDefinitions.filter {
            it.contains("$candidateName(") // char *vips_linear(
        }
        if (candidateDefinitions.isEmpty()) {
            return null
        }
        if (candidateDefinitions.size > 1) {
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
        val isArray = this.endsWith("[]")
        val isConst = this.startsWith("const")
        var trimmed = this
        if (isArray) {
            trimmed = trimmed.substringBefore("[]")
        }
        if (isConst) {
            trimmed = trimmed.substringAfter("const ")
        }
        if (this.contains('*')) {
            val type = trimmed.substringBefore('*').trim()
            var name = trimmed.substringAfterLast('*').trim()
            if (primitivesToPoetTypes.keys.contains(name)) {
                name += collissionSuffix
            }
            return ExternType(this, name, type, this.count { it == '*' }, isArray, isConst)
        } else {
            val type = trimmed.substringBeforeLast(' ').trim()
            var name = trimmed.substringAfterLast(' ').trim()
            if (primitivesToPoetTypes.keys.contains(name)) {
                name += collissionSuffix
            }
            return ExternType(this, name, type, 0, isArray, isConst)
        }
    }

    fun String.fromSnakeToJavaStyle(): String {
        if (this.length == 1) {
            return this
        }
        val split = this
            .replace("-", "_")
            .split('_')
            .filterNot { it.isBlank() }
        val hasMultipleParts = split.size > 1
        val candidate = if(hasMultipleParts) {
            split.joinToString("") { it.replaceFirstChar { it.uppercase(Locale.ENGLISH) } }
                .replaceFirstChar { it.lowercase(Locale.ENGLISH) }
        } else {
            this
        }

        return if (SourceVersion.isKeyword(candidate)) {
            "${candidate}$collissionSuffix"
        } else {
            candidate
        }
    }
}