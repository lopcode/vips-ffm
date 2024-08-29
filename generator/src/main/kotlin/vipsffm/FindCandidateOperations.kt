package vipsffm

import app.photofox.vipsffm.generated.Vips
import app.photofox.vipsffm.generated.VipsRaw
import app.photofox.vipsffm.generated.VipsRaw_1
import app.photofox.vipsffm.generated.VipsRaw_1.C_INT
import app.photofox.vipsffm.generated.VipsRaw_1.C_POINTER
import app.photofox.vipsffm.generated.VipsRaw_1.VIPS_ARGUMENT_INPUT
import app.photofox.vipsffm.generated.VipsRaw_1.VIPS_ARGUMENT_OUTPUT
import app.photofox.vipsffm.generated.VipsRaw_1.VIPS_ARGUMENT_REQUIRED
import app.photofox.vipsffm.generated.VipsTypeMap2Fn
import app.photofox.vipsffm.helper.VipsError
import app.photofox.vipsffm.helper.VipsValidation
import org.slf4j.LoggerFactory
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment

data class CandidateOperation(
    val nickname: String,
    val description: String,
    val args: List<CandidateArgument>
)

data class CandidateArgument(
    val name: String,
    val flags: Int,
    val isRequired: Boolean,
    val isInput: Boolean,
    val isOutput: Boolean
)

private val logger = LoggerFactory.getLogger(FindCandidateOperations::class.java)

fun main() {
    val operations = Arena.ofConfined().use {
        FindCandidateOperations.run(it)
    }

    logger.info("found ${operations.size} operations:")
    operations.forEach {
        logger.info("  $it")
    }
}

object FindCandidateOperations {

    fun run(arena: Arena): List<CandidateOperation> {
        val vips = Vips(arena)

        val baseObjectGtype = VipsRaw_1.g_type_from_name(arena.allocateFrom("VipsObject"))

        val candidateOperations = mutableListOf<CandidateOperation>()
        lateinit var callbackPointer: MemorySegment
        val recursiveCallback = VipsTypeMap2Fn.Function { type, _, _ ->
            val subtypeNickname = vips.nicknameFind(type)

            runCatching {
                val operation = VipsRaw_1.vips_operation_new(arena.allocateFrom(subtypeNickname))
                if (!VipsValidation.isValidPointer(operation)) {
                    throw VipsError("not a valid operation: $subtypeNickname")
                }
                val description = VipsRaw_1.vips_object_get_description(operation).getString(0)
                val flags = VipsRaw_1.vips_operation_get_flags(operation)

                val isDeprecated = flags and VipsRaw.VIPS_OPERATION_DEPRECATED() == VipsRaw.VIPS_OPERATION_DEPRECATED()
                if (isDeprecated) {
                    logger.info("skipping $subtypeNickname, deprecated")
                } else {
                    logger.info("found $subtypeNickname:")
                    logger.info(" description: $description")

                    // not bothered about memory leaks during generation
                    val namesPointer = arena.allocate(C_POINTER)
                    val flagsPointer = arena.allocate(C_POINTER)
                    val numArgsPointer = arena.allocate(C_POINTER)
                    VipsRaw_1.vips_object_get_args(operation, namesPointer, flagsPointer, numArgsPointer)
                    val namesArray = namesPointer.get(C_POINTER, 0)
                    val flagsArray = flagsPointer.get(C_POINTER, 0)
                    val numArgs = numArgsPointer.get(C_INT, 0).toLong()
                    val args = (0..<numArgs).map { index ->
                        val namePointer = namesArray.get(C_POINTER, index * C_POINTER.byteSize())
                        val name = namePointer.getString(0)
                        val flags = flagsArray.get(C_INT, index * C_INT.byteSize())

                        // todo: get argument type/blurb

                        CandidateArgument(
                            name,
                            flags,
                            isRequired = flags and VIPS_ARGUMENT_REQUIRED() == VIPS_ARGUMENT_REQUIRED(),
                            isInput = flags and VIPS_ARGUMENT_INPUT() == VIPS_ARGUMENT_INPUT(),
                            isOutput = flags and VIPS_ARGUMENT_OUTPUT() == VIPS_ARGUMENT_OUTPUT(),
                        )
                    }

                    if (!candidateOperations.any { it.nickname == subtypeNickname }) {
                        candidateOperations += CandidateOperation(subtypeNickname, description, args)
                    }
                }
            }.getOrElse {
                logger.info("skipping $subtypeNickname, couldn't introspect", it)
            }

            VipsRaw_1.vips_type_map(type, callbackPointer, MemorySegment.NULL, MemorySegment.NULL)
            MemorySegment.NULL
        }

        callbackPointer = VipsTypeMap2Fn.allocate(recursiveCallback, arena)
        VipsRaw_1.vips_type_map(baseObjectGtype, callbackPointer, MemorySegment.NULL, MemorySegment.NULL)

        return candidateOperations.sortedBy { it.nickname }
    }
}