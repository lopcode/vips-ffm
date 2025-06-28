package vipsffm.sample

import app.photofox.vipsffm.VImage
import app.photofox.vipsffm.VTarget
import app.photofox.vipsffm.VipsHelper
import app.photofox.vipsffm.jextract.VipsRaw
import vipsffm.RunnableSample
import vipsffm.SampleHelper
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment
import java.lang.foreign.ValueLayout
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.absolutePathString

/**
 * Sample showing loading an image directly from a bag of bytes, bypassing libvips' source loaders
 * Please read the docs on [VImage#newFromMemory] before using this, and use the higher level methods if possible
 */
object VImageFromMemorySample: RunnableSample {

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val path = Path.of("sample/src/main/resources/sample_images/rabbit.jpg")
        val image = VImage.newFromFile(arena, path.absolutePathString())
            .thumbnailImage(400)

        val bands = VipsHelper.image_get_bands(image.unsafeStructAddress)
        val width = image.width
        val height = image.height
        val format = VipsHelper.image_get_format(image.unsafeStructAddress)
        val bytesPointer = VipsRaw.vips_image_get_data(image.unsafeStructAddress)
        val expectedSize = height * width * bands.toLong()
        val bytes = bytesPointer.asSlice(0, expectedSize).toArray(ValueLayout.JAVA_BYTE)

        val outputPath = workingDirectory.resolve("rabbit_copy.jpg")
        VImage.newFromMemory(
            arena,
            bytes,
            width,
            height,
            bands,
            format
        )
        .writeToFile(outputPath.absolutePathString())

        return SampleHelper.validate(
            outputPath,
            expectedSizeBoundsKb = 20..100L
        )
    }
}