package vipsffm.sample;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VipsHelper;
import app.photofox.vipsffm.VipsValidation;
import vipsffm.RunnableSample;

import java.lang.foreign.Arena;
import java.nio.file.Path;

import static app.photofox.vipsffm.jextract.VipsRaw.C_POINTER;

/**
 * Sense checking basic metadata set and fetch functions in VipsHelper
 * Note that you shouldn't use these directly, use VImage::set functions instead
 */
public class HelperGetSetMetadataSample implements RunnableSample {

    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var sourceImage = VImage.newFromFile(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg"
        );

        VipsHelper.image_set_string(
            arena,
            sourceImage.getUnsafeStructAddress(),
            "test-name",
            "test-value"
        );

        var stringPointer = arena.allocate(C_POINTER);
        var result = VipsHelper.image_get_string(
            arena,
            sourceImage.getUnsafeStructAddress(),
            "test-name",
            stringPointer
        );
        if (!VipsValidation.isValidResult(result)) {
            VipsValidation.throwVipsError("image_get_string");
        }
        var testValue = stringPointer.get(C_POINTER, 0).getString(0);
        if (!testValue.equals("test-value")) {
            throw new RuntimeException("unexpected metadata value");
        }
    }
}
