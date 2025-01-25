package vipsffm.sample

import app.photofox.vipsffm.VImage
import app.photofox.vipsffm.VipsHelper
import vipsffm.RunnableSample
import java.lang.foreign.Arena
import java.nio.file.Path

/**
 * Sense check getting the number of pages from a VImage using VipsHelper
 */
object VImageGetPagesSample: RunnableSample {

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val sourceImage = VImage.newFromFile(arena, "sample/src/main/resources/sample_images/fox.jpg")
        val numberOfPages = VipsHelper.image_get_n_pages(sourceImage.unsafeStructAddress)

        return if (numberOfPages == 1) {
            Result.success(Unit)
        } else {
            Result.failure(
                RuntimeException("unexpected number of pages: $numberOfPages")
            )
        }
    }
}