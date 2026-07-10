package vipsffm.sample;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VipsHelper;
import vipsffm.RunnableSample;
import vipsffm.SampleHelper;

import java.lang.foreign.Arena;
import java.nio.file.Path;

/**
 * Sample showing loading an image directly from a bag of bytes, bypassing libvips' source loaders and
 * then writing it back to raw memory bytes again.
 * Please read the docs on [VImage#newFromMemory] and [VImage#writeToMemory] before using this,
 * and use the higher level methods if possible
 */
public class VImageFromMemoryToMemorySample implements RunnableSample {

    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var path = Path.of("sample/src/main/resources/sample_images/rabbit.jpg");
        var image = VImage.thumbnail(
            arena,
            path.toAbsolutePath().toString(),
            400
        );

        var bands = VipsHelper.image_get_bands(image.getUnsafeStructAddress());
        var width = image.getWidth();
        var height = image.getHeight();
        var format = VipsHelper.image_get_format(image.getUnsafeStructAddress());
        var memorySegment = image.writeToMemory();

        var outputPath = workingDirectory.resolve("rabbit_copy.jpg");
        var imageFromMemory = VImage.newFromMemory(
            arena,
            memorySegment,
            width,
            height,
            bands,
            format
        );
        imageFromMemory.writeToFile(outputPath.toAbsolutePath().toString());

        SampleHelper.validate(outputPath, 20L, 100L);
    }
}
