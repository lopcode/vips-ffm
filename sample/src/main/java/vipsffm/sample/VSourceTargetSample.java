package vipsffm.sample;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VSource;
import app.photofox.vipsffm.VTarget;
import vipsffm.RunnableSample;
import vipsffm.SampleHelper;

import java.lang.foreign.Arena;
import java.nio.file.Path;

/**
 * Sense checking basic source creation and target writing operations
 */
public class VSourceTargetSample implements RunnableSample {

    private static final int ORIGINAL_WIDTH = 3115;
    private static final int ORIGINAL_HEIGHT = 3853;

    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var source = VSource.newFromFile(arena, "sample/src/main/resources/sample_images/fox.jpg");
        var sourceImage = VImage.newFromSource(arena, source);

        var sourceWidth = sourceImage.getWidth();
        var sourceHeight = sourceImage.getHeight();
        if (sourceWidth != ORIGINAL_WIDTH || sourceHeight != ORIGINAL_HEIGHT) {
            throw new RuntimeException(
                "expected size " + ORIGINAL_WIDTH + "x" + ORIGINAL_HEIGHT + ", got " + sourceWidth + "x" + sourceHeight
            );
        }

        var outputPath = workingDirectory.resolve("fox_copy.jpg");
        var target = VTarget.newToFile(arena, outputPath.toAbsolutePath().toString());
        sourceImage.writeToTarget(target, ".jpg");

        SampleHelper.validate(outputPath, 800L, 1200L);
    }
}
