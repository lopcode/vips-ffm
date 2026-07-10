package vipsffm.sample;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.enums.VipsDirection;
import vipsffm.RunnableSample;
import vipsffm.SampleHelper;

import java.lang.foreign.Arena;
import java.nio.file.Path;

/**
 * Sample showing usage of the VImage.join operation
 */
public class VImageJoinSample implements RunnableSample {

    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var sourceImage = VImage.thumbnail(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg",
            500
        );
        var joinImage = VImage.thumbnail(
            arena,
            "sample/src/main/resources/sample_images/fox.jpg",
            500
        );
        var outputPath = workingDirectory.resolve("rabbit_fox_joined.jpg");
        sourceImage.join(joinImage, VipsDirection.DIRECTION_HORIZONTAL)
            .writeToFile(outputPath.toAbsolutePath().toString());

        SampleHelper.validate(outputPath, 20L, 100L);
    }
}
