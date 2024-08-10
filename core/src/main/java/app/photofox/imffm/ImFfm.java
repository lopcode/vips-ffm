package app.photofox.imffm;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import static app.photofox.imffm.generated.MagickWand_h.*;

public class ImFfm {

    public static void main(String[] args) {
        try (var arena = Arena.ofConfined()) {
            resizeImageSample(arena);
            // intentionally throws
        }
    }

    private static void resizeImageSample(Arena arena) {
        // https://imagemagick.org/MagickWand/resize.htm

        MagickWandGenesis();

        MemorySegment wand = NewMagickWand();
        // Read the image - all you need to do is change "logo:" to some other
        // filename to have this resize and, if necessary, convert a different file
        MagickReadImage(wand, arena.allocateFrom("logo:"));

        // Get the image's width and height
        long width = MagickGetImageWidth(wand);
        long height = MagickGetImageHeight(wand);

        // Cut them in half but make sure they don't underflow
        if((width /= 2) < 1) width = 1;
        if((height /= 2) < 1) height = 1;

        // Resize the image using the Lanczos filter
        // The blur factor is a "double", where > 1 is blurry, < 1 is sharp
        // I haven't figured out how you would change the blur parameter of MagickResizeImage
        // on the command line so I have set it to its default of one.
        MagickResizeImage(wand, width, height, LanczosFilter());

        // Set the compression quality to 95 (high quality = low compression)
        MagickSetImageCompressionQuality(wand, 95);

        /* Write the new image */
        MagickWriteImage(wand, arena.allocateFrom("logo_resize.jpg"));

        /* Clean up */
        DestroyMagickWand(wand);

        MagickWandTerminus();
    }
}
