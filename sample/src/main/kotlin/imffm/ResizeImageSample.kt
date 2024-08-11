package imffm

import app.photofox.imffm.generated.MagickWand_h.*
import java.io.File
import java.lang.foreign.Arena
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.absolutePathString

// https://imagemagick.org/MagickWand/resize.htm
object ResizeImageSample : RunnableSample {

    override val name = "Image resizing"

    override fun run(arena: Arena, workingDirectory: Path) {
        MagickWandGenesis()

        val wand = NewMagickWand()
        // Read the image - all you need to do is change "logo:" to some other
        // filename to have this resize and, if necessary, convert a different file
        MagickReadImage(wand, arena.allocateFrom("logo:"))

        // Get the image's width and height
        var width = MagickGetImageWidth(wand)
        var height = MagickGetImageHeight(wand)

        // Cut them in half but make sure they don't underflow
        width = (width / 2).coerceAtLeast(1)
        height = (height / 2).coerceAtLeast(1)

        // Resize the image using the Lanczos filter
        // The blur factor is a "double", where > 1 is blurry, < 1 is sharp
        // I haven't figured out how you would change the blur parameter of MagickResizeImage
        // on the command line so I have set it to its default of one.
        MagickResizeImage(wand, width, height, LanczosFilter())

        // Set the compression quality to 95 (high quality = low compression)
        MagickSetImageCompressionQuality(wand, 95)

        /* Write the new image */
        val resizedImagePath = workingDirectory.resolve("logo_resize.jpg")
        MagickWriteImage(wand, arena.allocateFrom(resizedImagePath.absolutePathString()))

        /* Clean up */
        DestroyMagickWand(wand)

        MagickWandTerminus()
    }

    override fun validate(workingDirectory: Path): Result<Unit> {
        val resizedImagePath = workingDirectory.resolve("logo_resize.jpg")
        if (!Files.exists(resizedImagePath)) {
            return Result.failure(
                RuntimeException("expected file does not exist")
            )
        }
        val minSizeKb = 20
        val maxSizeKb = 40
        return runCatching {
            Files.size(resizedImagePath) / 1000.0
        }.map { size ->
            if (size < minSizeKb || size > maxSizeKb) {
                return Result.failure(
                    RuntimeException("image out of bounds (min $minSizeKb, max $maxSizeKb, actual $size")
                )
            }
        }
    }
}
