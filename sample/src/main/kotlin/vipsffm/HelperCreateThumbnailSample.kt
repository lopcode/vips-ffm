package vipsffm

import app.photofox.vipsffm.generated.Vips
import app.photofox.vipsffm.generated.VipsImage
import app.photofox.vipsffm.generated.VipsRaw
import app.photofox.vipsffm.helper.VipsIntOption
import vipsffm.GetVersionSample.logger
import java.lang.foreign.Arena
import java.lang.foreign.ValueLayout
import java.nio.file.Path
import kotlin.io.path.absolutePathString

object HelperCreateThumbnailSample: RunnableSample {

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val vips = Vips(arena)

        val sourceImage = vips.imageNewFromFile(
            arena.allocateFrom("sample/src/main/resources/sample_images/rabbit.jpg"),
            VipsIntOption("access", VipsRaw.VIPS_ACCESS_SEQUENTIAL())
        )
        val sourceWidth = VipsImage.Xsize(sourceImage)
        val sourceHeight = VipsImage.Ysize(sourceImage)
        logger.info("source image size: $sourceWidth x $sourceHeight")

        val outputPath = workingDirectory.resolve("rabbit_copy.jpg")
        vips.imageWriteToFile(sourceImage, arena.allocateFrom(outputPath.absolutePathString()))

        val out = arena.allocate(ValueLayout.ADDRESS)
        vips.thumbnail(
            arena.allocateFrom("sample/src/main/resources/sample_images/rabbit.jpg"),
            out,
            400
        )
        val resultingPointer = out.get(VipsRaw.C_POINTER, 0)
        val thumbnailImage = VipsImage.reinterpret(resultingPointer, arena, VipsRaw::g_object_unref)

        val thumbnailPath = workingDirectory.resolve("rabbit_thumbnail_400.jpg")
        vips.imageWriteToFile(thumbnailImage, arena.allocateFrom(thumbnailPath.absolutePathString()))

        val thumbnailWidth = VipsImage.Xsize(thumbnailImage)
        val thumbnailHeight = VipsImage.Ysize(thumbnailImage)
        logger.info("thumbnail image size: $thumbnailWidth x $thumbnailHeight")

        return VipsHelper.validate(
            thumbnailPath,
            expectedSizeBoundsKb = 20L..100L
        )
    }
}