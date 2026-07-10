package vipsffm;

import app.photofox.vipsffm.jextract.GEnumClass;
import app.photofox.vipsffm.jextract.GEnumValue;
import app.photofox.vipsffm.jextract.VipsRaw;
import com.palantir.javapoet.ArrayTypeName;
import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.CodeBlock;
import com.palantir.javapoet.FieldSpec;
import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.MethodSpec;
import com.palantir.javapoet.ParameterSpec;
import com.palantir.javapoet.ParameterizedTypeName;
import com.palantir.javapoet.TypeName;
import com.palantir.javapoet.TypeSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.lang.model.element.Modifier;

import static vipsffm.GenerateVipsHelperClass.fromSnakeToJavaStyle;

public class GenerateVClasses {

    private static final Logger logger = LoggerFactory.getLogger(GenerateVClasses.class);
    private static final ClassName vipsHelperType = ClassName.get("app.photofox.vipsffm", "VipsHelper");
    private static final ClassName vipsInvokerType = ClassName.get("app.photofox.vipsffm", "VipsInvoker");
    private static final ClassName vipsErrorType = ClassName.get("app.photofox.vipsffm", "VipsError");
    private static final ClassName vipsOptionType = ClassName.get("app.photofox.vipsffm", "VipsOption");
    private static final ArrayTypeName vipsOptionVarargType = ArrayTypeName.of(vipsOptionType);
    private static final ClassName memorySegmentType = ClassName.get("java.lang.foreign", "MemorySegment");
    private static final ClassName arenaType = ClassName.get("java.lang.foreign", "Arena");
    private static final ClassName stringType = ClassName.get("java.lang", "String");
    private static final ClassName listType = ClassName.get("java.util", "List");
    private static final ClassName vimageType = ClassName.get("app.photofox.vipsffm", "VImage");
    private static final ClassName vsourceType = ClassName.get("app.photofox.vipsffm", "VSource");
    private static final ClassName vtargetType = ClassName.get("app.photofox.vipsffm", "VTarget");
    private static final ClassName vInterpolateType = ClassName.get("app.photofox.vipsffm", "VInterpolate");
    private static final ClassName vEnumType = ClassName.get("app.photofox.vipsffm", "VEnum");
    private static final ClassName vblobType = ClassName.get("app.photofox.vipsffm", "VBlob");
    private static final ClassName boxedBooleanType = ClassName.get("java.lang", "Boolean");
    private static final ClassName boxedIntType = ClassName.get("java.lang", "Integer");
    private static final ClassName boxedLongType = ClassName.get("java.lang", "Long");
    private static final ClassName boxedDoubleType = ClassName.get("java.lang", "Double");
    private static final ClassName vipsOptionIntType = ClassName.get("app.photofox.vipsffm", "VipsOption.Int");
    private static final ClassName vipsOptionBooleanType = ClassName.get("app.photofox.vipsffm", "VipsOption.Boolean");
    private static final ClassName vipsOptionDoubleType = ClassName.get("app.photofox.vipsffm", "VipsOption.Double");
    private static final ClassName vipsOptionLongType = ClassName.get("app.photofox.vipsffm", "VipsOption.Long");
    private static final ClassName vipsOptionStringType = ClassName.get("app.photofox.vipsffm", "VipsOption.String");
    private static final ClassName vipsOptionImageType = ClassName.get("app.photofox.vipsffm", "VipsOption.Image");
    private static final ClassName vipsOptionSourceType = ClassName.get("app.photofox.vipsffm", "VipsOption.Source");
    private static final ClassName vipsOptionTargetType = ClassName.get("app.photofox.vipsffm", "VipsOption.Target");
    private static final ClassName vipsOptionBlobType = ClassName.get("app.photofox.vipsffm", "VipsOption.Blob");
    private static final ClassName vipsOptionArrayDoubleType = ClassName.get("app.photofox.vipsffm", "VipsOption.ArrayDouble");
    private static final ClassName vipsOptionArrayIntType = ClassName.get("app.photofox.vipsffm", "VipsOption.ArrayInt");
    private static final ClassName vipsOptionArrayImageType = ClassName.get("app.photofox.vipsffm", "VipsOption.ArrayImage");
    private static final ClassName vipsOptionInterpolateType = ClassName.get("app.photofox.vipsffm", "VipsOption.Interpolate");
    private static final ClassName vipsOptionEnumType = ClassName.get("app.photofox.vipsffm", "VipsOption.Enum");
    private static final ClassName vipsValidatorType = ClassName.get("app.photofox.vipsffm", "VipsValidation");
    private static final ClassName vipsRawType = ClassName.get("app.photofox.vipsffm.jextract", "VipsRaw");
    private static final ClassName vNamedEnumType = ClassName.get("app.photofox.vipsffm", "VNamedEnum");
    private static final ClassName inputStreamType = ClassName.get("java.io", "InputStream");
    private static final ClassName outputStreamType = ClassName.get("java.io", "OutputStream");
    private static final ParameterizedTypeName listStringType = ParameterizedTypeName.get(listType, stringType);
    private static final ClassName vipsImageMapFnType = ClassName.get("app.photofox.vipsffm.jextract", "VipsImageMapFn");
    private static final ClassName valueLayoutType = ClassName.get("java.lang.foreign", "ValueLayout");

    public static void main(String[] args) throws Exception {
        DiscoveredOperations discoveredOperations;
        try (var arena = Arena.ofConfined()) {
            discoveredOperations = DiscoverVipsOperations.run(arena);
        }
        var operations = discoveredOperations.operations();

        logger.info("found {} operations:", operations.size());
        for (var op : operations) {
            var inputArgs = op.args().stream().filter(it -> it.isRequired() && it.isInput()).toList();
            var outputArgs = op.args().stream().filter(VipsOperationArgument::isOutput).toList();
            var optionalArgs = op.args().stream().filter(it -> !it.isRequired()).toList();
            logger.info("  {} - args: {} input, {} output, {} optional", op.nickname(), inputArgs.size(), outputArgs.size(), optionalArgs.size());
        }

        var enums = new LinkedHashSet<String>();
        for (var op : operations) {
            for (var arg : op.args()) {
                if (arg.isEnum()) {
                    enums.add(((GValueType.Unknown) arg.type()).rawName());
                }
            }
        }

        var discoveredEnums = new ArrayList<DiscoveredEnum>();
        try (var arena = Arena.ofConfined()) {
            for (var enumName : enums) {
                discoveredEnums.add(discoverEnumClass(arena, enumName, discoveredOperations.enums()));
            }
        }
        for (var discoveredEnum : discoveredEnums) {
            buildEnumClass(discoveredEnum, operations, discoveredEnums);
        }

        generateVImageClass(operations, discoveredEnums);
    }

