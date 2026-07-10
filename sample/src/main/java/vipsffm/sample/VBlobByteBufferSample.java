package vipsffm.sample;

import app.photofox.vipsffm.VImage;
import vipsffm.RunnableSample;
import vipsffm.SampleHelper;

import java.lang.foreign.Arena;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Sample showing retrieval of the backing byte[] representation of an image
 */
public class VBlobByteBufferSample implements RunnableSample {

    // https://github.com/lopcode/vips-ffm/issues/72
    // provide a way to get bytes out of a VBlob without raw pointers
    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var image = VImage.thumbnail(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg",
            400
        );

        var blob = image.jpegsaveBuffer();
        var bytes = blob.asClonedByteBuffer();
        var rawDataSegment = blob.getUnsafeDataAddress();
        var rawByteSize = (int) blob.byteSize();

        var remainingBytes = bytes.remaining();
        if (remainingBytes < 50000L || remainingBytes > 100000L) {
            throw new RuntimeException("number of bytes in buffer out of range " + remainingBytes);
        }

        if (remainingBytes != rawByteSize || remainingBytes != (int) rawDataSegment.byteSize()) {
            throw new RuntimeException(
                "unexpected difference in raw byte size vs bytebuffer remaining " + rawByteSize + " " + remainingBytes + " " + rawDataSegment.byteSize()
            );
        }

        var outputPath = workingDirectory.resolve("rabbit_copy.jpg");
        try (var outputStream = Files.newOutputStream(outputPath)) {
            outputStream.write(bytes.array());
        }

        SampleHelper.validate(outputPath, 20L, 100L);
    }
}
