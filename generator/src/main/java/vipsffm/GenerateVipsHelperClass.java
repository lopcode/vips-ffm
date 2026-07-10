package vipsffm;

import com.palantir.javapoet.ArrayTypeName;
import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.CodeBlock;
import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.MethodSpec;
import com.palantir.javapoet.ParameterSpec;
import com.palantir.javapoet.ParameterizedTypeName;
import com.palantir.javapoet.TypeName;
import com.palantir.javapoet.TypeSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.lang.classfile.MethodModel;
import java.lang.classfile.attribute.InnerClassesAttribute;
import java.lang.classfile.constantpool.Utf8Entry;
import java.lang.constant.ClassDesc;
import java.lang.constant.MethodTypeDesc;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

public class GenerateVipsHelperClass {

    private static final Logger logger = LoggerFactory.getLogger(GenerateVipsHelperClass.class);
    private static final ClassName vipsValidatorType = ClassName.get("app.photofox.vipsffm", "VipsValidation");
    private static final ClassName vipsInvokerType = ClassName.get("app.photofox.vipsffm", "VipsInvoker");
    private static final ClassName vipsErrorType = ClassName.get("app.photofox.vipsffm", "VipsError");
    private static final ClassName vipsOptionType = ClassName.get("app.photofox.vipsffm", "VipsOption");
    private static final ClassName vipsRawType = ClassName.get("app.photofox.vipsffm.jextract", "VipsRaw");
    private static final ClassName vImageType = ClassName.get("app.photofox.vipsffm", "VImage");
    private static final ClassName memorySegmentType = ClassName.get("java.lang.foreign", "MemorySegment");
    private static final ClassName arenaType = ClassName.get("java.lang.foreign", "Arena");
    private static final ClassName stringType = ClassName.get("java.lang", "String");
    private static final ClassName listType = ClassName.get("java.util", "List");
    private static final ParameterizedTypeName listStringType = ParameterizedTypeName.get(listType, stringType);
    private static final ArrayTypeName vipsOptionArrayType = ArrayTypeName.of(vipsOptionType);
    private static final ClassName vipsClassType = ClassName.get("app.photofox.vipsffm", "Vips");

    public static void main(String[] args) throws IOException {
        logger.info("generating helpers...");

        var basePath = Path.of("core/build/classes/java/main/");
        var sourceBasePath = Path.of("core/src/main/java/app/photofox/vipsffm/jextract/");
        var vipsRawSourcePath = sourceBasePath.resolve("VipsRaw.java");
        var vipsSourceExternDefinitions = Files.readAllLines(vipsRawSourcePath, StandardCharsets.UTF_8).stream()
            .filter(it -> it.contains("* extern"))
            .map(it -> Strings.removePrefix(it.trim(), "* extern "))
            .collect(Collectors.toCollection(LinkedHashSet::new));
        var vipsRawClassModel = ClassFile.of().parse(basePath.resolve("app/photofox/vipsffm/jextract/VipsRaw.class"));

        var simpleMethods = buildSimpleMethods(
            vipsRawClassModel,
            vipsRawType,
            vipsSourceExternDefinitions
        );
        var variadicMethods = buildVariadicMethods(
            vipsRawClassModel,
            vipsRawType,
            basePath,
            vipsSourceExternDefinitions
        );

        logger.info("generated methods:");
        simpleMethods.forEach(it -> logger.info("  {}", it.name()));
        variadicMethods.forEach(it -> logger.info("  {}", it.name()));

        buildVipsFile(simpleMethods, variadicMethods);

        logger.info("done 🎉");
    }

