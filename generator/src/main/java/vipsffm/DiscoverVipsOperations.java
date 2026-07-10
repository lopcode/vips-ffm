package vipsffm;

import app.photofox.vipsffm.jextract.GParamSpec;
import app.photofox.vipsffm.jextract.GTypeClass;
import app.photofox.vipsffm.jextract.GTypeInstance;
import app.photofox.vipsffm.jextract.VipsRaw;
import app.photofox.vipsffm.jextract.VipsTypeMap2Fn;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static app.photofox.vipsffm.jextract.VipsRaw.C_INT;
import static app.photofox.vipsffm.jextract.VipsRaw.C_LONG;
import static app.photofox.vipsffm.jextract.VipsRaw.C_POINTER;
import static app.photofox.vipsffm.jextract.VipsRaw.VIPS_ARGUMENT_DEPRECATED;
import static app.photofox.vipsffm.jextract.VipsRaw.VIPS_ARGUMENT_INPUT;
import static app.photofox.vipsffm.jextract.VipsRaw.VIPS_ARGUMENT_MODIFY;
import static app.photofox.vipsffm.jextract.VipsRaw.VIPS_ARGUMENT_OUTPUT;
import static app.photofox.vipsffm.jextract.VipsRaw.VIPS_ARGUMENT_REQUIRED;

public class DiscoverVipsOperations {

    private static final Logger logger = LoggerFactory.getLogger(DiscoverVipsOperations.class);
    private static final Path girPath = Path.of("/opt/homebrew/share/gir-1.0/Vips-8.0.gir");

    public static void main(String[] args) throws Exception {
        DiscoveredOperations discoveredOperations;
        try (var arena = Arena.ofConfined()) {
            discoveredOperations = run(arena);
        }
        var operations = discoveredOperations.operations();

        var numberWithGir = operations.stream().filter(it -> it.gir() != null).count();
        logger.info("found {} operations ({} with GIR info):", operations.size(), numberWithGir);
        operations.forEach(it ->
            logger.info("  {}", it.nickname())
        );
        if (numberWithGir != operations.size()) {
            logger.info("missing GIR info:");
            operations.stream().filter(it -> it.gir() == null).forEach(it ->
                logger.info("  {}", it.nickname())
            );
        }
    }