    private static void generateVImageClass(
        List<VipsOperation> operations,
        List<DiscoveredEnum> enums
    ) throws IOException {
        var operationMethods = new ArrayList<OperationMethod>();
        for (var operation : operations) {
            var hasImageInput = operation.args().stream()
                .anyMatch(it -> it.isInput() && it.isRequired() && it.type() == GValueType.Simple.VIPS_IMAGE);
            var hasImageOutput = operation.args().stream()
                .anyMatch(it -> it.isOutput() && it.isRequired() && (it.type() == GValueType.Simple.VIPS_IMAGE || it.type() == GValueType.Simple.VIPS_ARRAY_IMAGE));
            if (!(hasImageInput || hasImageOutput)) {
                logger.info("skipping \"{}\" - no image inputs or outputs", operation.nickname());
                continue;
            }
            if (operation.isDeprecated()) {
                // skip
                continue;
            }
            operationMethods.add(buildOperationMethod(operation, operations, enums));
        }

        var imageMethods = buildImageMethods();

        var ctor = MethodSpec.constructorBuilder()
            .addParameter(arenaType, "arena")
            .addParameter(memorySegmentType, "address")
            .addException(vipsErrorType)
            .addCode(
                CodeBlock.builder()
                    .beginControlFlow("if (!$T.isValidPointer(address))", vipsValidatorType)
                    .addStatement("throw new VipsError(\"invalid pointer used for creation\")")
                    .endControlFlow()
                    .build()
            )
            .addStatement("this.arena = arena")
            .addStatement("this.address = address")
            .build();
        var hashCode = MethodSpec.methodBuilder("hashCode")
            .addAnnotation(Override.class)
            .addModifiers(Modifier.PUBLIC)
            .returns(TypeName.INT)
            .addStatement("return $T.hash(arena, address)", Objects.class)
            .build();
        var equals = MethodSpec.methodBuilder("equals")
            .addAnnotation(Override.class)
            .addModifiers(Modifier.PUBLIC)
            .addParameter(ClassName.OBJECT, "o")
            .returns(TypeName.BOOLEAN)
            .addStatement("if (this == o) return true")
            .addStatement("if (!(o instanceof $T vImage)) return false", vimageType)
            .addStatement("return Objects.equals(arena, vImage.arena) && Objects.equals(address, vImage.address)")
            .build();
        var unsafeStructAddress = MethodSpec.methodBuilder("getUnsafeStructAddress")
            .addJavadoc("Gets the raw [MemorySegment] (C pointer) for this VipsImage struct")
            .addJavadoc("\n\nThe memory address' lifetime is bound to the scope of the [#arena]")
            .addJavadoc("\n\nUsage of the memory address is strongly discouraged, but it is available if some functionality is missing and you need to use it with [VipsHelper]")
            .addStatement("return this.address")
            .returns(memorySegmentType)
            .addModifiers(Modifier.PUBLIC)
            .build();
        var vipsClassBuilder = TypeSpec.classBuilder(vimageType.topLevelClassName())
            .addJavadoc("A generated wrapper representing a VipsImage. Do not edit.")
            .addJavadoc("\n[libvips api docs](https://www.libvips.org/API/current/api-index-full.html)")
            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
            .addMethod(ctor)
            .addMethod(hashCode)
            .addMethod(equals)
            .addMethod(unsafeStructAddress);

        for (var operationMethod : operationMethods) {
            vipsClassBuilder.addMethod(operationMethod.spec());
            if (operationMethod.outputClass() != null) {
                vipsClassBuilder.addType(operationMethod.outputClass());
            }
        }

        var vipsClass = vipsClassBuilder
            .addMethods(imageMethods)
            .addField(arenaType, "arena", Modifier.PRIVATE, Modifier.FINAL)
            .addField(memorySegmentType, "address", Modifier.FINAL)
            .build();
        var javaFile = JavadocMarkdownConversion.convert(
            JavaFile.builder("app.photofox.vipsffm", vipsClass)
                .build()
                .toString()
        );
        var targetGeneratedSourceRoot = Path.of("core/src/main/java/app/photofox/vipsffm");
        Files.writeString(targetGeneratedSourceRoot.resolve("VImage.java"), javaFile, StandardCharsets.UTF_8);
    }

    record OperationMethod(
        MethodSpec spec,
        // encapsulates multiple outputs from operations that produce them
        TypeSpec outputClass
    ) {
    }

