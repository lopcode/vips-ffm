package vipsffm

import app.photofox.vipsffm.VImage
import java.io.FileOutputStream
import java.lang.foreign.Arena
import java.nio.file.Path

object VBlobByteBufferSample: RunnableSample {

    // https://github.com/lopcode/vips-ffm/issues/72
    // provide a way to get bytes out of a VBlob without raw pointers
    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val image = VImage.newFromFile(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg"
        )
            .thumbnailImage(400)

        val blob = image.jpegsaveBuffer()
        val bytes = blob.asClonedByteBuffer()
        val rawDataSegment = blob.unsafeDataAddress
        val rawByteSize = blob.byteSize().toInt()

        val remainingBytes = bytes.remaining()
        if (remainingBytes < 50000L || remainingBytes > 100000L) {
            return Result.failure(
                RuntimeException("number of bytes in buffer out of range $remainingBytes")
            )
        }

        if (remainingBytes != rawByteSize || remainingBytes != rawDataSegment.byteSize().toInt()) {
            return Result.failure(
                RuntimeException("unexpected difference in raw byte size vs bytebuffer remaining $rawByteSize $remainingBytes ${rawDataSegment.byteSize()}")
            )
        }

        val outputPath = workingDirectory.resolve("rabbit_copy.jpg")
        val outputChannel = FileOutputStream(outputPath.toFile()).channel
        outputChannel.write(bytes)
        outputChannel.close()

        return SampleHelper.validate(
            outputPath,
            expectedSizeBoundsKb = 20L..100L
        )
    }
}