package vipsffm.sample;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VipsOption;
import app.photofox.vipsffm.enums.VipsAlign;
import vipsffm.RunnableSample;
import vipsffm.SampleHelper;

import java.lang.foreign.Arena;
import java.nio.file.Path;
import java.util.List;

/**
 * Sample showing example usage of VImage.arrayjoin
 */
public class VImageArrayJoinSample implements RunnableSample {

    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var outputPath = workingDirectory.resolve("rabbit_two.jpg");
        var image = VImage.thumbnail(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg",
            400
        );

        VImage.arrayjoin(
            arena,
            List.of(image, image),
            VipsOption.Enum("valign", VipsAlign.ALIGN_CENTRE),
            VipsOption.Enum("halign", VipsAlign.ALIGN_CENTRE),
            VipsOption.Int("across", 2),
            VipsOption.Int("shim", 10)
        )
            .writeToFile(outputPath.toAbsolutePath().toString());

        SampleHelper.validate(outputPath, 50L, 200L);
    }
}