    private static List<MethodSpec> buildVariadicMethods(
        ClassModel classModel,
        ClassName poetClass,
        Path basePath,
        Set<String> vipsSourceExternDefinitions
    ) throws IOException {
        var candidateClasses = new ArrayList<java.lang.classfile.attribute.InnerClassInfo>();
        for (var element : classModel.elementList()) {
            if (element instanceof InnerClassesAttribute innerClasses) {
                for (var innerClass : innerClasses.classes()) {
                    if (isVipsMethodNameInScope(innerClass.innerName().get())) {
                        candidateClasses.add(innerClass);
                    }
                }
            }
        }

        var variadicMethods = new ArrayList<MethodSpec>();
        for (var candidate : candidateClasses) {
            // type information for variadic functions are in the `apply` function in their static inner class
            var innerClassName = candidate.innerClass().asInternalName();
            var innerClassModel = ClassFile.of().parse(basePath.resolve(innerClassName + ".class"));
            var applyMethodCandidates = innerClassModel.methods().stream()
                .filter(it -> it.methodName().stringValue().equals("apply"))
                .toList();
            if (applyMethodCandidates.size() < 1) {
                continue;
            }
            if (applyMethodCandidates.size() > 1) {
                throw new RuntimeException("expected one apply method");
            }
            var applyMethod = applyMethodCandidates.get(0);
            var rawMethodName = candidate.innerName().get().stringValue();
            var externMetadata = findExternMetadata(rawMethodName, vipsSourceExternDefinitions);
            if (externMetadata == null) {
                logger.info("skipping {} - no extern metadata found", candidate);
                continue;
            }

            var method = buildVipsMethod(
                rawMethodName,
                poetClass,
                true,
                applyMethod,
                externMetadata
            );
            if (method != null) {
                variadicMethods.add(method);
            }
        }
        return variadicMethods;
    }

