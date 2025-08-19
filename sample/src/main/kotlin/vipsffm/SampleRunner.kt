package vipsffm

import app.photofox.vipsffm.Vips
import org.slf4j.LoggerFactory
import vipsffm.sample.HelperGetVersionSample
import vipsffm.sample.HelperGetSetMetadataSample
import vipsffm.sample.RawGetVersionSample
import vipsffm.sample.VBlobByteBufferSample
import vipsffm.sample.VImageStreamSample
import vipsffm.sample.VImageArrayJoinSample
import vipsffm.sample.VImageBlobSample
import vipsffm.sample.VImageCachingSample
import vipsffm.sample.VImageChainSample
import vipsffm.sample.VImageCopyWriteSample
import vipsffm.sample.VImageCreateThumbnailSample
import vipsffm.sample.VImageCustomSourceTargetSample
import vipsffm.sample.VImageFindTrimSample
import vipsffm.sample.VImageFromBytesSample
import vipsffm.sample.VImageGetPagesSample
import vipsffm.sample.VImageGetSetSample
import vipsffm.sample.VImageJoinSample
import vipsffm.sample.VImageFromMemoryToMemorySample
import vipsffm.sample.VImageStaticThumbnailSample
import vipsffm.sample.VOptionHyphenSample
import vipsffm.sample.VSourceTargetSample
import vipsffm.sample.VTargetToFileSample
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
            VImageCreateThumbnailSample,
            VImageChainSample,
            VSourceTargetSample,
            VImageCopyWriteSample,
            VOptionHyphenSample,
            VImageCachingSample,
            VImageBlobSample,
            VImageArrayJoinSample,
            VBlobByteBufferSample,
            VTargetToFileSample,
            VImageJoinSample,
            VImageFromBytesSample,
            VImageStreamSample,
            VImageStaticThumbnailSample,
            VImageGetPagesSample,
            HelperGetSetMetadataSample,
            VImageGetSetSample,
            VImageFindTrimSample,
            VImageFromMemoryToMemorySample,
            VImageCustomSourceTargetSample
        )
        val sampleParentRunPath = Paths.get("sample_run")
        if (Files.exists(sampleParentRunPath)) {
            logger.info("clearing sample run directory at path \"$sampleParentRunPath\"")
            sampleParentRunPath.toFile().deleteRecursively()
        }
        Files.deleteIfExists(sampleParentRunPath)
        Files.createDirectory(sampleParentRunPath)

        Vips.init(false, true)
        samples.forEach { sample ->
            Vips.run { arena ->
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
        Vips.shutdown()
        logger.info("all samples ran successfully 🎉")
        exitProcess(0)
    }

    private fun makeSampleDirectoryName(original: String): String {
        return original
            .replace(oldValue = " ", "_")
            .lowercase(Locale.ENGLISH)
    }
}
