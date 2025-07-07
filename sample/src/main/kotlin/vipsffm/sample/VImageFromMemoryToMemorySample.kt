package vipsffm.sample

import app.photofox.vipsffm.VImage
import app.photofox.vipsffm.VipsHelper
import vipsffm.RunnableSample
import vipsffm.SampleHelper
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment
import java.nio.file.Path
import kotlin.io.path.absolutePathString

/**
 * Sample showing loading an image directly from a bag of bytes, bypassing libvips' source loaders and
 * then writing it back to raw memory bytes again.
 * Please read the docs on [VImage#newFromMemory] and [VImage#writeToMemory] before using this,
 * and use the higher level methods if possible
 */
object VImageFromMemoryToMemorySample : RunnableSample {

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val path = Path.of("sample/src/main/resources/sample_images/rabbit.jpg")
        val image = VImage.newFromFile(arena, path.absolutePathString())
            .thumbnailImage(400)

        val bands = VipsHelper.image_get_bands(image.unsafeStructAddress)
        val width = image.width
        val height = image.height
        val format = VipsHelper.image_get_format(image.unsafeStructAddress)
        val memorySegment = image.writeToMemory()

        val outputPath = workingDirectory.resolve("rabbit_copy.jpg")
        val imageFromMemory = VImage.newFromMemory(
            arena,
            memorySegment,
            width,
            height,
            bands,
            format
        )
        imageFromMemory.writeToFile(outputPath.absolutePathString())

        return SampleHelper.validate(
            outputPath,
            expectedSizeBoundsKb = 20..100L
        )
    }
}