    private static MethodSpec buildVipsMethod(
        String rawMethodName,
        ClassName rawPoetClass,
        boolean isVariadic,
        MethodModel methodModel,
        ExternFunctionMetadata externMetadata
    ) {
        var newName = Strings.removePrefix(rawMethodName, "vips_");
        var qualifiedReturnType = methodModel.methodTypeSymbol().returnType();
        var typeDisplayName = qualifiedReturnType.displayName();
        var defaultReturnPoetType = classDescToPoetType(qualifiedReturnType, typeDisplayName);

        var methodTypeSymbol = methodModel.methodTypeSymbol();
        var args = buildPoetArgs(methodTypeSymbol, externMetadata);

        var vipsFunctionArgs = new ArrayList<>(args);
        if (isVariadic) {
            vipsFunctionArgs.removeLast();
            vipsFunctionArgs.add(ParameterSpec.builder(vipsOptionArrayType, "invokerArgs").build());
        }
        var vipsFunctionArgNames = new ArrayList<String>();
        for (var index = 0; index < vipsFunctionArgs.size(); index++) {
            var parameterSpec = vipsFunctionArgs.get(index);
            var externArgMetadata = index < externMetadata.arguments().size() ? externMetadata.arguments().get(index) : null;
            if (parameterSpec.type().equals(listStringType)) {
                vipsFunctionArgNames.add(Strings.removeSuffix(parameterSpec.name(), "StringArray"));
            } else if (parameterSpec.type().equals(stringType)) {
                vipsFunctionArgNames.add(Strings.removeSuffix(parameterSpec.name(), "String"));
            } else if (externArgMetadata != null && externArgMetadata.type().equals("gboolean") && externArgMetadata.pointerDepth() == 0) {
                vipsFunctionArgNames.add(Strings.removeSuffix(parameterSpec.name(), "Boolean"));
            } else {
                vipsFunctionArgNames.add(parameterSpec.name());
            }
        }
        var vipsFunctionArgsJoined = String.join(", ", vipsFunctionArgNames);

        var returnPoetType = defaultReturnPoetType;
        var arenaArg = ParameterSpec.builder(arenaType, "arena").build();
        var methodBuilder = MethodSpec.methodBuilder(newName)
            .addJavadoc("Binding for:\n```c\n" + externMetadata.rawExternDefinition() + "\n```")
            .addException(vipsErrorType)
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .returns(returnPoetType);

        if (isVariadic) {
            methodBuilder.varargs(true);
        }

        var usedArena = false;

        for (var index = 0; index < args.size(); index++) {
            var parameter = args.get(index);
            var externArgMetadata = externMetadata.arguments().get(index);
            if (externArgMetadata.type().equals("gboolean") && parameter.type().equals(TypeName.BOOLEAN)) {
                methodBuilder.addStatement(
                    "var " + Strings.removeSuffix(parameter.name(), "Boolean") + " = " + parameter.name() + " ? 1 : 0"
                );
            } else if (externArgMetadata.pointerDepth() >= 1) {
                if (parameter.type().equals(listStringType)) {
                    var strippedName = Strings.removeSuffix(parameter.name(), "StringArray");
                    methodBuilder.addStatement(
                        "var " + strippedName + " = $T.makeCharStarArray(arena, " + strippedName + "StringArray)",
                        vipsInvokerType
                    );
                    usedArena = true;
                } else if (parameter.type().equals(stringType)) {
                    var strippedName = Strings.removeSuffix(parameter.name(), "String");
                    methodBuilder.addStatement("var " + strippedName + " = arena.allocateFrom(" + parameter.name() + ")");
                    usedArena = true;
                } else {
                    methodBuilder.addCode(
                        makeInputValidatorCodeBlock(parameter.name(), vipsValidatorType, rawMethodName)
                    );
                }
            }
        }

        if (isVariadic) {
            methodBuilder.addCode(
                CodeBlock.builder()
                    .addStatement("var layouts = $T.makeInvokerVarargLayouts(options)", vipsInvokerType)
                    .addStatement("var invoker = $T." + rawMethodName + ".makeInvoker(layouts)", rawPoetClass)
                    .addStatement("var invokerArgs = $T.makeInvokerVarargObjects(arena, options)", vipsInvokerType)
                    .build()
            );
            usedArena = true;
        }

        if (!returnPoetType.equals(TypeName.VOID)) {
            if (isVariadic) {
                methodBuilder
                    .addStatement("var result = invoker.apply(" + vipsFunctionArgsJoined + ")");
            } else {
                methodBuilder
                    .addStatement("var result = $T." + rawMethodName + "(" + vipsFunctionArgsJoined + ")", rawPoetClass);
            }

            if (returnPoetType.equals(TypeName.INT)) {
                if (externMetadata.returnType().type().equals("gboolean")) {
                    methodBuilder.returns(TypeName.BOOLEAN);
                    returnPoetType = TypeName.BOOLEAN;
                }
            }

            for (var index = 0; index < args.size(); index++) {
                var parameterSpec = args.get(index);
                var externArgMetadata = externMetadata.arguments().get(index);
                var deallocUsedArena = addDeallocCodeblockIfOutType(
                    externArgMetadata,
                    parameterSpec.type(),
                    parameterSpec.name(),
                    methodBuilder
                );
                if (deallocUsedArena) {
                    usedArena = true;
                }
            }

            if (returnPoetType.equals(memorySegmentType)) {
                methodBuilder.addCode(
                    makeOutputPointerValidatorCodeBlock(
                        "result",
                        vipsValidatorType,
                        rawMethodName
                    )
                );
            }

            var externType = externMetadata.returnType();
            var deallocUsedArena = addDeallocCodeblockIfOutType(externType, returnPoetType, "result", methodBuilder);
            if (deallocUsedArena) {
                usedArena = true;
            }
        } else {
            if (isVariadic) {
                methodBuilder
                    .addStatement("invoker.apply(" + vipsFunctionArgsJoined + ")");
            } else {
                methodBuilder
                    .addStatement("$T." + rawMethodName + "(" + vipsFunctionArgsJoined + ")", rawPoetClass);
            }
        }

        if (!returnPoetType.equals(TypeName.VOID)) {
            if (externMetadata.returnType().type().equals("char") && externMetadata.returnType().pointerDepth() == 1) {
                methodBuilder.addStatement("return result.getString(0)"); // todo: charset
                methodBuilder.returns(stringType);
            } else if (externMetadata.returnType().type().equals("gboolean")) {
                methodBuilder.addStatement("return result == 1");
            } else {
                methodBuilder.addStatement("return result");
            }
        }

        List<ParameterSpec> parameters;
        if (usedArena) {
            parameters = new ArrayList<>();
            parameters.add(arenaArg);
            parameters.addAll(args);
        } else {
            parameters = args;
        }
        methodBuilder.addParameters(parameters);

        return methodBuilder.build();
    }

