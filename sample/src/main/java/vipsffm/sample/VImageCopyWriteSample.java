package vipsffm.sample;

import app.photofox.vipsffm.VImage;
import vipsffm.RunnableSample;
import vipsffm.SampleHelper;

import java.lang.foreign.Arena;
import java.nio.file.Path;

/**
 * Sense checking creation of a blank image, then writing a loaded image to it
 */
public class VImageCopyWriteSample implements RunnableSample {

    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var source = VImage.newFromFile(arena, "sample/src/main/resources/sample_images/fox.jpg");
        var outputPath = workingDirectory.resolve("fox_copy.jpg");
        var newImage = VImage.newImage(arena);
        source.write(newImage);
        newImage.writeToFile(outputPath.toAbsolutePath().toString());

        SampleHelper.validate(outputPath, 800L, 1200L);
    }
}
