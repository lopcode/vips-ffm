package vipsffm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SampleHelper {

    public static void validate(
        Path path,
        long expectedMinSizeKb,
        long expectedMaxSizeKb
    ) throws IOException {
        if (!Files.exists(path)) {
            throw new RuntimeException("wrote thumbnail, but failed to find at \"" + path + "\"");
        }

        var fileSizeKb = Files.size(path) / 1000;
        if (fileSizeKb < expectedMinSizeKb || fileSizeKb > expectedMaxSizeKb) {
            throw new RuntimeException("unexpected resulting thumbnail size " + fileSizeKb + "kb");
        }

        var bytes = Files.readAllBytes(path);
        var allZeroes = true;
        for (var b : bytes) {
            if (b != 0) {
                allZeroes = false;
                break;
            }
        }
        if (allZeroes) {
            throw new RuntimeException("file all zeroes");
        }
    }
}