    private static List<ParameterSpec> buildPoetArgs(
        MethodTypeDesc methodTypeSymbol,
        ExternFunctionMetadata externMetadata
    ) {
        var args = new ArrayList<ParameterSpec>();
        var parameterArray = methodTypeSymbol.parameterArray();
        for (var index = 0; index < parameterArray.length; index++) {
            var parameter = parameterArray[index];
            var externArgMetadata = externMetadata.arguments().get(index);
            var externArgName = externArgMetadata.name().isBlank() ? "unnamed" + index : externArgMetadata.name();
            if (externArgMetadata.type().equals("...")) {
                args.add(ParameterSpec.builder(vipsOptionArrayType, "options").build());
            } else if (parameter.displayName().equals("MemorySegment") &&
                (externArgMetadata.type().equals("char") || externArgMetadata.type().equals("gchar")) &&
                externArgMetadata.pointerDepth() == 1 &&
                externArgMetadata.isArray()
            ) {
                args.add(ParameterSpec.builder(listStringType, externArgName + "StringArray").build());
            } else if (parameter.displayName().equals("MemorySegment") &&
                (externArgMetadata.type().equals("char") || externArgMetadata.type().equals("gchar")) &&
                externArgMetadata.pointerDepth() == 1
            ) {
                args.add(ParameterSpec.builder(stringType, externArgName + "String").build());
            } else if (externArgMetadata.type().equals("gboolean") && externArgMetadata.pointerDepth() == 0) {
                args.add(ParameterSpec.builder(TypeName.BOOLEAN, externArgName + "Boolean").build());
            } else {
                var typeName = classDescToPoetType(parameter, parameter.displayName());
                args.add(ParameterSpec.builder(typeName, externArgName).build());
            }
        }
        return args;
    }

    private static boolean addDeallocCodeblockIfOutType(
        ExternType externType,
        TypeName poetType,
        String name,
        MethodSpec.Builder methodBuilder
    ) {
        if (externType.pointerDepth() < 1) {
            return false;
        }

        if (poetType.isPrimitive()) {
            methodBuilder.addCode(
                CodeBlock.builder()
                    .addStatement(
                        name + " = " + name + ".reinterpret(arena, $T::g_free)",
                        vipsRawType
                    )
                    .build()
            );
            return true;
        }

        // newly allocated return types have a depth of 1
        var isNewReturnAlloc =
            (externType.name().isBlank() &&
                externType.pointerDepth() == 1 && !externType.type().equals("char") && !externType.raw().equals("void *"));

        if (isNewReturnAlloc) {
            methodBuilder.addCode(
                CodeBlock.builder()
                    .addStatement(
                        name + " = " + name + ".reinterpret(arena, $T::g_object_unref)",
                        vipsRawType
                    )
                    .build()
            );
            return true;
        }

        return false;
    }

    private static void buildVipsFile(
        List<MethodSpec> simpleMethods,
        List<MethodSpec> variadicMethods
    ) throws IOException {
        logger.info("writing file...");

        var initHelper = MethodSpec.methodBuilder("init")
            .returns(TypeName.VOID)
            .addParameters(
                List.of(
                    ParameterSpec.builder(arenaType, "arena").build()
                )
            )
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addStatement("var nameCString = arena.allocateFrom(\"vips-ffm\")")
            .addStatement("var result = VipsRaw.vips_init(nameCString)")
            .addCode(
                makeResultValidatorCodeBlock(vipsValidatorType, "vips_init")
            )
            .build();
        var vipsClass = TypeSpec.classBuilder("VipsHelper")
            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
            .addInitializerBlock(
                CodeBlock.builder()
                    .addStatement("$T.autoInit()", vipsClassType)
                    .build()
            )
            .addMethod(initHelper)
            .addMethods(simpleMethods)
            .addMethods(variadicMethods)
            .addJavadoc("Generated helpers to wrap [$T] JExtract definitions", vipsRawType)
            .addJavadoc(
                "\n\nValidation of input pointers is performed, but prefer usage of [$T] and friends which do not expose raw pointers",
                vImageType
            )
            .addJavadoc("\n\n**Nothing in this class is guaranteed to stay the same across minor versions - use at your own risk!**")
            .build();
        var javaFile = JavadocMarkdownConversion.convert(
            JavaFile.builder("app.photofox.vipsffm", vipsClass)
                .build()
                .toString()
        );
        var targetGeneratedSourceRoot = Path.of("core/src/main/java/app/photofox/vipsffm");
        Files.writeString(targetGeneratedSourceRoot.resolve("VipsHelper.java"), javaFile, StandardCharsets.UTF_8);
    }

