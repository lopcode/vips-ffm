package vipsffm.sample;

import app.photofox.vipsffm.VBlob;
import app.photofox.vipsffm.VImage;
import vipsffm.RunnableSample;

import java.awt.color.ColorSpace;
import java.awt.color.ICC_Profile;
import java.lang.foreign.Arena;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * Sense checking basic metadata set and fetch functions in VImage
 */
public class VImageGetSetSample implements RunnableSample {

    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var sourceImage = VImage
            .newFromFile(
                arena,
                "sample/src/main/resources/sample_images/rabbit.jpg"
            )
            .set("test-name-string", "test-value")
            .set("test-name-int", 1234)
            .set("test-name-double", 1234.0)
            .set("test-name-blob", VBlob.newFromBytes(arena, new byte[] {0x01, 0x02, 0x03, 0x04}))
            .set("test-name-image", VImage.black(arena, 100, 100))
            .set("test-name-remove", "test-value-to-be-removed");

        var testStringValue = sourceImage.getString("test-name-string");
        if (!"test-value".equals(testStringValue)) {
            throw new RuntimeException("unexpected value in metadata");
        }

        if (sourceImage.getInt("test-name-int") != 1234) {
            throw new RuntimeException("unexpected value in metadata");
        }

        if (sourceImage.getDouble("test-name-double") != 1234.0) {
            throw new RuntimeException("unexpected value in metadata");
        }

        var bytes = sourceImage.getBlob("test-name-blob").getBytes();
        if (!Arrays.equals(bytes, new byte[] {0x01, 0x02, 0x03, 0x04})) {
            throw new RuntimeException("unexpected value in metadata");
        }

        var iccBytes = sourceImage.getBlob("icc-profile-data").asClonedByteBuffer();
        var profile = ICC_Profile.getInstance(iccBytes.array());
        if (profile.getMajorVersion() != 2 || profile.getColorSpaceType() != ColorSpace.TYPE_RGB) {
            throw new RuntimeException("unexpected icc profile values");
        }

        var imageFromMetadata = sourceImage.getImage("test-name-image");
        if (imageFromMetadata.getWidth() != 100 && imageFromMetadata.getHeight() != 100) {
            throw new RuntimeException("unexpected value in metadata");
        }

        var testKnownInvalidNameValue = sourceImage.getString("definitely-doesnt-exist");
        if (testKnownInvalidNameValue != null) {
            throw new RuntimeException("unexpected value in known empty field");
        }

        var removedEntry = sourceImage.remove("test-name-remove");
        if (!removedEntry) {
            throw new RuntimeException("should have removed entry");
        }

        var fieldNames = sourceImage.getFields();
        if (!fieldNames.containsAll(List.of("test-name-string", "test-name-int", "test-name-double", "test-name-blob", "test-name-image"))) {
            throw new RuntimeException("unexpected missing metadata entry in fields");
        }

        if (fieldNames.contains("test-name-remove")) {
            throw new RuntimeException("unexpected entry that should have been removed");
        }
    }
}
