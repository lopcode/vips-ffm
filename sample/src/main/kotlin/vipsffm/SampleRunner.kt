package vipsffm

import app.photofox.vipsffm.generated.Vips
import app.photofox.vipsffm.generated.VipsRaw
import org.slf4j.LoggerFactory
import java.lang.foreign.Arena
import java.nio.file.Files
import java.nio.file.Paths
import java.util.Locale
import kotlin.system.exitProcess

object SampleRunner {

    private val logger = LoggerFactory.getLogger(SampleRunner::class.java)

    @JvmStatic
    fun main(args: Array<String>) {
        val samples = listOf(
            RawGetVersionSample,
            HelperGetVersionSample,
            RawCreateThumbnailSample,
            HelperCreateThumbnailSample
        )
        val sampleParentRunPath = Paths.get("sample_run")
        if (Files.exists(sampleParentRunPath)) {
            logger.info("clearing sample run directory at path \"$sampleParentRunPath\"")
            sampleParentRunPath.toFile().deleteRecursively()
        }
        Files.deleteIfExists(sampleParentRunPath)
        Files.createDirectory(sampleParentRunPath)

        Arena.ofConfined().use { arena ->
            val vips = Vips(arena)
            vips.leakSet(true)

            samples.forEach { sample ->
                val sampleName = sample::class.simpleName!!
                logger.info("running sample \"$sampleName\"...")
                val sampleDirectoryName = makeSampleDirectoryName(sampleName)
                val sampleRunPath = sampleParentRunPath.resolve(sampleDirectoryName)
                Files.createDirectory(sampleRunPath)

                val result = sample.run(arena, sampleRunPath)
                if (result.isFailure) {
                    logger.error("validation failed ❌", result.exceptionOrNull())
                    exitProcess(1)
                }
                logger.info("validation succeeded ✅")
            }
        }
        logger.info("shutting down vips to check for memory leaks...")
        VipsRaw.vips_shutdown()
        logger.info("all samples ran successfully 🎉")
        exitProcess(0)
    }

    private fun makeSampleDirectoryName(original: String): String {
        return original
            .replace(oldValue = " ", "_")
            .lowercase(Locale.ENGLISH)
    }
}