    private static CodeBlock makeResultValidatorCodeBlock(ClassName vipsValidatorType, String methodName) {
        return CodeBlock.builder()
            .beginControlFlow("if (!$T.isValidResult(result))", vipsValidatorType)
            .addStatement("$T.throwVipsError(\"" + methodName + "\")", vipsValidatorType)
            .endControlFlow()
            .build();
    }

    private static List<MethodSpec> buildSimpleMethods(
        ClassModel model,
        ClassName poetClass,
        Set<String> vipsSourceExternDefinitions
    ) {
        var simpleMethods = new ArrayList<MethodSpec>();
        for (var methodModel : model.methods()) {
            if (!isVipsMethodNameInScope(methodModel.methodName())) {
                continue;
            }
            var externMetadata = findExternMetadata(methodModel.methodName().stringValue(), vipsSourceExternDefinitions);
            if (externMetadata == null) {
                logger.info("skipping {} - no extern metadata found", methodModel.methodName());
                continue;
            }

            var rawMethodName = methodModel.methodName().stringValue();

            var method = buildVipsMethod(rawMethodName, poetClass, false, methodModel, externMetadata);
            if (method != null) {
                simpleMethods.add(method);
            }
        }
        return simpleMethods;
    }

    private static boolean isVipsMethodNameInScope(Utf8Entry name) {
        var nameString = name.stringValue();
        if (nameString.equals("g_signal_connect_data")) {
            return true;
        }

        return nameString.startsWith("vips_")
            && !nameString.startsWith("vips__")
            && !nameString.contains("$")
            && !nameString.contains("vips_g")
            && !nameString.contains("vips_dbuf");
    }

    private static CodeBlock makeInputValidatorCodeBlock(
        String argName,
        ClassName vipsValidatorType,
        String rawMethodName
    ) {
        return CodeBlock.builder()
            .beginControlFlow("if(!$T.isValidPointer(" + argName + "))", vipsValidatorType)
            .addStatement(
                "$T.throwInvalidInputError(\"" + rawMethodName + "\", \"" + argName + "\")",
                vipsValidatorType
            )
            .endControlFlow()
            .build();
    }

    private static CodeBlock makeOutputPointerValidatorCodeBlock(
        String pointerArgName,
        ClassName vipsValidatorType,
        String rawMethodName
    ) {
        return CodeBlock.builder()
            .beginControlFlow("if(!$T.isValidPointer(" + pointerArgName + "))", vipsValidatorType)
            .addStatement(
                "$T.throwInvalidOutputError(\"" + rawMethodName + "\", \"" + pointerArgName + "\")",
                vipsValidatorType
            )
            .endControlFlow()
            .build();
    }

    private static final Map<String, TypeName> primitivesToPoetTypes = Map.of(
        "void", TypeName.VOID,
        "boolean", TypeName.BOOLEAN,
        "byte", TypeName.BYTE,
        "short", TypeName.SHORT,
        "int", TypeName.INT,
        "long", TypeName.LONG,
        "char", TypeName.CHAR,
        "float", TypeName.FLOAT,
        "double", TypeName.DOUBLE
    );

    private static TypeName classDescToPoetType(
        ClassDesc qualifiedReturnType,
        String typeDisplayName
    ) {
        if (qualifiedReturnType.isPrimitive()) {
            var poetType = primitivesToPoetTypes.get(typeDisplayName);
            if (poetType == null) {
                throw new RuntimeException("unknown primitive type: " + typeDisplayName);
            }
            return poetType;
        }
        return ClassName.get(qualifiedReturnType.packageName(), qualifiedReturnType.displayName());
    }

