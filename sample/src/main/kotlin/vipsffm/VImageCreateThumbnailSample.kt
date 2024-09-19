package vipsffm

import app.photofox.vipsffm.VImage
import app.photofox.vipsffm.VipsOption
import app.photofox.vipsffm.enums.VipsAccess
import vipsffm.RawGetVersionSample.logger
import java.lang.foreign.Arena
import java.nio.file.Path
import kotlin.io.path.absolutePathString

object VImageCreateThumbnailSample: RunnableSample {

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val sourceImage = VImage.newFromFile(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg",
            VipsOption.Enum("access", VipsAccess.ACCESS_SEQUENTIAL)
        )
        val sourceWidth = sourceImage.width
        val sourceHeight = sourceImage.height
        logger.info("source image size: $sourceWidth x $sourceHeight")

        val outputPath = workingDirectory.resolve("rabbit_copy.jpg")
        sourceImage.writeToFile(outputPath.absolutePathString())

        val thumbnail = sourceImage.thumbnail(
            "sample/src/main/resources/sample_images/rabbit.jpg",
            400
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