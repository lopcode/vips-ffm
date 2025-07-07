package vipsffm

import app.photofox.vipsffm.jextract.GParamSpec
import app.photofox.vipsffm.jextract.GTypeClass
import app.photofox.vipsffm.jextract.GTypeInstance
import app.photofox.vipsffm.jextract.VipsRaw
import app.photofox.vipsffm.jextract.VipsRaw.C_INT
import app.photofox.vipsffm.jextract.VipsRaw.C_LONG
import app.photofox.vipsffm.jextract.VipsRaw.C_POINTER
import app.photofox.vipsffm.jextract.VipsRaw.VIPS_ARGUMENT_DEPRECATED
import app.photofox.vipsffm.jextract.VipsRaw.VIPS_ARGUMENT_INPUT
import app.photofox.vipsffm.jextract.VipsRaw.VIPS_ARGUMENT_MODIFY
import app.photofox.vipsffm.jextract.VipsRaw.VIPS_ARGUMENT_OUTPUT
import app.photofox.vipsffm.jextract.VipsRaw.VIPS_ARGUMENT_REQUIRED
import app.photofox.vipsffm.jextract.VipsTypeMap2Fn
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.slf4j.LoggerFactory
import java.lang.System.getenv
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment
import java.nio.file.Files
import java.nio.file.Path

data class DiscoveredOperations(
    val operations: List<VipsOperation>,
    val enums: List<VipsEnum>
)

data class VipsOperation(
    val nickname: String,
    val description: String,
    val args: List<VipsOperationArgument>,
    val isDeprecated: Boolean,
    val gir: DiscoverVipsOperations.GIRRepository.GIRMethod?
) {
    override fun toString(): String {
        val gir = if (gir != null) {
            "has gir"
        } else {
            "no gir"
        }
        return "VipsOperation(nickname=$nickname, ${args.size} args, $gir)"
    }
}

data class VipsEnum(
    val gir: DiscoverVipsOperations.GIRRepository.GIREnumeration
)

sealed class GValueType {

    data object Boolean: GValueType()
    data object Int: GValueType()
    data object UInt64: GValueType()
    data object Double: GValueType()
    data object CharArray: GValueType()
    data object Enum: GValueType()
    data object Flags: GValueType()
    data object Object: GValueType()
    data object VipsImage: GValueType()
    data object VipsArrayInt: GValueType()
    data object VipsArrayDouble: GValueType()
    data object VipsArrayImage: GValueType()
    data object VipsRefString: GValueType()
    data object VipsBlob: GValueType()
    data object VipsSource: GValueType()
    data object VipsTarget: GValueType()
    data object VipsInterpolate: GValueType()
    data class Unknown(val rawName: String): GValueType()
}

fun String.toGValueType(): GValueType {
    return when (this) {
        "gboolean" -> GValueType.Boolean
        "gint" -> GValueType.Int
        "guint64" -> GValueType.UInt64
        "gdouble" -> GValueType.Double
        "gchararray" -> GValueType.CharArray
        "GEnum" -> GValueType.Enum
        "GFlags" -> GValueType.Flags
        "GObject" -> GValueType.Object
        "VipsImage" -> GValueType.VipsImage
        "VipsArrayInt" -> GValueType.VipsArrayInt
        "VipsArrayDouble" -> GValueType.VipsArrayDouble
        "VipsArrayImage" -> GValueType.VipsArrayImage
        "VipsRefString" -> GValueType.VipsRefString
        "VipsBlob" -> GValueType.VipsBlob
        "VipsSource" -> GValueType.VipsSource
        "VipsTarget" -> GValueType.VipsTarget
        "VipsInterpolate" -> GValueType.VipsInterpolate
        else -> GValueType.Unknown(this)
    }
}

data class VipsOperationArgument(
    val name: String,
    val flags: Int,
    val blurb: String,
    val type: GValueType,
    val isRequired: Boolean,
    val isInput: Boolean,
    val isOutput: Boolean,
    val isDeprecated: Boolean,
    val isModify: Boolean,
    val isEnum: Boolean
)

private val logger = LoggerFactory.getLogger(DiscoverVipsOperations::class.java)

fun main() {
    val discoveredOperations = Arena.ofConfined().use {
        DiscoverVipsOperations.run(it)
    }
    val operations = discoveredOperations.operations

    val numberWithGir = operations.count { it.gir != null }
    logger.info("found ${operations.size} operations ($numberWithGir with GIR info):")
    operations.forEach {
        logger.info("  ${it.nickname}")
    }
    if (numberWithGir != operations.size) {
        logger.info("missing GIR info:")
        operations.filter { it.gir == null }.forEach {
            logger.info("  ${it.nickname}")
        }
    }
}

object DiscoverVipsOperations {

    private val girPath = Path.of("/opt/homebrew/share/gir-1.0/Vips-8.0.gir")

