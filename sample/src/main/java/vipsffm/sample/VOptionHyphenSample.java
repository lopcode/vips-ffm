package vipsffm.sample;

import app.photofox.vipsffm.VImage;
import vipsffm.RunnableSample;
import vipsffm.SampleHelper;

import java.lang.foreign.Arena;
import java.nio.file.Path;

public class VOptionHyphenSample implements RunnableSample {

    // https://github.com/lopcode/vips-ffm/issues/60
    // tests a vips operation with a hyphenated option name ("output-profile") in icc_transform
    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var outputPath = workingDirectory.resolve("rabbit_chain.jpg");
        var image = VImage.thumbnail(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg",
            400
        )
            .iccTransform("cmyk");

        image.writeToFile(outputPath.toAbsolutePath().toString());

        SampleHelper.validate(outputPath, 750L, 1500L);
    }
}