    private static OperationMethod buildOperationMethod(
        VipsOperation spec,
        List<VipsOperation> operations,
        List<DiscoveredEnum> enums
    ) {
        logger.info("building operation {}", spec);
        var requiredArguments = spec.args().stream().filter(VipsOperationArgument::isRequired).toList();
        var methodName = fromSnakeToJavaStyle(spec.nickname());
        var method = MethodSpec.methodBuilder(methodName);
        var poetArguments = new ArrayList<ParameterSpec>();
        for (var argument : requiredArguments) {
            var name = fromSnakeToJavaStyle(argument.name());
            var argType = mapArgSpecToPoetType(argument);
            if (argType == null) {
                throw new RuntimeException("unsupported type in method \"" + argument.name() + "\": " + argument.type());
            }
            poetArguments.add(ParameterSpec.builder(argType, name).build());
        }

        var firstSpottedImageInputIndex = -1;
        var filteredPoetArgs = new ArrayList<ParameterSpec>();
        for (var index = 0; index < poetArguments.size(); index++) {
            var argSpec = requiredArguments.get(index);
            var isImageInput = argSpec.isInput() && (argSpec.type() == GValueType.Simple.VIPS_IMAGE);
            if (isImageInput && (firstSpottedImageInputIndex < 0)) {
                // discard first image input - it'll be "this image"
                firstSpottedImageInputIndex = index;
                continue;
            }
            if (!argSpec.isOutput()) {
                filteredPoetArgs.add(poetArguments.get(index));
            }
        }

        var outputArguments = new ArrayList<ParameterSpec>();
        for (var index = 0; index < poetArguments.size(); index++) {
            var argSpec = requiredArguments.get(index);
            if (argSpec.isOutput() && !argSpec.isRequired()) {
                throw new RuntimeException("optional output arguments not yet supported");
            }
            if (argSpec.isOutput()) {
                outputArguments.add(poetArguments.get(index));
            }
        }

        TypeSpec outputTypeSpec = null;
        if (outputArguments.size() > 1) {
            var outputClassName = capitalizeVipsText(methodName) + "Output";
            outputTypeSpec = TypeSpec.recordBuilder(outputClassName)
                .addModifiers(Modifier.PUBLIC)
                .recordConstructor(
                    MethodSpec.constructorBuilder()
                        .addParameters(outputArguments)
                        .build()
                )
                .addJavadoc("Helper record to hold multiple outputs from the [VImage#" + methodName + "] operation")
                .build();
        }
        TypeName returnType;
        if (outputTypeSpec != null) {
            returnType = ClassName.get("app.photofox.vipsffm.VImage", outputTypeSpec.name());
        } else if (outputArguments.isEmpty()) {
            returnType = TypeName.VOID;
        } else {
            returnType = outputArguments.get(0).type();
        }
        method.returns(returnType);
        method.varargs(true);
        method.addException(vipsErrorType);
        method.addModifiers(Modifier.PUBLIC);

        var referencedSelf = false;
        for (var index = 0; index < poetArguments.size(); index++) {
            var poetArg = poetArguments.get(index);
            var argSpec = requiredArguments.get(index);
            var poetArgType = poetArg.type();
            var vipsOptionType = mapPoetTypeToVipsOptionType(poetArgType, argSpec);
            if (argSpec.isOutput()) {
                method.addStatement("var " + poetArg.name() + "Option = $T(\"" + argSpec.name() + "\")", vipsOptionType);
            } else if (argSpec.isInput()) {
                if (poetArg.type().equals(vimageType) && !filteredPoetArgs.contains(poetArg)) {
                    // it's an image type, and doesn't refer to "this image"
                    referencedSelf = true;
                    method.addStatement("var " + poetArg.name() + "Option = $T(\"" + argSpec.name() + "\", this)", vipsOptionType);
                } else if (poetArg.type().equals(vEnumType)) {
                    method.addStatement(
                        "var " + poetArg.name() + "Option = $T(\"" + argSpec.name() + "\", " + poetArg.name() + ".getRawValue())",
                        vipsOptionType
                    );
                } else {
                    method.addStatement(
                        "var " + poetArg.name() + "Option = $T(\"" + argSpec.name() + "\", " + poetArg.name() + ")",
                        vipsOptionType
                    );
                }
            }
        }
        method.addStatement("var callArgs = new $T<>($T.asList(args))", ArrayList.class, Arrays.class);
        for (var poetArg : poetArguments) {
            method.addStatement("callArgs.add(" + poetArg.name() + "Option)");
        }

        method.addStatement("$T.invokeOperation(arena, \"" + spec.nickname() + "\", callArgs)", vipsInvokerType);

        if (outputTypeSpec != null) {
            var joinedOutputs = outputArguments.stream()
                .map(it -> it.name() + "Option.valueOrThrow()")
                .collect(Collectors.joining(", "));
            method.addStatement("return new " + outputTypeSpec.name() + "(" + joinedOutputs + ")");
        } else if (outputArguments.size() == 1) {
            method.addStatement("return " + outputArguments.get(0).name() + "Option.valueOrThrow()");
        }
        generateMethodJavadoc(method, methodName, spec, operations, enums);
        if (!referencedSelf) {
            method.addJavadoc("\n@param arena The arena that bounds resulting memory allocations during this operation");
        }
        for (var index = 0; index < poetArguments.size(); index++) {
            var poetArg = poetArguments.get(index);
            if (!filteredPoetArgs.contains(poetArg)) {
                continue;
            }
            var argSpec = requiredArguments.get(index);
            var argNameSection = poetArg.name();
            if (argSpec.isEnum()) {
                var enumName = ((GValueType.Unknown) argSpec.type()).rawName();
                argNameSection += " [$T]";
                method.addJavadoc(
                    "\n@param " + argNameSection + " " + capitalizeVipsText(argSpec.blurb()),
                    ClassName.get("app.photofox.vipsffm.enums", enumName)
                );
            } else {
                method.addJavadoc("\n@param " + argNameSection + " " + capitalizeVipsText(argSpec.blurb()));
            }
        }
        method.addJavadoc("\n@param args Array of VipsOption to apply to this operation");
        for (var argument : spec.args()) {
            if (argument.isRequired() || argument.name().equals("nickname") || argument.name().equals("description")) {
                continue;
            }
            var poetType = mapArgSpecToPoetType(argument);
            if (poetType == null) {
                throw new RuntimeException("unexpected null poet type for arg spec: " + argument);
            }
            var vipsOptionType = mapPoetTypeToVipsOptionType(poetType, argument);
            var optionName = "[" + vipsOptionType.simpleNames().get(0) + "]";
            if (argument.isEnum()) {
                var enumName = ((GValueType.Unknown) argument.type()).rawName();
                optionName += " [$T]";
                method.addJavadoc(
                    "\n@optionalArg " + argument.name() + " " + optionName + " " + capitalizeVipsText(argument.blurb()),
                    ClassName.get("app.photofox.vipsffm.enums", enumName)
                );
            } else {
                method.addJavadoc("\n@optionalArg " + argument.name() + " " + optionName + " " + capitalizeVipsText(argument.blurb()));
            }
        }

        if (!referencedSelf) {
            method.addModifiers(Modifier.STATIC);
            method.addParameter(
                ParameterSpec.builder(arenaType, "arena").build()
            );
        }
        method.addParameters(filteredPoetArgs);
        method.addParameter(vipsOptionVarargType, "args");

        return new OperationMethod(
            method.build(),
            outputTypeSpec
        );
    }

    private static void generateMethodJavadoc(
        MethodSpec.Builder method,
        String methodName,
        VipsOperation spec,
        List<VipsOperation> operations,
        List<DiscoveredEnum> enums
    ) {
        if (spec.gir() == null || spec.gir().doc() == null) {
            method.addJavadoc(capitalizeVipsText(spec.description()));
            return;
        }

        var builtJavadoc = buildJavadoc(spec.gir().doc(), methodName, operations, enums);

        method.addJavadoc(builtJavadoc.doc(), (Object[]) builtJavadoc.classNames().toArray(new ClassName[0]));
    }

    private static void generateEnumJavadoc(
        TypeSpec.Builder enumBuilder,
        String methodName,
        String doc,
        List<VipsOperation> operations,
        List<DiscoveredEnum> enums
    ) {
        if (doc == null) {
            return;
        }

        var builtJavadoc = buildJavadoc(doc, methodName, operations, enums);

        enumBuilder.addJavadoc(builtJavadoc.doc(), (Object[]) builtJavadoc.classNames().toArray(new ClassName[0]));
    }

    record ClassMatch(
        ClassName className,
        int matchPosition
    ) {
    }

    record BuiltJavadoc(
        String doc,
        List<ClassName> classNames
    ) {
    }

    private static final Pattern sectionRegex = Pattern.compile("\n?:::(.*)\n([\\s\\S]+?)(?:$|\n\n)");
    private static final Pattern girReferenceRegex = Pattern.compile("\\[([A-Za-z0-9-_]+)@([A-Za-z0-9-_.:]+)]");
    private static final Pattern singleAtReferenceRegex = Pattern.compile("([\\n\\s]+)@([A-Za-z0-9-_]+)");

