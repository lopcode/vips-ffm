package vipsffm.sample;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VipsHelper;
import vipsffm.RunnableSample;

import java.lang.foreign.Arena;
import java.nio.file.Path;

/**
 * Sense check getting the number of pages from a VImage using VipsHelper
 */
public class VImageGetPagesSample implements RunnableSample {

    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var sourceImage = VImage.newFromFile(arena, "sample/src/main/resources/sample_images/fox.jpg");
        var numberOfPages = VipsHelper.image_get_n_pages(sourceImage.getUnsafeStructAddress());

        if (numberOfPages != 1) {
            throw new RuntimeException("unexpected number of pages: " + numberOfPages);
        }
    }
}
