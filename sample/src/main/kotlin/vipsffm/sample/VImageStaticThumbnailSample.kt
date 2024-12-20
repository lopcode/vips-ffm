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
 * Sense checking basic static VImage thumbnail operations
 */
object VImageStaticThumbnailSample: RunnableSample {

    val logger = LoggerFactory.getLogger(VImageStaticThumbnailSample::class.java)

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val thumbnail = VImage.thumbnail(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg",
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