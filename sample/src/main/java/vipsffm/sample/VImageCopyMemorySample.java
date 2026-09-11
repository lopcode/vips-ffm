package vipsffm.sample;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VipsOption;
import vipsffm.RunnableSample;
import vipsffm.SampleHelper;

import java.lang.foreign.Arena;
import java.nio.file.Path;
import java.util.List;

/**
 * Sample showing how to make a private memory copy of an image with [VImage#copyMemory], so that it can be
 * modified in place with the draw operations. The source image is left untouched.
 */
public class VImageCopyMemorySample implements RunnableSample {

    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var sourceImage = VImage.newFromFile(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg"
        );

        var memoryImage = sourceImage.copyMemory();
        var red = List.of(255.0, 0.0, 0.0);
        memoryImage.drawRect(red, 0, 0, 150, 150, VipsOption.Boolean("fill", true));

        expectPoint(memoryImage, 100, 100, 255, 0, 0);
        expectPoint(sourceImage, 100, 100, 154, 165, 135);

        // copying an image that is already in memory returns another reference to it rather than a new copy
        var secondCopy = memoryImage.copyMemory();
        expectPoint(secondCopy, 100, 100, 255, 0, 0);

        var outputPath = workingDirectory.resolve("rabbit_red_square.jpg");
        memoryImage.writeToFile(outputPath.toAbsolutePath().toString());

        SampleHelper.validate(outputPath, 500L, 2000L);
    }

    private static void expectPoint(VImage image, int x, int y, int red, int green, int blue) throws Exception {
        var point = image.getpoint(x, y);
        if (point.size() != 3) {
            throw new RuntimeException("unexpected number of channels at " + x + "," + y + ": " + point.size());
        }
        var actualRed = point.get(0).intValue();
        var actualGreen = point.get(1).intValue();
        var actualBlue = point.get(2).intValue();
        if (actualRed != red || actualGreen != green || actualBlue != blue) {
            throw new RuntimeException(
                "unexpected pixel value at " + x + "," + y + ": R=" + actualRed + " G=" + actualGreen + " B=" + actualBlue
            );
        }
    }
}