    private static BuiltJavadoc buildJavadoc(
        String doc,
        String name,
        List<VipsOperation> operations,
        List<DiscoveredEnum> enums
    ) {
        var girDoc = doc.replace("$", "$$");

        var classReferences = new ArrayList<ClassMatch>();

        var seeAlsoReferences = new ArrayList<String>();
        // parse known "sections"
        // example: ::: tip "Optional arguments"
        girDoc = replaceAll(girDoc, sectionRegex, match -> {
            var sectionName = match.group(1) == null ? "" : match.group(1).trim();
            var sectionDetail = match.group(2) == null ? "" : match.group(2).trim();
            if (sectionName.startsWith("tip")) {
                var tipName = Strings.trim(Strings.removePrefix(sectionName, "tip"), ' ', '"');
                switch (tipName.toLowerCase(Locale.ENGLISH)) {
                    // verifying the docs are laid out how we expect
                    case "optional arguments" -> {
                    }
                    // avoid unexpected surprises across versions
                    default -> throw new RuntimeException("unknown tip type: " + tipName);
                }
            } else if (sectionName.equals("seealso")) {
                // expect a comma separated list of references
                var seeAlsos = Arrays.stream(sectionDetail.split(","))
                    .map(it -> Strings.trim(it, ' ', '.', ',', '\n'))
                    .filter(it -> !it.isBlank())
                    .toList();
                if (seeAlsos.isEmpty()) {
                    throw new RuntimeException("unexpected empty seealso list");
                }
                seeAlsoReferences.addAll(seeAlsos);
            } else {
                throw new RuntimeException("unexpected section type: " + sectionName);
            }
            return ""; // always remove sections
        });

        // replace gir markdown references
        girDoc = replaceAll(girDoc, girReferenceRegex, match ->
            convertGirReferenceToPoetReference(
                match.group(),
                match.start(),
                enums,
                operations,
                classReferences
            )
        );

        girDoc = replaceAll(girDoc, singleAtReferenceRegex, match -> {
            // single @ references
            var whitespace = match.group(1);
            var matchName = match.group(2);
            return whitespace + "`" + matchName + "`";
        });

        if (!seeAlsoReferences.isEmpty()) {
            var seeAlsoPosition = girDoc.length();
            var references = seeAlsoReferences.stream()
                .map(it ->
                    convertGirReferenceToPoetReference(
                        it,
                        seeAlsoPosition,
                        enums,
                        operations,
                        classReferences
                    )
                )
                .collect(Collectors.joining(", "));
            girDoc += "\nSee also: " + references;
        }

        var orderedClassReferences = classReferences.stream()
            .sorted((left, right) -> Integer.compare(left.matchPosition(), right.matchPosition()))
            .map(ClassMatch::className)
            .toList();
        return new BuiltJavadoc(girDoc, orderedClassReferences);
    }

