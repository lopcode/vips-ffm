package vipsffm

import app.photofox.vipsffm.generated.VipsImage
import app.photofox.vipsffm.generated.VipsRaw
import app.photofox.vipsffm.generated.VipsRaw_1
import vipsffm.RawGetVersionSample.logger
import vipsffm.VipsHelper.validate
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment
import java.lang.foreign.ValueLayout
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.absolutePathString

object RawCreateThumbnailSample: RunnableSample {

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        VipsHelper.runCatching {
            VipsRaw.vips_init(arena.allocateFrom("vips-ffm"))
        }.getOrElse {
            return Result.failure(it)
        }

        val sourcePath = Paths.get("sample/src/main/resources/sample_images/rabbit.jpg")
        val sourcePathC = arena.allocateFrom(sourcePath.absolutePathString())
        if (!Files.exists(sourcePath)) {
            return Result.failure(
                RuntimeException("source image doesn't exist")
            )
        }

        val newImageFromFileInvoker = VipsRaw_1.vips_image_new_from_file.makeInvoker(VipsRaw.C_POINTER)
        val sourceImage = newImageFromFileInvoker.apply(
            arena.allocateFrom(sourcePath.absolutePathString()),
            MemorySegment.NULL
        ).let {
            VipsImage.reinterpret(it, arena, VipsRaw::g_object_unref)
        }
        if (sourceImage == MemorySegment.NULL) {
            val error = VipsRaw.vips_error_buffer().getString(0)
            logger.error("failed to load image at $sourcePath, error: {}", error)
            return Result.failure(
                RuntimeException("failed to load image")
            )
        }
        val sourceWidth = VipsImage.Xsize(sourceImage)
        val sourceHeight = VipsImage.Ysize(sourceImage)
        logger.info("source image size: $sourceWidth x $sourceHeight")

        val writeSameInvoker = VipsRaw_1.vips_image_write_to_file.makeInvoker(VipsRaw.C_POINTER)
        val samePath = workingDirectory.resolve("rabbit_copy.jpg")
        val sameResult = writeSameInvoker.apply(
            sourceImage, arena.allocateFrom(samePath.absolutePathString()),
            MemorySegment.NULL
        )
        if (sameResult != 0) {
            val error = VipsRaw.vips_error_buffer().getString(0)
            logger.error("failed to copy image, error: {}", error)
            return Result.failure(
                RuntimeException("failed to copy image, code $sameResult")
            )
        }

        // VipsImage**
        val outputImagePointer = arena.allocate(ValueLayout.ADDRESS)

        val thumbnailInvoker = VipsRaw.vips_thumbnail.makeInvoker(VipsRaw.C_POINTER)
        val makeThumbnailResult = thumbnailInvoker.apply(sourcePathC, outputImagePointer, 400, MemorySegment.NULL)
        if (makeThumbnailResult != 0) {
            val error = VipsRaw.vips_error_buffer().getString(0)
            logger.error("failed to make thumbnail, error: {}", error)
            return Result.failure(
                RuntimeException("failed to make thumbnail, code $makeThumbnailResult")
            )
        }

        val resultingOutputImagePointer = outputImagePointer.get(VipsRaw.C_POINTER, 0)
        val resultingOutputImage = VipsImage.reinterpret(resultingOutputImagePointer, arena, VipsRaw::g_object_unref)

        val outputWidth = VipsImage.Xsize(resultingOutputImage)
        val outputHeight = VipsImage.Ysize(resultingOutputImage)
        logger.info("output image size: $outputWidth x $outputHeight")

        val thumbnailPath = workingDirectory.resolve("rabbit_thumbnail_400.jpg")
        val thumbnailPathC = arena.allocateFrom(thumbnailPath.absolutePathString())
        val writeToFileInvoker = VipsRaw_1.vips_image_write_to_file.makeInvoker(VipsRaw.C_POINTER)
        val writeToFileResult = writeToFileInvoker.apply(resultingOutputImage, thumbnailPathC, MemorySegment.NULL)
        if (writeToFileResult != 0) {
            val error = VipsRaw.vips_error_buffer().getString(0)
            logger.error("failed to write thumbnail, error: {}", error)
            return Result.failure(
                RuntimeException("failed to write thumbnail, code $writeToFileResult")
            )
        }

        return validate(
            thumbnailPath,
            expectedSizeBoundsKb = 20L..100L
        )
    }
}