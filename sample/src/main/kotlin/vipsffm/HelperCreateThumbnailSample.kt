package vipsffm

import app.photofox.vipsffm.generated.Vips
import app.photofox.vipsffm.generated.VipsImage
import app.photofox.vipsffm.generated.VipsRaw
import app.photofox.vipsffm.helper.VipsIntOption
import app.photofox.vipsffm.helper.VipsOutputPointer
import vipsffm.RawGetVersionSample.logger
import java.lang.foreign.Arena
import java.nio.file.Path
import kotlin.io.path.absolutePathString

object HelperCreateThumbnailSample: RunnableSample {

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val vips = Vips(arena)

        val sourceImage = vips.imageNewFromFile(
            "sample/src/main/resources/sample_images/rabbit.jpg",
            VipsIntOption("access", VipsRaw.VIPS_ACCESS_SEQUENTIAL())
        )
        val sourceWidth = VipsImage.Xsize(sourceImage)
        val sourceHeight = VipsImage.Ysize(sourceImage)
        logger.info("source image size: $sourceWidth x $sourceHeight")

        val outputPath = workingDirectory.resolve("rabbit_copy.jpg")
        vips.imageWriteToFile(sourceImage, outputPath.absolutePathString())

        val outputImagePointer = VipsOutputPointer(arena)
        vips.thumbnail(
            "sample/src/main/resources/sample_images/rabbit.jpg",
            outputImagePointer,
            400
        )
        val thumbnailImage = outputImagePointer.dereferencedOrThrow()

        val thumbnailPath = workingDirectory.resolve("rabbit_thumbnail_400.jpg")
        vips.imageWriteToFile(thumbnailImage, thumbnailPath.absolutePathString())

        val thumbnailWidth = VipsImage.Xsize(thumbnailImage)
        val thumbnailHeight = VipsImage.Ysize(thumbnailImage)
        logger.info("thumbnail image size: $thumbnailWidth x $thumbnailHeight")

        val hasAlpha = vips.imageHasalpha(thumbnailImage)
        if (hasAlpha) {
            return Result.failure(
                RuntimeException("unexpected alpha in image")
            )
        }

        return VipsHelper.validate(
            thumbnailPath,
            expectedSizeBoundsKb = 20L..100L
        )
    }
}