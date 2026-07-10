package vipsffm.sample;

import app.photofox.vipsffm.VImage;
import vipsffm.RunnableSample;

import java.lang.foreign.Arena;
import java.nio.file.Path;

public class VImageFindTrimSample implements RunnableSample {

    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var result = VImage.newFromFile(
            arena,
            "sample/src/main/resources/sample_images/jxl.png"
        ).findTrim();

        if (result.top() != 10 || result.left() != 7 || result.width() != 323 || result.height() != 115) {
            throw new RuntimeException("unexpected find_trim result: " + result);
        }
    }
}