    fun run(arena: Arena): DiscoveredOperations {
        VipsRaw.vips_init(arena.allocateFrom("vips-ffm"))

        val gir = discoverGIR()
        val girMethods = gir.operations
        val girEnums = gir.enums

        val baseObjectGtype = VipsRaw.g_type_from_name(arena.allocateFrom("VipsObject"))
        val paramEnumGType = discoverParamEnumGType()

        val candidateOperations = mutableListOf<VipsOperation>()
        lateinit var callbackPointer: MemorySegment

        // recursively walk the tree of types starting from VipsObject
        val recursiveCallback = VipsTypeMap2Fn.Function { type, _, _ ->
            val subtypeNickname = VipsRaw.vips_nickname_find(type).getString(0)

            runCatching {
                val operation = VipsRaw.vips_operation_new(arena.allocateFrom(subtypeNickname))
                if (operation.address() == 0L || operation == MemorySegment.NULL) {
                    logger.info("skipping $subtypeNickname, couldn't make operation")
                    VipsRaw.vips_type_map(type, callbackPointer, MemorySegment.NULL, MemorySegment.NULL)
                    return@Function MemorySegment.NULL
                }
                val description = VipsRaw.vips_object_get_description(operation).getString(0)
                val flags = VipsRaw.vips_operation_get_flags(operation)

                val isDeprecated = flags and VipsRaw.VIPS_OPERATION_DEPRECATED() == VipsRaw.VIPS_OPERATION_DEPRECATED()

                logger.info("found $subtypeNickname:")
                logger.info(" description: $description")

                // not bothered about memory leaks during generation
                val namesPointer = arena.allocate(C_POINTER)
                val flagsPointer = arena.allocate(C_POINTER)
                val numArgsPointer = arena.allocate(C_POINTER)
                VipsRaw.vips_object_get_args(operation, namesPointer, flagsPointer, numArgsPointer)
                val namesArray = namesPointer.get(C_POINTER, 0)
                val flagsArray = flagsPointer.get(C_POINTER, 0)
                val numArgs = numArgsPointer.get(C_INT, 0).toLong()
                val args = (0..<numArgs).map { index ->
                    val namePointer = namesArray.get(C_POINTER, index * C_POINTER.byteSize())
                    val name = namePointer.getString(0)
                    val flags = flagsArray.get(C_INT, index * C_INT.byteSize())

                    val pspecPointer = arena.allocate(C_POINTER)
                    val argumentClassPointer = arena.allocate(C_POINTER)
                    val argumentInstancePointer = arena.allocate(C_POINTER)
                    val result = VipsRaw.vips_object_get_argument(operation, arena.allocateFrom(name), pspecPointer, argumentClassPointer, argumentInstancePointer)
                    if (result != 0) {
                        throw RuntimeException("failed to get object argument")
                    }
                    val pspec = GParamSpec.reinterpret(pspecPointer.get(C_POINTER, 0), arena, {})
                    val blurb = VipsRaw.g_param_spec_get_blurb(pspec).getString(0)
                    val type = GParamSpec.value_type(pspec)
                    val typeName = VipsRaw.g_type_name(type).getString(0)

                    VipsOperationArgument(
                        name,
                        flags,
                        blurb,
                        typeName.toGValueType(),
                        isRequired = flags and VIPS_ARGUMENT_REQUIRED() == VIPS_ARGUMENT_REQUIRED(),
                        isInput = flags and VIPS_ARGUMENT_INPUT() == VIPS_ARGUMENT_INPUT(),
                        isOutput = flags and VIPS_ARGUMENT_OUTPUT() == VIPS_ARGUMENT_OUTPUT(),
                        isDeprecated = flags and VIPS_ARGUMENT_DEPRECATED() == VIPS_ARGUMENT_DEPRECATED(),
                        isModify = flags and VIPS_ARGUMENT_MODIFY() == VIPS_ARGUMENT_MODIFY(),
                        isEnum = isParamSpecAnEnum(pspec, paramEnumGType)
                    )
                }

                if (!candidateOperations.any { it.nickname == subtypeNickname }) {
                    val girMethod = girMethods.firstOrNull { it.cIdentifier == "vips_$subtypeNickname"}
                    if (girMethod == null) {
                        logger.warn("failed to find GIR information for method: $subtypeNickname")
                    }
                    candidateOperations += VipsOperation(subtypeNickname, description, args, isDeprecated, girMethod)
                }
            }.getOrElse {
                logger.info("skipping $subtypeNickname, couldn't introspect", it)
            }

            VipsRaw.vips_type_map(type, callbackPointer, MemorySegment.NULL, MemorySegment.NULL)
            MemorySegment.NULL
        }

        callbackPointer = VipsTypeMap2Fn.allocate(recursiveCallback, arena)
        VipsRaw.vips_type_map(baseObjectGtype, callbackPointer, MemorySegment.NULL, MemorySegment.NULL)

        return DiscoveredOperations(
            operations = candidateOperations.sortedBy { it.nickname },
            enums = gir.enums.map { VipsEnum(it) }
        )
    }

