package vipsffm.sample;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VipsOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vipsffm.RunnableSample;
import vipsffm.SampleHelper;

import java.lang.foreign.Arena;
import java.nio.file.Path;

/**
 * Sense checking basic VImage thumbnail operations
 */
public class VImageCreateThumbnailSample implements RunnableSample {

    private static final Logger logger = LoggerFactory.getLogger(VImageCreateThumbnailSample.class);

    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var thumbnail = VImage.thumbnail(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg",
            400,
            VipsOption.Boolean("auto-rotate", true) // example of an option
        );
        var thumbnailWidth = thumbnail.getWidth();
        var thumbnailHeight = thumbnail.getHeight();
        logger.info("thumbnail image size: {} x {}", thumbnailWidth, thumbnailHeight);

        var thumbnailPath = workingDirectory.resolve("rabbit_thumbnail_400.jpg");
        thumbnail.writeToFile(thumbnailPath.toAbsolutePath().toString());

        var hasAlpha = thumbnail.hasAlpha();
        if (hasAlpha) {
            throw new RuntimeException("unexpected alpha in image");
        }

        SampleHelper.validate(thumbnailPath, 20L, 100L);
    }
}
