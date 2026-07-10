package vipsffm.sample;

import app.photofox.vipsffm.VImage;
import vipsffm.RunnableSample;

import java.lang.foreign.Arena;
import java.nio.file.Path;

/**
 * Sample to get the color values at a specific point in an image
 *
 * Note that getPoint is not fast in libvips, and so not suitable to loop over an entire image
 */
public class VImageGetPointSample implements RunnableSample {

    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var sourceImage = VImage
            .newFromFile(
                arena,
                "sample/src/main/resources/sample_images/rabbit.jpg"
            );

        var point = sourceImage.getpoint(100, 100);
        if (point.size() != 3) {
            throw new RuntimeException("unexpected number of channels at 100,100: " + point.size());
        }
        var red = point.get(0).intValue();
        var green = point.get(1).intValue();
        var blue = point.get(2).intValue();
        if (red != 154 ||
            green != 165 ||
            blue != 135) {
            throw new RuntimeException("unexpected pixel value at 100,100: R=" + red + " G=" + green + " B=" + blue);
        }
    }
}
