package vipsffm.sample

import app.photofox.vipsffm.VImage
import app.photofox.vipsffm.VipsOption
import app.photofox.vipsffm.enums.VipsAccess
import org.slf4j.LoggerFactory
import vipsffm.RunnableSample
import vipsffm.SampleHelper
import java.lang.foreign.Arena
import java.nio.file.Path
import kotlin.io.path.absolutePathString

/**
 * Sense checking basic VImage thumbnail operations
 */
object VImageCreateThumbnailSample: RunnableSample {

    val logger = LoggerFactory.getLogger(VImageCreateThumbnailSample::class.java)

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val sourceImage = VImage.newFromFile(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg"
        )
        val sourceWidth = sourceImage.width
        val sourceHeight = sourceImage.height
        logger.info("source image size: $sourceWidth x $sourceHeight")

        val outputPath = workingDirectory.resolve("rabbit_copy.jpg")
        sourceImage.writeToFile(outputPath.absolutePathString())

        val thumbnail = sourceImage.thumbnailImage(
            400,
            VipsOption.Boolean("auto-rotate", true) // example of an option
        )
        val thumbnailWidth = thumbnail.width
        val thumbnailHeight = thumbnail.height
        logger.info("thumbnail image size: $thumbnailWidth x $thumbnailHeight")

        val thumbnailPath = workingDirectory.resolve("rabbit_thumbnail_400.jpg")
        thumbnail.writeToFile(thumbnailPath.absolutePathString())

        val hasAlpha = thumbnail.hasAlpha()
        if (hasAlpha) {
            return Result.failure(
                RuntimeException("unexpected alpha in image")
            )
        }

        return SampleHelper.validate(
            thumbnailPath,
            expectedSizeBoundsKb = 20L..100L
        )
    }
}