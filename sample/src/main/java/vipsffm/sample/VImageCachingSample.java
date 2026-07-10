package vipsffm.sample;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.enums.VipsDirection;
import vipsffm.RunnableSample;
import vipsffm.SampleHelper;

import java.lang.foreign.Arena;
import java.nio.file.Path;

public class VImageCachingSample implements RunnableSample {

    // https://github.com/lopcode/vips-ffm/issues/62
    // cached operations reliably crashed on the second invocation
    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var outputPath = workingDirectory.resolve("rabbit_chain.jpg");

        for (var i = 0; i < 3; i++) {
            var image = VImage.thumbnail(
                arena,
                "sample/src/main/resources/sample_images/rabbit.jpg",
                400
            )
                .flip(VipsDirection.DIRECTION_VERTICAL)
                .autorot();

            image.writeToFile(outputPath.toAbsolutePath().toString());
        }

        SampleHelper.validate(outputPath, 50L, 200L);
    }
}
