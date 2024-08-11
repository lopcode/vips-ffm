package imffm

import org.slf4j.LoggerFactory
import java.lang.foreign.Arena
import java.nio.file.Files
import java.nio.file.Paths
import java.util.Locale
import kotlin.system.exitProcess

object ImFfm {

    val logger = LoggerFactory.getLogger(ImFfm::class.java)

    @JvmStatic
    fun main(args: Array<String>) {
        val samples = listOf(
            ResizeImageSample
        )
        val sampleParentRunPath = Paths.get("sample_run")
        if (Files.exists(sampleParentRunPath)) {
            logger.info("clearing sample run directory at path \"$sampleParentRunPath\"")
            sampleParentRunPath.toFile().deleteRecursively()
        }
        Files.deleteIfExists(sampleParentRunPath)
        Files.createDirectory(sampleParentRunPath)

        Arena.ofConfined().use { arena ->
            samples.forEach { sample ->
                logger.info("running sample \"${sample.name}\"...")
                val sampleDirectoryName = makeSampleDirectoryName(sample.name)
                val sampleRunPath = sampleParentRunPath.resolve(sampleDirectoryName)
                Files.createDirectory(sampleRunPath)

                sample.run(arena, sampleRunPath)
                val validationResult = sample.validate(sampleRunPath)
                if (validationResult.isFailure) {
                    logger.error("validation failed ❌", validationResult.exceptionOrNull())
                    exitProcess(1)
                }
                logger.info("validation succeeded ✅")
            }
        }
        logger.info("all samples ran successfully 🎉")
        exitProcess(0)
    }

    private fun makeSampleDirectoryName(original: String): String {
        return original
            .replace(oldValue = " ", "_")
            .lowercase(Locale.ENGLISH)
    }
}