    public static DiscoveredOperations run(Arena arena) throws IOException {
        VipsRaw.vips_init(arena.allocateFrom("vips-ffm"));

        var gir = discoverGIR();
        var girMethods = gir.operations();

        var baseObjectGtype = VipsRaw.g_type_from_name(arena.allocateFrom("VipsObject"));
        var paramEnumGType = discoverParamEnumGType();

        var candidateOperations = new ArrayList<VipsOperation>();
        var callbackPointerHolder = new MemorySegment[1];

        // recursively walk the tree of types starting from VipsObject
        VipsTypeMap2Fn.Function recursiveCallback = (type, a, b) -> {
            var subtypeNickname = VipsRaw.vips_nickname_find(type).getString(0);

            try {
                var operation = VipsRaw.vips_operation_new(arena.allocateFrom(subtypeNickname));
                if (operation.address() == 0L || operation.equals(MemorySegment.NULL)) {
                    logger.info("skipping {}, couldn't make operation", subtypeNickname);
                    VipsRaw.vips_type_map(type, callbackPointerHolder[0], MemorySegment.NULL, MemorySegment.NULL);
                    return MemorySegment.NULL;
                }
                var description = VipsRaw.vips_object_get_description(operation).getString(0);
                var flags = VipsRaw.vips_operation_get_flags(operation);

                var isDeprecated = (flags & VipsRaw.VIPS_OPERATION_DEPRECATED()) == VipsRaw.VIPS_OPERATION_DEPRECATED();

                logger.info("found {}:", subtypeNickname);
                logger.info(" description: {}", description);

                // not bothered about memory leaks during generation
                var namesPointer = arena.allocate(C_POINTER);
                var flagsPointer = arena.allocate(C_POINTER);
                var numArgsPointer = arena.allocate(C_POINTER);
                VipsRaw.vips_object_get_args(operation, namesPointer, flagsPointer, numArgsPointer);
                var namesArray = namesPointer.get(C_POINTER, 0);
                var flagsArray = flagsPointer.get(C_POINTER, 0);
                var numArgs = (long) numArgsPointer.get(C_INT, 0);
                var args = new ArrayList<VipsOperationArgument>();
                for (var index = 0L; index < numArgs; index++) {
                    var namePointer = namesArray.get(C_POINTER, index * C_POINTER.byteSize());
                    var name = namePointer.getString(0);
                    var argFlags = flagsArray.get(C_INT, index * C_INT.byteSize());

                    var pspecPointer = arena.allocate(C_POINTER);
                    var argumentClassPointer = arena.allocate(C_POINTER);
                    var argumentInstancePointer = arena.allocate(C_POINTER);
                    var result = VipsRaw.vips_object_get_argument(operation, arena.allocateFrom(name), pspecPointer, argumentClassPointer, argumentInstancePointer);
                    if (result != 0) {
                        throw new RuntimeException("failed to get object argument");
                    }
                    var pspec = GParamSpec.reinterpret(pspecPointer.get(C_POINTER, 0), arena, segment -> {});
                    var blurb = VipsRaw.g_param_spec_get_blurb(pspec).getString(0);
                    var paramType = GParamSpec.value_type(pspec);
                    var typeName = VipsRaw.g_type_name(paramType).getString(0);

                    args.add(new VipsOperationArgument(
                        name,
                        argFlags,
                        blurb,
                        GValueType.fromString(typeName),
                        (argFlags & VIPS_ARGUMENT_REQUIRED()) == VIPS_ARGUMENT_REQUIRED(),
                        (argFlags & VIPS_ARGUMENT_INPUT()) == VIPS_ARGUMENT_INPUT(),
                        (argFlags & VIPS_ARGUMENT_OUTPUT()) == VIPS_ARGUMENT_OUTPUT(),
                        (argFlags & VIPS_ARGUMENT_DEPRECATED()) == VIPS_ARGUMENT_DEPRECATED(),
                        (argFlags & VIPS_ARGUMENT_MODIFY()) == VIPS_ARGUMENT_MODIFY(),
                        isParamSpecAnEnum(pspec, paramEnumGType)
                    ));
                }

                if (candidateOperations.stream().noneMatch(it -> it.nickname().equals(subtypeNickname))) {
                    var girMethod = girMethods.stream()
                        .filter(it -> Objects.equals(it.cIdentifier(), "vips_" + subtypeNickname))
                        .findFirst()
                        .orElse(null);
                    if (girMethod == null) {
                        logger.warn("failed to find GIR information for method: {}", subtypeNickname);
                    }
                    candidateOperations.add(new VipsOperation(subtypeNickname, description, args, isDeprecated, girMethod));
                }
            } catch (Throwable t) {
                logger.info("skipping " + subtypeNickname + ", couldn't introspect", t);
            }

            VipsRaw.vips_type_map(type, callbackPointerHolder[0], MemorySegment.NULL, MemorySegment.NULL);
            return MemorySegment.NULL;
        };

        callbackPointerHolder[0] = VipsTypeMap2Fn.allocate(recursiveCallback, arena);
        VipsRaw.vips_type_map(baseObjectGtype, callbackPointerHolder[0], MemorySegment.NULL, MemorySegment.NULL);

        return new DiscoveredOperations(
            candidateOperations.stream().sorted((left, right) -> left.nickname().compareTo(right.nickname())).toList(),
            gir.enums().stream().map(VipsEnum::new).toList()
        );
    }

    public static class GIRRepository {

        private List<GIRNamespace> namespaces = List.of();

        @JacksonXmlProperty(localName = "namespace")
        @JacksonXmlElementWrapper(useWrapping = false)
        public void setNamespaces(List<GIRNamespace> value) {
            namespaces = concat(namespaces, value);
        }

        public List<GIRNamespace> getNamespaces() {
            return namespaces;
        }

        public static class GIRNamespace {
            private String name = "";
            private List<GIRClass> classes = List.of();
            private List<GIRMethod> functions = List.of();
            private List<GIREnumeration> enumerations = List.of();

            @JacksonXmlProperty(isAttribute = true)
            public void setName(String value) {
                name = name + value;
            }

            public String getName() {
                return name;
            }

            @JacksonXmlProperty(localName = "class")
            @JacksonXmlElementWrapper(useWrapping = false)
            public void setClasses(List<GIRClass> value) {
                classes = concat(classes, value);
            }

            public List<GIRClass> getClasses() {
                return classes;
            }

            @JacksonXmlProperty(localName = "function")
            @JacksonXmlElementWrapper(useWrapping = false)
            public void setFunctions(List<GIRMethod> value) {
                functions = concat(functions, value);
            }

            public List<GIRMethod> getFunctions() {
                return functions;
            }

            @JacksonXmlProperty(localName = "enumeration")
            @JacksonXmlElementWrapper(useWrapping = false)
            public void setEnumerations(List<GIREnumeration> value) {
                enumerations = concat(enumerations, value);
            }

            public List<GIREnumeration> getEnumerations() {
                return enumerations;
            }
        }

        public static class GIRClass {
            @JacksonXmlProperty(isAttribute = true)
            public String name = "";

