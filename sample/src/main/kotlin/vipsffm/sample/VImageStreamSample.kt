package vipsffm.sample

import app.photofox.vipsffm.VImage
import vipsffm.RunnableSample
import vipsffm.SampleHelper
import java.lang.foreign.Arena
import java.nio.file.Files
import java.nio.file.Path

/**
 * Sample showing loading an image from a stream, and outputting it to a stream
 * See https://www.libvips.org/2019/11/29/True-streaming-for-libvips.html
 */
object VImageStreamSample: RunnableSample {

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val outputPath = workingDirectory.resolve("fox_copy.jpg")
        val inputStream = ClassLoader.getSystemResourceAsStream("sample_images/fox.jpg")
        val image = VImage.newFromStream(arena, inputStream)

        val outputStream = Files.newOutputStream(outputPath)
        image.thumbnailImage(800)
            .writeToStream(outputStream, ".jpg")

        return SampleHelper.validate(
            outputPath,
            expectedSizeBoundsKb = 20..100L
        )
    }
}