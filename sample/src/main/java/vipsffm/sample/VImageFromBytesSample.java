package vipsffm.sample;

import app.photofox.vipsffm.VImage;
import vipsffm.RunnableSample;
import vipsffm.SampleHelper;

import java.lang.foreign.Arena;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Sense checking loading a VImage from raw bytes
 */
public class VImageFromBytesSample implements RunnableSample {

    // note that this is generally inefficient, use a "VImage.newFrom" method if available
    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var path = Path.of("sample/src/main/resources/sample_images/rabbit.jpg");
        var bytes = Files.readAllBytes(path);
        var image = VImage.newFromBytes(arena, bytes)
            .thumbnailImage(400); // prefer VImage.thumbnail if possible

        var outputPath = workingDirectory.resolve("rabbit_copy.jpg");
        image.writeToFile(outputPath.toAbsolutePath().toString());

        SampleHelper.validate(outputPath, 20L, 100L);
    }
}
