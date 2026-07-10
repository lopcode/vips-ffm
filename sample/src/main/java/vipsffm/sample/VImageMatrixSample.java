package vipsffm.sample;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VipsOption;
import app.photofox.vipsffm.enums.VipsInterpretation;
import app.photofox.vipsffm.enums.VipsPrecision;
import vipsffm.RunnableSample;
import vipsffm.SampleHelper;

import java.lang.foreign.Arena;
import java.nio.file.Path;

/**
 * Sample showing example usage of VImage.newMatrix methods
 *
 * Often used for operations that need a mask, like a blur (or blur detection)
 */
public class VImageMatrixSample implements RunnableSample {

    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var image = VImage.thumbnail(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg",
            400
        );

        var mask = VImage.newMatrixFromArray(
            arena,
            3,
            3,
            new double[] {-1.0, -1.0, -1.0, -1.0, 16.0, -1.0, -1.0, -1.0, -1.0}
        );
        mask.set("scale", 8);

        var outputPath = workingDirectory.resolve("rabbit_two.jpg");
        image
            .colourspace(VipsInterpretation.INTERPRETATION_B_W)
            .conv(
                mask,
                VipsOption.Enum("precision", VipsPrecision.PRECISION_INTEGER)
            )
            .writeToFile(outputPath.toAbsolutePath().toString());

        SampleHelper.validate(outputPath, 50L, 200L);
    }
}
