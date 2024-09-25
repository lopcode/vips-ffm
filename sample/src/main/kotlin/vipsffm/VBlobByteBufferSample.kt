package vipsffm

import app.photofox.vipsffm.VImage
import java.lang.foreign.Arena
import java.lang.foreign.ValueLayout
import java.nio.file.Path
import kotlin.io.path.absolutePathString

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
        val bytes = blob.asByteBuffer()
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

        return Result.success(Unit)
    }
}