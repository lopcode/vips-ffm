package vipsffm.sample;

import app.photofox.vipsffm.VImage;
import vipsffm.RunnableSample;
import vipsffm.SampleHelper;

import java.lang.foreign.Arena;
import java.nio.file.Path;

public class VImageBlobSample implements RunnableSample {

    // https://github.com/lopcode/vips-ffm/issues/68
    // tests saving an image to, and loading image from, a buffer
    // which incorrectly caused a gobject refcount on VipsBlob
    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var outputPath = workingDirectory.resolve("rabbit_blob.jpg");
        var imageBlob = VImage.thumbnail(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg",
            400
        )
            .jpegsaveBuffer();

        VImage
            .jpegloadBuffer(arena, imageBlob)
            .writeToFile(outputPath.toAbsolutePath().toString());

        SampleHelper.validate(outputPath, 50L, 200L);
    }
}
