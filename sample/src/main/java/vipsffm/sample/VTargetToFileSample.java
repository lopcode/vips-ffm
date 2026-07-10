package vipsffm.sample;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VSource;
import app.photofox.vipsffm.VTarget;
import vipsffm.RunnableSample;
import vipsffm.SampleHelper;

import java.lang.foreign.Arena;
import java.nio.file.Path;

public class VTargetToFileSample implements RunnableSample {

    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var source = VSource.newFromFile(arena, "sample/src/main/resources/sample_images/fox.jpg");
        var sourceImage = VImage.newFromSource(arena, source);

        var target = VTarget.newToMemory(arena);
        sourceImage.writeToTarget(target, ".jpg");

        var blob = target.getBlob();
        var outputSource = VSource.newFromBlob(arena, blob);
        var outputPath = workingDirectory.resolve("fox_copy.jpg");
        VImage.newFromSource(arena, outputSource)
            .writeToFile(outputPath.toAbsolutePath().toString());

        SampleHelper.validate(outputPath, 800L, 1200L);
    }
}
