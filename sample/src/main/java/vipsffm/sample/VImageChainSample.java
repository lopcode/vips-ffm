package vipsffm.sample;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VipsOption;
import app.photofox.vipsffm.enums.VipsDirection;
import app.photofox.vipsffm.enums.VipsInterpretation;
import vipsffm.RunnableSample;
import vipsffm.SampleHelper;

import java.lang.foreign.Arena;
import java.nio.file.Path;

/**
 * Sample testing chained operations on a VImage
 */
public class VImageChainSample implements RunnableSample {

    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var outputPath = workingDirectory.resolve("rabbit_chain.jpg");
        var image = VImage.thumbnail(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg",
            400,
            VipsOption.Boolean("no_rotate", true) // image doesn't have rotation exif data - so no effect
        )
            .invert()
            .rotate(90.0)
            .colourspace(VipsInterpretation.INTERPRETATION_CMYK)
            .flip(VipsDirection.DIRECTION_HORIZONTAL);

        image.writeToFile(outputPath.toAbsolutePath().toString());

        // image thumbnail is 323x400 after being shrunk to 400 on its longest edge (height)
        // then rotated 90 degrees to become 400x323
        if (image.getWidth() != 400) {
            throw new RuntimeException("expected width of 400, not " + image.getHeight());
        }

        SampleHelper.validate(outputPath, 20L, 1500L);
    }
}
