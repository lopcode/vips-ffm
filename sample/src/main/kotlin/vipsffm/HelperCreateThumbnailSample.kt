package vipsffm

import app.photofox.vipsffm.generated.VipsImage
import app.photofox.vipsffm.generated.VipsRaw
import app.photofox.vipsffm.helper.Vips
import app.photofox.vipsffm.helper.VipsIntOption
import vipsffm.GetVersionSample.logger
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

        val thumbnailImage = vips.thumbnail("sample/src/main/resources/sample_images/rabbit.jpg", 400)
        val thumbnailPath = workingDirectory.resolve("rabbit_thumbnail_400.jpg")
        vips.imageWriteToFile(thumbnailImage, thumbnailPath.absolutePathString())

        val thumbnailWidth = VipsImage.Xsize(thumbnailImage)
        val thumbnailHeight = VipsImage.Ysize(thumbnailImage)
        logger.info("thumbnail image size: $thumbnailWidth x $thumbnailHeight")

        return VipsHelper.validate(
            thumbnailPath,
            expectedSizeBoundsKb = 20L..100L
        )
    }
}