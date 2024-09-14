package vipsffm

import app.photofox.vipsffm.jextract.GParamSpec
import app.photofox.vipsffm.jextract.VipsRaw
import app.photofox.vipsffm.jextract.VipsRaw.C_INT
import app.photofox.vipsffm.jextract.VipsRaw.C_POINTER
import app.photofox.vipsffm.jextract.VipsRaw.VIPS_ARGUMENT_DEPRECATED
import app.photofox.vipsffm.jextract.VipsRaw.VIPS_ARGUMENT_INPUT
import app.photofox.vipsffm.jextract.VipsRaw.VIPS_ARGUMENT_MODIFY
import app.photofox.vipsffm.jextract.VipsRaw.VIPS_ARGUMENT_OUTPUT
import app.photofox.vipsffm.jextract.VipsRaw.VIPS_ARGUMENT_REQUIRED
import app.photofox.vipsffm.jextract.VipsTypeMap2Fn
import org.slf4j.LoggerFactory
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment

data class VipsOperation(
    val nickname: String,
    val description: String,
    val args: List<VipsOperationArgument>
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
    val isModify: Boolean
)

private val logger = LoggerFactory.getLogger(DiscoverVipsOperations::class.java)

fun main() {
    val operations = Arena.ofConfined().use {
        DiscoverVipsOperations.run(it)
    }

    logger.info("found ${operations.size} operations:")
    operations.forEach {
        logger.info("  $it")
    }
}

object DiscoverVipsOperations {

    fun run(arena: Arena): List<VipsOperation> {
        VipsRaw.vips_init(arena.allocateFrom("vips-ffm"))

        val baseObjectGtype = VipsRaw.g_type_from_name(arena.allocateFrom("VipsObject"))

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
                if (isDeprecated) {
                    logger.info("skipping $subtypeNickname, deprecated")
                    VipsRaw.vips_type_map(type, callbackPointer, MemorySegment.NULL, MemorySegment.NULL)
                    return@Function MemorySegment.NULL
                }

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
                        isModify = flags and VIPS_ARGUMENT_MODIFY() == VIPS_ARGUMENT_MODIFY()
                    )
                }

                if (!candidateOperations.any { it.nickname == subtypeNickname }) {
                    candidateOperations += VipsOperation(subtypeNickname, description, args)
                }
            }.getOrElse {
                logger.info("skipping $subtypeNickname, couldn't introspect", it)
            }

            VipsRaw.vips_type_map(type, callbackPointer, MemorySegment.NULL, MemorySegment.NULL)
            MemorySegment.NULL
        }

        callbackPointer = VipsTypeMap2Fn.allocate(recursiveCallback, arena)
        VipsRaw.vips_type_map(baseObjectGtype, callbackPointer, MemorySegment.NULL, MemorySegment.NULL)

        return candidateOperations.sortedBy { it.nickname }
    }
}