    record ExternFunctionMetadata(
        String rawExternDefinition,
        ExternType returnType,
        List<ExternType> arguments
    ) {
    }

    record ExternType(
        String raw,
        String name,
        String type,
        int pointerDepth,
        boolean isArray,
        boolean isConst
    ) {
        @Override
        public String toString() {
            return type + " " + "*".repeat(pointerDepth) + name;
        }
    }

    // Given a candidate function name, find its corresponding `extern` definition, and compute API metadata
    private static ExternFunctionMetadata findExternMetadata(
        String candidateName,
        Set<String> vipsSourceExternDefinitions
    ) {
        var candidateDefinitions = vipsSourceExternDefinitions.stream()
            .filter(it -> it.contains(candidateName + "(")) // char *vips_linear(
            .toList();
        if (candidateDefinitions.isEmpty()) {
            return null;
        }
        if (candidateDefinitions.size() > 1) {
            throw new RuntimeException("unexpected number of candidate definitions found: " + candidateDefinitions.size() + " " + candidateName);
        }
        var candidateDefinition = candidateDefinitions.get(0);
        var returnTypeRaw = toExternType(Strings.substringBefore(candidateDefinition, candidateName));
        var arguments = Strings.trim(Strings.substringAfter(candidateDefinition, candidateName), '(', ')')
            .split(",");
        var argumentTypes = new ArrayList<ExternType>();
        for (var argument : arguments) {
            var trimmed = argument.trim();
            if (trimmed.isBlank()) {
                continue;
            }
            argumentTypes.add(toExternType(trimmed));
        }

        return new ExternFunctionMetadata(
            candidateDefinition,
            returnTypeRaw,
            argumentTypes
        );
    }

    // sometimes, after transformation, names collide with java keywords
    // eg vips_case -> case
    //    vips_boolean -> boolean
    // this suffix gets added to colliding types
    private static final String collissionSuffix = "1"; // todo: better suffix for collisions?

    private static ExternType toExternType(String raw) {
        var isArray = raw.endsWith("[]");
        var isConst = raw.startsWith("const");
        var trimmed = raw;
        if (isArray) {
            trimmed = Strings.substringBefore(trimmed, "[]");
        }
        if (isConst) {
            trimmed = Strings.substringAfter(trimmed, "const ");
        }
        if (raw.contains("*")) {
            var type = Strings.substringBefore(trimmed, '*', trimmed).trim();
            var name = Strings.substringAfterLast(trimmed, '*').trim();
            if (primitivesToPoetTypes.containsKey(name)) {
                name += collissionSuffix;
            }
            var pointerDepth = (int) raw.chars().filter(it -> it == '*').count();
            return new ExternType(raw, name, type, pointerDepth, isArray, isConst);
        } else {
            var type = Strings.substringBeforeLast(trimmed, ' ').trim();
            var name = Strings.substringAfterLast(trimmed, ' ').trim();
            if (primitivesToPoetTypes.containsKey(name)) {
                name += collissionSuffix;
            }
            return new ExternType(raw, name, type, 0, isArray, isConst);
        }
    }

    public static String fromSnakeToJavaStyle(String original) {
        if (original.length() == 1) {
            return original;
        }
        var split = new ArrayList<String>();
        for (var part : original.replace("-", "_").split("_", -1)) {
            if (!part.isBlank()) {
                split.add(part);
            }
        }
        var hasMultipleParts = split.size() > 1;
        String candidate;
        if (hasMultipleParts) {
            var joined = split.stream()
                .map(it -> it.substring(0, 1).toUpperCase(Locale.ENGLISH) + it.substring(1))
                .collect(Collectors.joining(""));
            candidate = joined.substring(0, 1).toLowerCase(Locale.ENGLISH) + joined.substring(1);
        } else {
            candidate = original;
        }

        if (SourceVersion.isKeyword(candidate)) {
            return candidate + collissionSuffix;
        }
        return candidate;
    }
}