    data class GIRRepository(
        @JacksonXmlProperty(localName = "namespace")
        @JacksonXmlElementWrapper(useWrapping = false)
        val namespaces: List<GIRNamespace>
    ) {
        class GIRNamespace {
            @JacksonXmlProperty(isAttribute = true)
            var name: String = ""
                set(value) {
                    field += value
                }

            @JacksonXmlProperty(localName = "class")
            @JacksonXmlElementWrapper(useWrapping = false)
            var classes: List<GIRClass> = listOf()
                set(value) {
                    field += value
                }

            @JacksonXmlProperty(localName = "function")
            @JacksonXmlElementWrapper(useWrapping = false)
            var functions: List<GIRMethod> = listOf()
                set(value) {
                    field += value
                }

            @JacksonXmlProperty(localName = "enumeration")
            @JacksonXmlElementWrapper(useWrapping = false)
            var enumerations: List<GIREnumeration> = listOf()
                set(value) {
                    field += value
                }
        }

        class GIRClass {
            @JacksonXmlProperty(isAttribute = true)
            var name: String = ""

            @JacksonXmlProperty(localName = "constructor")
            @JacksonXmlElementWrapper(useWrapping = false)
            var constructors: List<GIRMethod> = listOf()
                set(value) {
                    field += value
                }

            @JacksonXmlProperty(localName = "method")
            @JacksonXmlElementWrapper(useWrapping = false)
            var methods: List<GIRMethod> = listOf()
                set(value) {
                    field += value
                }
        }

        data class GIRMethod(
            @JacksonXmlProperty(isAttribute = true)
            val name: String,
            @JacksonXmlProperty(isAttribute = true, namespace = "c", localName = "identifier")
            val cIdentifier: String?,
            val doc: String?,

            @JacksonXmlElementWrapper(useWrapping = true)
            val parameters: List<GIRParameter>?,

            val returnValue: GIRParameter?
        )

        data class GIRParameter(
            @JacksonXmlProperty(isAttribute = true)
            val name: String,
            @JacksonXmlProperty(isAttribute = true, localName = "transfer-ownership")
            val transferOwnership: String?,
            @JacksonXmlProperty(isAttribute = true)
            val direction: String?,
            val type: GIRType?,
            val varargs: Unit?
        )

        data class GIRType(
            @JacksonXmlProperty(isAttribute = true)
            val name: String
        )

        class GIREnumeration {
            @JacksonXmlProperty(isAttribute = true)
            val name: String = ""

            @JacksonXmlProperty(isAttribute = true, namespace = "c", localName = "type")
            val cType: String? = null
            val doc: String? = null

            @JacksonXmlProperty(localName = "member")
            @JacksonXmlElementWrapper(useWrapping = false)
            var members: List<GIREnumerationMember> = listOf()
                set(value) {
                    field += value
                }
        }

        data class GIREnumerationMember(
            @JacksonXmlProperty(isAttribute = true)
            val name: String,
            @JacksonXmlProperty(isAttribute = true, namespace = "c", localName = "identifier")
            val cIdentifier: String?,
            val doc: String?,
        )
    }
    data class DiscoveredGIRInfo(
        val operations: List<GIRRepository.GIRMethod>,
        val enums: List<GIRRepository.GIREnumeration>
    )
    private fun discoverGIR(): DiscoveredGIRInfo {
        Files.newInputStream(girPath).use { xmlInputStream ->
            val xmlMapper = XmlMapper.builder()
                .defaultUseWrapper(false)
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .build()
                .registerKotlinModule()

            val xml = xmlMapper.readValue(xmlInputStream, GIRRepository::class.java)
            val vipsNamespaceXml = xml.namespaces.first { it.name == "Vips" }
            val classMethods = vipsNamespaceXml.classes.map { it.methods }.flatten()
            val functions = vipsNamespaceXml.functions
            val allMethods = classMethods + functions
            val enums = vipsNamespaceXml.enumerations

            logger.info("found ${allMethods.size} methods, ${enums.size} in GIR")
            return DiscoveredGIRInfo(allMethods, enums)
        }
    }

    private fun discoverParamEnumGType(): Long {
        val paramSpecArrayPointer = VipsRaw.g_param_spec_types()
        for (i in 0L..16L) {
            val gtype = paramSpecArrayPointer.get(C_LONG, i * C_LONG.byteSize())
            val name = VipsRaw.g_type_name(gtype).getString(0)
            if (name == "GParamEnum") {
                return gtype
            }
        }
        throw RuntimeException("failed to find GParamEnum type - is glib loaded?")
    }

    private fun isParamSpecAnEnum(paramSpec: MemorySegment, paramSpecEnumGType: Long): Boolean {
        val gclass = GTypeInstance.g_class(paramSpec)
        val gtype = GTypeClass.g_type(gclass)
        if (gtype == paramSpecEnumGType) {
            return true
        }
        return VipsRaw.g_type_check_instance_is_a(paramSpec, paramSpecEnumGType) == 1
    }
}