            private List<GIRMethod> constructors = List.of();
            private List<GIRMethod> methods = List.of();

            @JacksonXmlProperty(localName = "constructor")
            @JacksonXmlElementWrapper(useWrapping = false)
            public void setConstructors(List<GIRMethod> value) {
                constructors = concat(constructors, value);
            }

            public List<GIRMethod> getConstructors() {
                return constructors;
            }

            @JacksonXmlProperty(localName = "method")
            @JacksonXmlElementWrapper(useWrapping = false)
            public void setMethods(List<GIRMethod> value) {
                methods = concat(methods, value);
            }

            public List<GIRMethod> getMethods() {
                return methods;
            }
        }

        public record GIRMethod(
            @JacksonXmlProperty(isAttribute = true) String name,
            @JacksonXmlProperty(isAttribute = true, namespace = "c", localName = "identifier") String cIdentifier,
            String doc,
            @JacksonXmlElementWrapper(useWrapping = true) List<GIRParameter> parameters,
            GIRParameter returnValue
        ) {
        }

        public record GIRParameter(
            @JacksonXmlProperty(isAttribute = true) String name,
            @JacksonXmlProperty(isAttribute = true, localName = "transfer-ownership") String transferOwnership,
            @JacksonXmlProperty(isAttribute = true) String direction,
            GIRType type,
            Object varargs
        ) {
        }

        public record GIRType(
            @JacksonXmlProperty(isAttribute = true) String name
        ) {
        }

        public static class GIREnumeration {
            @JacksonXmlProperty(isAttribute = true)
            public String name = "";

            @JacksonXmlProperty(isAttribute = true, namespace = "c", localName = "type")
            public String cType = null;

            public String doc = null;

            private List<GIREnumerationMember> members = List.of();

            @JacksonXmlProperty(localName = "member")
            @JacksonXmlElementWrapper(useWrapping = false)
            public void setMembers(List<GIREnumerationMember> value) {
                members = concat(members, value);
            }

            public List<GIREnumerationMember> getMembers() {
                return members;
            }
        }

        public record GIREnumerationMember(
            @JacksonXmlProperty(isAttribute = true) String name,
            @JacksonXmlProperty(isAttribute = true, namespace = "c", localName = "identifier") String cIdentifier,
            String doc
        ) {
        }

        // matches the merging behaviour Jackson relied on when these models were Kotlin
        // properties with accumulating setters (`field += value`)
        private static <T> List<T> concat(List<T> existing, List<T> additions) {
            var merged = new ArrayList<>(existing);
            merged.addAll(additions);
            return merged;
        }
    }

    record DiscoveredGIRInfo(
        List<GIRRepository.GIRMethod> operations,
        List<GIRRepository.GIREnumeration> enums
    ) {
    }

    private static DiscoveredGIRInfo discoverGIR() throws IOException {
        try (var xmlInputStream = Files.newInputStream(girPath)) {
            var xmlMapper = XmlMapper.builder()
                .defaultUseWrapper(false)
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .build();

            var xml = xmlMapper.readValue(xmlInputStream, GIRRepository.class);
            var vipsNamespaceXml = xml.getNamespaces().stream()
                .filter(it -> it.getName().equals("Vips"))
                .findFirst()
                .orElseThrow();
            var classMethods = vipsNamespaceXml.getClasses().stream()
                .flatMap(it -> it.getMethods().stream())
                .toList();
            var functions = vipsNamespaceXml.getFunctions();
            var allMethods = new ArrayList<>(classMethods);
            allMethods.addAll(functions);
            var enums = vipsNamespaceXml.getEnumerations();

            logger.info("found {} methods, {} in GIR", allMethods.size(), enums.size());
            return new DiscoveredGIRInfo(allMethods, enums);
        }
    }

    private static long discoverParamEnumGType() {
        var paramSpecArrayPointer = VipsRaw.g_param_spec_types();
        for (var i = 0L; i <= 16L; i++) {
            var gtype = paramSpecArrayPointer.get(C_LONG, i * C_LONG.byteSize());
            var name = VipsRaw.g_type_name(gtype).getString(0);
            if (name.equals("GParamEnum")) {
                return gtype;
            }
        }
        throw new RuntimeException("failed to find GParamEnum type - is glib loaded?");
    }

    private static boolean isParamSpecAnEnum(MemorySegment paramSpec, long paramSpecEnumGType) {
        var gclass = GTypeInstance.g_class(paramSpec);
        var gtype = GTypeClass.g_type(gclass);
        if (gtype == paramSpecEnumGType) {
            return true;
        }
        return VipsRaw.g_type_check_instance_is_a(paramSpec, paramSpecEnumGType) == 1;
    }
}