    private static String replaceAll(String input, Pattern pattern, Function<MatchResult, String> replacer) {
        var matcher = pattern.matcher(input);
        var builder = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(builder, Matcher.quoteReplacement(replacer.apply(matcher.toMatchResult())));
        }
        matcher.appendTail(builder);
        return builder.toString();
    }

    private static String convertGirReferenceToPoetReference(
        String match,
        int matchPosition,
        List<DiscoveredEnum> enums,
        List<VipsOperation> operations,
        List<ClassMatch> classReferences
    ) {
        // examples:
        // * [ctor@Image.new_from_file]
        // * [enum@Vips.BandFormat.UCHAR]
        // * "@something" - references a local parameter
        var trimmed = Strings.removeSurrounding(match, "[", "]");
        var matchType = Strings.substringBefore(trimmed, '@', "");
        var matchName = Strings.substringAfter(trimmed, '@', "");
        if (matchType.isBlank() && matchName.isBlank()) {
            throw new RuntimeException("unexpected format for reference: " + match);
        }

        switch (matchType) {
            case "enum" -> {
                var matchParts = List.of(matchName.split("\\.", -1));
                if (matchParts.get(0).equals("Vips")) {
                    matchParts = matchParts.subList(1, matchParts.size());
                }
                var enumName = matchParts.get(0);
                var matchedParentEnum = enums.stream()
                    .filter(it -> it.gir().name.equalsIgnoreCase(enumName))
                    .findFirst()
                    .orElse(null);
                if (matchedParentEnum == null) {
                    throw new RuntimeException("unknown enum: " + matchParts);
                }
                var classReference = new ClassMatch(
                    ClassName.get("app.photofox.vipsffm.enums", matchedParentEnum.name()),
                    matchPosition
                );
                if (matchParts.size() == 1) {
                    // a direct reference to an enum
                    classReferences.add(classReference);
                    return "[$T]";
                }
                // otherwise, includes an enum value reference
                var enumValue = matchParts.get(1);
                var matchedValue = matchedParentEnum.values().stream()
                    .filter(it -> it.nickname().equalsIgnoreCase(enumValue))
                    .findFirst()
                    .orElse(null);
                if (matchedValue != null) {
                    classReferences.add(classReference);
                    return "[$T#" + Strings.removePrefix(matchedValue.name(), "VIPS_") + "]";
                }
                return "`" + matchName + "`"; // fallback
            }

            case "method", "func", "ctor" -> {
                var matchParts = List.of(matchName.split("\\.", -1));
                if (matchParts.get(0).equals("Image")) {
                    var submatchName = matchParts.get(1);
                    var matchedOperation = operations.stream()
                        .filter(it -> it.nickname().equalsIgnoreCase(submatchName))
                        .findFirst()
                        .orElse(null);
                    if (matchedOperation == null) {
                        return "`" + matchName + "`";
                    }
                    var methodName = fromSnakeToJavaStyle(matchedOperation.nickname());
                    classReferences.add(new ClassMatch(vimageType, matchPosition));
                    return "[$T#" + methodName + "]";
                }
                return "`" + matchName + "`"; // fallback
            }

            case "class", "struct", "const", "alias", "flags", "signal" -> {
                return "`" + matchName + "`";
            }

            default -> throw new RuntimeException("unsupported gir lookup type: " + matchType);
        }
    }

    private static ClassName mapPoetTypeToVipsOptionType(
        TypeName poetArgType,
        VipsOperationArgument spec
    ) {
        if (poetArgType.equals(stringType)) {
            return vipsOptionStringType;
        } else if (poetArgType.equals(boxedIntType) || poetArgType.equals(TypeName.INT)) {
            return vipsOptionIntType;
        } else if (poetArgType.equals(boxedBooleanType) || poetArgType.equals(TypeName.BOOLEAN)) {
            return vipsOptionBooleanType;
        } else if (poetArgType.equals(boxedDoubleType) || poetArgType.equals(TypeName.DOUBLE)) {
            return vipsOptionDoubleType;
        } else if (poetArgType.equals(boxedLongType) || poetArgType.equals(TypeName.LONG)) {
            return vipsOptionLongType;
        } else if (poetArgType.equals(vimageType)) {
            return vipsOptionImageType;
        } else if (poetArgType.equals(vsourceType)) {
            return vipsOptionSourceType;
        } else if (poetArgType.equals(vtargetType)) {
            return vipsOptionTargetType;
        } else if (poetArgType.equals(vInterpolateType)) {
            return vipsOptionInterpolateType;
        } else if (poetArgType.equals(vEnumType)) {
            return vipsOptionEnumType;
        } else if (poetArgType.equals(vblobType)) {
            return vipsOptionBlobType;
        } else if (poetArgType instanceof ParameterizedTypeName parameterizedType && parameterizedType.rawType().equals(listType)) {
            var parameterizedArgument = parameterizedType.typeArguments().get(0);
            if (parameterizedArgument.equals(boxedDoubleType)) {
                return vipsOptionArrayDoubleType;
            } else if (parameterizedArgument.equals(boxedIntType)) {
                return vipsOptionArrayIntType;
            } else if (parameterizedArgument.equals(vimageType)) {
                return vipsOptionArrayImageType;
            }
            throw new RuntimeException("unknown array type for option \"" + spec.name() + "\": " + poetArgType);
        } else if (spec.isEnum()) {
            return vipsOptionEnumType;
        }
        throw new RuntimeException("unknown type for option \"" + spec.name() + "\": " + poetArgType);
    }

    private static TypeName mapArgSpecToPoetType(
        VipsOperationArgument argument
    ) {
        return switch (argument.type()) {
            case GValueType.Simple simple -> switch (simple) {
                case BOOLEAN -> TypeName.BOOLEAN;
                case INT -> TypeName.INT;
                case UINT64 -> TypeName.LONG;
                case DOUBLE -> TypeName.DOUBLE;
                case CHAR_ARRAY -> stringType;
                case ENUM -> TypeName.INT;
                case FLAGS -> TypeName.INT;
                case OBJECT -> null;
                case VIPS_IMAGE -> vimageType;
                case VIPS_ARRAY_INT -> ParameterizedTypeName.get(listType, boxedIntType);
                case VIPS_ARRAY_DOUBLE -> ParameterizedTypeName.get(listType, boxedDoubleType);
                case VIPS_ARRAY_IMAGE -> ParameterizedTypeName.get(listType, vimageType);
                case VIPS_REF_STRING -> stringType;
                case VIPS_BLOB -> vblobType;
                case VIPS_SOURCE -> vsourceType;
                case VIPS_TARGET -> vtargetType;
                case VIPS_INTERPOLATE -> vInterpolateType;
            };
            case GValueType.Unknown unknown -> {
                if (argument.isEnum()) {
                    yield ClassName.get("app.photofox.vipsffm.enums", unknown.rawName());
                } else if (unknown.rawName().startsWith("Vips")) {
                    // presume unknown, non-enum types are flags
                    yield TypeName.INT;
                } else {
                    yield null;
                }
            }
        };
    }

    private static List<MethodSpec> buildImageMethods() {
        var widthMethod = MethodSpec.methodBuilder("getWidth")
            .addModifiers(Modifier.PUBLIC)
            .returns(TypeName.INT)
            .addException(vipsErrorType)
            .addStatement("return $T.image_get_width(this.address)", vipsHelperType)
            .build();
        var heightMethod = MethodSpec.methodBuilder("getHeight")
            .addModifiers(Modifier.PUBLIC)
            .returns(TypeName.INT)
            .addException(vipsErrorType)
            .addStatement("return $T.image_get_height(this.address)", vipsHelperType)
            .build();
        var alphaMethod = MethodSpec.methodBuilder("hasAlpha")
            .addModifiers(Modifier.PUBLIC)
            .returns(TypeName.BOOLEAN)
            .addException(vipsErrorType)
            .addStatement("return $T.image_hasalpha(this.address)", vipsHelperType)
            .build();
        var newFromFileMethod = MethodSpec.methodBuilder("newFromFile")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(arenaType, "arena")
            .addParameter(stringType, "path")
            .addParameter(vipsOptionVarargType, "options")
            .returns(vimageType)
            .varargs(true)
            .addException(vipsErrorType)
            .addStatement("var filename = $T.filename_get_filename(arena, path)", vipsHelperType)
            .addStatement("var filenameOptions = $T.filename_get_options(arena, filename)", vipsHelperType)
            .addStatement("var loader = $T.foreign_find_load(arena, filename)", vipsHelperType)
            .addStatement("var filenameOption = $T(\"filename\", filename)", vipsOptionStringType)
            .addStatement("var outOption = $T(\"out\")", vipsOptionImageType)
            .addStatement("var callArgs = new ArrayList<>(Arrays.asList(options))")
            .addStatement("callArgs.add(filenameOption)")
            .addStatement("callArgs.add(outOption)")
            .addStatement("$T.invokeOperation(arena, loader, filenameOptions, callArgs)", vipsInvokerType)
            .addStatement("return outOption.valueOrThrow()")
            .build();
        var newFromSourceMethod = MethodSpec.methodBuilder("newFromSource")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(arenaType, "arena")
            .addParameter(vsourceType, "source")
            .addParameter(stringType, "optionString")
            .addParameter(vipsOptionVarargType, "options")
            .returns(vimageType)
            .varargs(true)
            .addException(vipsErrorType)
            .addStatement("var loader = $T.foreign_find_load_source(source.address)", vipsHelperType)
            .addStatement("var sourceOption = $T(\"source\", source)", vipsOptionSourceType)
            .addStatement("var outOption = $T(\"out\")", vipsOptionImageType)
            .addStatement("var callArgs = new ArrayList<>(Arrays.asList(options))")
            .addStatement("callArgs.add(sourceOption)")
            .addStatement("callArgs.add(outOption)")
            .addStatement("$T.invokeOperation(arena, loader, optionString, callArgs)", vipsInvokerType)
            .addStatement("return outOption.valueOrThrow()")
            .build();
        var newFromSourceNoOptionsMethod = MethodSpec.methodBuilder("newFromSource")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(arenaType, "arena")
            .addParameter(vsourceType, "source")
            .addParameter(vipsOptionVarargType, "options")
            .returns(vimageType)
            .varargs(true)
            .addException(vipsErrorType)
            .addStatement("return newFromSource(arena, source, \"\", options)")
            .build();
        var newFromBytesMethod = MethodSpec.methodBuilder("newFromBytes")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(arenaType, "arena")
            .addParameter(ArrayTypeName.of(TypeName.BYTE), "bytes")
            .addParameter(stringType, "optionString")
            .addParameter(vipsOptionVarargType, "options")
            .returns(vimageType)
            .varargs(true)
            .addException(vipsErrorType)
            .addStatement("var source = $T.newFromBytes(arena, bytes)", vsourceType)
            .addStatement("return newFromSource(arena, source, optionString, options)")
            .addJavadoc("Creates a new VImage from raw bytes. Note that this is quite inefficient, use [VImage#newFromFile] and friends instead.")
            .build();
        var newFromBytesNoOptionsMethod = MethodSpec.methodBuilder("newFromBytes")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(arenaType, "arena")
            .addParameter(ArrayTypeName.of(TypeName.BYTE), "bytes")
            .addParameter(vipsOptionVarargType, "options")
            .returns(vimageType)
            .varargs(true)
            .addException(vipsErrorType)
            .addStatement("var source = $T.newFromBytes(arena, bytes)", vsourceType)
            .addStatement("return newFromSource(arena, source, options)")
            .addJavadoc("See [VImage#newFromBytes]")
            .build();
        var newFromMemoryMethod = MethodSpec.methodBuilder("newFromMemory")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(arenaType, "arena")
            .addParameter(memorySegmentType, "memorySegment")
            .addParameter(TypeName.INT, "width")
            .addParameter(TypeName.INT, "height")
            .addParameter(TypeName.INT, "bands")
            .addParameter(TypeName.INT, "format")
            .returns(vimageType)
            .addException(vipsErrorType)
            .addStatement(
                "var imagePointer = $T.image_new_from_memory(arena, memorySegment, memorySegment.byteSize(), width, height, bands, format)",
                vipsHelperType
            )
            .addStatement("return new VImage(arena, imagePointer)")
            .addJavadoc(
                "Creates a new VImage from raw bytes, mapping directly to the `vips_image_new_from_memory` function, with some checks.\n"
                    + "\n"
                    + "This is included for narrow use cases where you have image bytes representing partially supported image formats from another library (like DICOM), and you need a way to get them in to libvips without using the built-in source loaders.\n"
                    + "Note that this uses the Java FFM [MemorySegment] API to avoid an unnecessary copy. \n"
                    + "\n"
                    + "This is an advanced method - if possible, use [VImage#newFromFile] and friends instead. If you have bytes to load, you could use [VImage#newFromBytes]."
            )
            .build();
        var newFromStreamMethod = MethodSpec.methodBuilder("newFromStream")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(arenaType, "arena")
            .addParameter(inputStreamType, "stream")
            .addParameter(stringType, "optionString")
            .addParameter(vipsOptionVarargType, "options")
            .returns(vimageType)
            .varargs(true)
            .addException(vipsErrorType)
            .addStatement("var source = $T.newFromInputStream(arena, stream)", vsourceType)
            .addStatement("return newFromSource(arena, source, optionString, options)")
            .addJavadoc(
                """
                Creates a new VImage from an [InputStream]. This uses libvips' "custom streaming" feature and is
                therefore quite efficient, avoiding the need to make extra full copies of the image's data.
                You could, for example, use this function to create an image directly from an API call, thumbnail it,
                and then upload directly to an S3-compatible API efficiently in memory - all without creating a local
                file."""
            )
            .build();
        var newFromStreamNoOptionsMethod = MethodSpec.methodBuilder("newFromStream")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(arenaType, "arena")
            .addParameter(inputStreamType, "stream")
            .addParameter(vipsOptionVarargType, "options")
            .returns(vimageType)
            .varargs(true)
            .addException(vipsErrorType)
            .addStatement("var source = $T.newFromInputStream(arena, stream)", vsourceType)
            .addStatement("return newFromSource(arena, source, options)")
            .addJavadoc("See [VImage#newFromStream]")
            .build();
        var writeToFileMethod = MethodSpec.methodBuilder("writeToFile")
            .addModifiers(Modifier.PUBLIC)
            .addParameter(stringType, "path")
            .addParameter(vipsOptionVarargType, "options")
            .varargs(true)
            .addException(vipsErrorType)
            .addStatement("var filename = $T.filename_get_filename(arena, path)", vipsHelperType)
            .addStatement("var filenameOptions = $T.filename_get_options(arena, filename)", vipsHelperType)
            .addStatement("var loader = $T.foreign_find_save(arena, filename)", vipsHelperType)
            .addStatement("var filenameOption = $T(\"filename\", filename)", vipsOptionStringType)
            .addStatement("var inOption = $T(\"in\", this)", vipsOptionImageType)
            .addStatement("var callArgs = new ArrayList<>(Arrays.asList(options))")
            .addStatement("callArgs.add(filenameOption)")
            .addStatement("callArgs.add(inOption)")
            .addStatement("$T.invokeOperation(arena, loader, filenameOptions, callArgs)", vipsInvokerType)
            .build();
        var writeToMemoryMethod = MethodSpec.methodBuilder("writeToMemory")
            .addModifiers(Modifier.PUBLIC)
            .returns(MemorySegment.class)
            .addException(vipsErrorType)
            .addStatement("var outLengthPointer = arena.allocate($T.C_LONG)", vipsRawType)
            .addStatement("var imageMemory = $T.image_write_to_memory(this.address, outLengthPointer)", vipsHelperType)
            .addStatement("var sizeOfImage = outLengthPointer.get($T.C_LONG, 0)", vipsRawType)
            .beginControlFlow("if (sizeOfImage < 0)")
            .addStatement(
                "throw new $T(\"unexpected image size after write\")",
                vipsErrorType
            )
            .endControlFlow()
            .addStatement("return imageMemory.reinterpret(arena, $T::g_free).asSlice(0, sizeOfImage)", vipsRawType)
            .addJavadoc(
                """
                Writes this VImage's raw pixel values to a [MemorySegment], in the following pixel order: RGBRGBRGB etc.
                It performs a full memory copy of the image, and so provides an image copying option that is thread-safe
                and independent of other VImage operations.

                In performance-critical scenarios where you need to avoid memory copies, and you are sure about the image's
                state and lifetime, prefer [VipsHelper#image_get_data] instead."""
            )
            .build();
        var writeToImageMethod = MethodSpec.methodBuilder("write")
            .addModifiers(Modifier.PUBLIC)
            .addParameter(vimageType, "out")
            .addException(vipsErrorType)
            .returns(vimageType)
            .addStatement("$T.image_write(this.address, out.address)", vipsHelperType)
            .addStatement("return out")
            .build();
        var writeToTargetMethod = MethodSpec.methodBuilder("writeToTarget")
            .addModifiers(Modifier.PUBLIC)
            .addParameter(vtargetType, "target")
            .addParameter(stringType, "suffix")
            .varargs(true)
            .addParameter(vipsOptionVarargType, "options")
            .addException(vipsErrorType)
            .addStatement("var loader = $T.foreign_find_save_target(arena, suffix)", vipsHelperType)
            .addStatement("var inOption = $T(\"in\", this)", vipsOptionImageType)
            .addStatement("var targetOption = $T(\"target\", target)", vipsOptionTargetType)
            .addStatement("var callArgs = new ArrayList<>(Arrays.asList(options))")
            .addStatement("callArgs.add(inOption)")
            .addStatement("callArgs.add(targetOption)")
            .addStatement("$T.invokeOperation(arena, loader, callArgs)", vipsInvokerType)
            .build();
        var writeToStreamMethod = MethodSpec.methodBuilder("writeToStream")
            .addModifiers(Modifier.PUBLIC)
            .addParameter(outputStreamType, "stream")
            .addParameter(stringType, "suffix")
            .varargs(true)
            .addParameter(vipsOptionVarargType, "options")
            .addException(vipsErrorType)
            .addStatement("var target = $T.newFromOutputStream(arena, stream)", vtargetType)
            .addStatement("this.writeToTarget(target, suffix, options)")
            .addJavadoc(
                """
                Writes this VImage to an [OutputStream]. This uses libvips' "custom streaming" feature and is
                therefore quite efficient, avoiding the need to make extra full copies of the image's data.
                You could, for example, use this function to create an image directly from an API call, thumbnail it,
                and then upload directly to an S3-compatible API efficiently in memory - all without creating a local
                file."""
            )
            .build();
        var newImageMethod = MethodSpec.methodBuilder("newImage")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(arenaType, "arena")
            .addException(vipsErrorType)
            .returns(vimageType)
            .addStatement("var newImagePointer = $T.image_new(arena)", vipsHelperType)
            .addStatement("return new $T(arena, newImagePointer)", vimageType)
            .build();

        var newMatrixMethod = MethodSpec.methodBuilder("newMatrix")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(arenaType, "arena")
            .addParameter(TypeName.INT, "width")
            .addParameter(TypeName.INT, "height")
            .addException(vipsErrorType)
            .returns(vimageType)
            .addStatement("var newImagePointer = $T.image_new_matrix(arena, width, height)", vipsHelperType)
            .addStatement("return new $T(arena, newImagePointer)", vimageType)
            .addJavadoc(
                """
                A convenience function for creating a new matrix image: a one-band image storing doubles.

                See also: [libvips new_matrix docs](https://www.libvips.org/API/8.17/ctor.Image.new_matrix.html)"""
            )
            .build();

        var newMatrixFromArrayMethod = MethodSpec.methodBuilder("newMatrixFromArray")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(arenaType, "arena")
            .addParameter(TypeName.INT, "width")
            .addParameter(TypeName.INT, "height")
            .addParameter(ArrayTypeName.of(TypeName.DOUBLE), "array")
            .addException(vipsErrorType)
            .returns(vimageType)
            .addStatement("var segment = arena.allocateFrom($T.JAVA_DOUBLE, array)", valueLayoutType)
            .addStatement("var newImagePointer = $T.image_new_matrix_from_array(arena, width, height, segment, array.length)", vipsHelperType)
            .addStatement("return new $T(arena, newImagePointer)", vimageType)
            .addJavadoc(
                """
                A convenience function for creating a new matrix image: a one-band image storing doubles.
                Also initialises the image with the provided double values, copying them to native memory in the process.

                See also: [VImage#newMatrix]"""
            )
            .build();

        var getSetMethods = buildImageGetSetMethods();

        var methods = new ArrayList<>(List.of(
            widthMethod,
            heightMethod,
            alphaMethod,
            newFromFileMethod,
            newFromSourceMethod,
            newFromSourceNoOptionsMethod,
            newFromBytesMethod,
            newFromBytesNoOptionsMethod,
            newFromMemoryMethod,
            newFromStreamMethod,
            newFromStreamNoOptionsMethod,
            newMatrixMethod,
            newMatrixFromArrayMethod,
            writeToFileMethod,
            writeToImageMethod,
            writeToTargetMethod,
            writeToStreamMethod,
            writeToMemoryMethod,
            newImageMethod
        ));
        methods.addAll(getSetMethods);
        return methods;
    }

    private static List<MethodSpec> buildImageGetSetMethods() {
        // image_get_(string|int|double)
        // image_set_(string|int|double)
        // image_set_array_(string|int|double)
        // image_set_array_(string|int|double)

        var methods = new ArrayList<MethodSpec>();

        var types = List.of("string", "int", "double", "blob", "image");
        for (var typeName : types) {
            var titlecasedTypename = Character.toTitleCase(typeName.charAt(0)) + typeName.substring(1);
            var poetValueType = switch (typeName) {
                case "string" -> stringType;
                case "int" -> boxedIntType;
                case "double" -> boxedDoubleType;
                case "blob" -> vblobType;
                case "image" -> vimageType;
                default -> throw new RuntimeException("unexpected type");
            };
            var setMethodBuilder = MethodSpec.methodBuilder("set")
                .addModifiers(Modifier.PUBLIC)
                .addParameter(stringType, "name")
                .addParameter(poetValueType, "value");
            if (poetValueType.equals(vblobType)) {
                setMethodBuilder.addStatement(
                    "$T.image_set_" + typeName + "(arena, this.address, name, $T.NULL, value.getUnsafeDataAddress(), value.byteSize())",
                    vipsHelperType,
                    memorySegmentType
                );
            } else if (poetValueType.equals(vimageType)) {
                setMethodBuilder.addStatement(
                    "$T.image_set_" + typeName + "(arena, this.address, name, value.address)",
                    vipsHelperType
                );
            } else {
                setMethodBuilder.addStatement(
                    "$T.image_set_" + typeName + "(arena, this.address, name, value)",
                    vipsHelperType
                );
            }
            var setMethod = setMethodBuilder
                .addStatement("return this")
                .addJavadoc(
                    "Helper function to set the metadata stored at `name` on this image, of type `" + typeName + "`\n"
                        + "\n"
                        + "See also: [libvips header docs](https://www.libvips.org/API/current/libvips-header.html)"
                )
                .returns(vimageType)
                .build();
            var getMethodBuilder = MethodSpec.methodBuilder("get" + titlecasedTypename)
                .addModifiers(Modifier.PUBLIC)
                .addParameter(stringType, "name")
                .returns(poetValueType)
                .addStatement("var type = $T.image_get_typeof(arena, this.address, name)", vipsHelperType)
                .addCode(
                    CodeBlock.builder()
                        .beginControlFlow("if (type == 0)")
                        .addStatement("return null")
                        .endControlFlow()
                        .build()
                )
                .addStatement("var outPointer = arena.allocate($T.C_POINTER)", vipsRawType);
            if (poetValueType.equals(vblobType)) {
                getMethodBuilder.addStatement("var outLengthPointer = arena.allocate($T.C_LONG)", vipsRawType);
                getMethodBuilder.addStatement(
                    "var result = $T.image_get_" + typeName + "(arena, this.address, name, outPointer, outLengthPointer)",
                    vipsHelperType
                );
            } else {
                getMethodBuilder.addStatement(
                    "var result = $T.image_get_" + typeName + "(arena, this.address, name, outPointer)",
                    vipsHelperType
                );
            }
            getMethodBuilder
                .addJavadoc(
                    "Helper function to get the metadata stored at `name` on this image, of type `" + typeName + "`, or `null`\n"
                        + "if not present\n"
                        + "\n"
                        + "See also: [libvips header docs](https://www.libvips.org/API/current/libvips-header.html)"
                )
                .addCode(
                    CodeBlock.builder()
                        .beginControlFlow("if (!$T.isValidResult(result))", vipsValidatorType)
                        .addStatement("$T.throwVipsError(\"image_get_" + typeName + "\")", vipsValidatorType)
                        .endControlFlow()
                        .build()
                )
                .addCode(
                    CodeBlock.builder()
                        .beginControlFlow("if (!$T.isValidPointer(outPointer))", vipsValidatorType)
                        .addStatement("throw new VipsError(\"failed to read value of type " + typeName + " from field: \" + name)")
                        .endControlFlow()
                        .build()
                );
            if (poetValueType.equals(stringType)) {
                // const char **
                getMethodBuilder.addStatement("var dereferenced = outPointer.get($T.C_POINTER, 0)", vipsRawType);
                getMethodBuilder.addStatement("return dereferenced.getString(0)");
            } else if (poetValueType.equals(boxedIntType)) {
                // int *
                getMethodBuilder.addStatement("return outPointer.get($T.C_INT, 0)", vipsRawType);
            } else if (poetValueType.equals(boxedDoubleType)) {
                // double *
                getMethodBuilder.addStatement("return outPointer.get($T.C_DOUBLE, 0)", vipsRawType);
            } else if (poetValueType.equals(vblobType)) {
                // void **
                getMethodBuilder.addCode(
                    CodeBlock.builder()
                        .beginControlFlow("if (!$T.isValidPointer(outLengthPointer))", vipsValidatorType)
                        .addStatement("throw new VipsError(\"failed to read length pointer of type " + typeName + " from field: \" + name)")
                        .endControlFlow()
                        .build()
                );
                getMethodBuilder.addStatement("var blobLength = outLengthPointer.get($T.C_LONG, 0)", vipsRawType);
                getMethodBuilder.addCode(
                    CodeBlock.builder()
                        .beginControlFlow("if (blobLength <= 0)")
                        .addStatement("throw new VipsError(\"failed to read length of type " + typeName + " from field: \" + name)")
                        .endControlFlow()
                        .build()
                );
                getMethodBuilder.addStatement("var dataSegment = outPointer.get($T.C_POINTER, 0).reinterpret(blobLength)", vipsRawType);
                getMethodBuilder.addStatement("return VBlob.newFromDataSegment(arena, dataSegment)");
            } else if (poetValueType.equals(vimageType)) {
                // VImage **
                getMethodBuilder.addStatement(
                    "var imageAddress = outPointer.get($T.C_POINTER, 0).reinterpret(arena, $T::g_object_unref)",
                    vipsRawType,
                    vipsRawType
                );
                getMethodBuilder.addStatement("return new VImage(arena, imageAddress)");
            } else {
                throw new RuntimeException("unexpected type");
            }
            var getMethod = getMethodBuilder.build();
            methods.add(getMethod);
            methods.add(setMethod);
        }

        // javapoet doesn't natively support block lambdas, so we have to do some of this manually
        // it's worth it to be able to use vips_image_map
        var fieldsLambda = CodeBlock.builder()
            .add("(_, name, _, _) -> {\n").indent()
            .add("if (!$T.isValidPointer(name)) {\n", vipsValidatorType).indent()
            .add("return $T.NULL;\n", memorySegmentType)
            .unindent().add("}\n")
            .add("fieldNameStrings.add(name.getString(0));\n")
            .add("return $T.NULL;\n", memorySegmentType)
            .unindent().add("}")
            .build();
        var lambdaCall = CodeBlock.builder()
            .addStatement("$T.Function fn = $L", vipsImageMapFnType, fieldsLambda)
            .build();
        var fieldsMethod = MethodSpec.methodBuilder("getFields")
            .addModifiers(Modifier.PUBLIC)
            .returns(listStringType)
            .addStatement("var fieldNameStrings = new ArrayList<String>()")
            .addCode(lambdaCall)
            .addStatement("var callbackPointer = $T.allocate(fn, arena)", vipsImageMapFnType)
            .addStatement("$T.vips_image_map(this.address, callbackPointer, $T.NULL)", vipsRawType, memorySegmentType)
            .addStatement("return fieldNameStrings")
            .addJavadoc(
                """
                Returns a list of all metadata entry names for this image

                See also: [libvips header docs](https://www.libvips.org/API/current/libvips-header.html)"""
            )
            .build();
        methods.add(fieldsMethod);

        var removeMethod = MethodSpec.methodBuilder("remove")
            .addModifiers(Modifier.PUBLIC)
            .returns(TypeName.BOOLEAN)
            .addParameter(stringType, "name")
            .addStatement("return $T.image_remove(arena, this.address, name)", vipsHelperType)
            .addJavadoc(
                """
                Helper function to remove the metadata stored at `name` on this image

                Returns false if there was no metadata entry at `name`

                See also: [libvips header docs](https://www.libvips.org/API/current/libvips-header.html)"""
            )
            .build();
        methods.add(removeMethod);

        return methods;
    }

    record DiscoveredEnum(
        String name,
        List<EnumValue> values,
        DiscoverVipsOperations.GIRRepository.GIREnumeration gir
    ) {
    }

    record EnumValue(
        String name,
        String nickname,
        int rawValue,
        DiscoverVipsOperations.GIRRepository.GIREnumerationMember gir
    ) {
    }

    private static DiscoveredEnum discoverEnumClass(
        Arena arena,
        String parentName,
        List<VipsEnum> enums
    ) {
        var gtype = VipsRaw.g_type_from_name(arena.allocateFrom(parentName));
        var genumclass = VipsRaw.g_type_class_ref(gtype);
        var numValues = GEnumClass.n_values(genumclass);
        var valuesPointer = GEnumClass.values(genumclass);

        var girEnum = enums.stream()
            .filter(it -> parentName.equals(it.gir().cType))
            .findFirst()
            .orElseThrow();

        var values = new ArrayList<EnumValue>();
        for (var index = 0; index < numValues; index++) {
            var enumValuePointer = valuesPointer.asSlice(index * GEnumValue.layout().byteSize());
            var enumValueName = GEnumValue.value_name(enumValuePointer).getString(0);
            var enumValueRawValue = GEnumValue.value(enumValuePointer);
            var enumValueNickname = GEnumValue.value_nick(enumValuePointer).getString(0);

            var girEnumValue = girEnum.gir().getMembers().stream()
                .filter(it -> enumValueName.equals(it.cIdentifier()))
                .findFirst()
                .orElseThrow();

            values.add(new EnumValue(
                enumValueName,
                enumValueNickname,
                enumValueRawValue,
                girEnumValue
            ));
        }
        return new DiscoveredEnum(
            parentName,
            values,
            girEnum.gir()
        );
    }

    private static void buildEnumClass(
        DiscoveredEnum spec,
        List<VipsOperation> operations,
        List<DiscoveredEnum> enums
    ) throws IOException {
        var parentName = spec.name();
        logger.info("generating enum {}", spec.name());

        var enumClassBuilder = TypeSpec.enumBuilder(parentName)
            .addModifiers(Modifier.PUBLIC)
            .addField(
                FieldSpec.builder(stringType, "parentName")
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                    .initializer("$S", parentName)
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
                    .addAnnotation(Override.class)
                    .returns(stringType)
                    .addStatement("return this.vipsName")
                    .build()
            )
            .addMethod(
                MethodSpec.methodBuilder("getNickname")
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override.class)
                    .returns(stringType)
                    .addStatement("return this.vipsNickname")
                    .build()
            )
            .addMethod(
                MethodSpec.methodBuilder("getRawValue")
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override.class)
                    .returns(TypeName.INT)
                    .addStatement("return this.rawValue")
                    .build()
            );
        for (var value : spec.values()) {
            var constantSpec = TypeSpec.anonymousClassBuilder("$S, $S, $L", value.name(), value.nickname(), value.rawValue());
            generateEnumJavadoc(constantSpec, value.name(), value.gir().doc(), operations, enums);
            enumClassBuilder.addEnumConstant(
                Strings.removePrefix(value.name(), "VIPS_"),
                constantSpec.build()
            );
        }
        generateEnumJavadoc(enumClassBuilder, parentName, spec.gir().doc, operations, enums);
        var enumClass = enumClassBuilder.build();
        var enumFile = JavadocMarkdownConversion.convert(
            JavaFile.builder("app.photofox.vipsffm.enums", enumClass)
                .build()
                .toString()
        );
        var targetGeneratedSourceRoot = Path.of("core/src/main/java/app/photofox/vipsffm/enums");
        Files.writeString(targetGeneratedSourceRoot.resolve(parentName + ".java"), enumFile, StandardCharsets.UTF_8);
    }

    private static String capitalizeVipsText(String original) {
        if (original.isEmpty()) {
            return original;
        }
        var first = original.charAt(0);
        if (!Character.isLowerCase(first)) {
            return original;
        }
        return Character.toTitleCase(first) + original.substring(1);
    }
}
