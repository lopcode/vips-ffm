package vipsffm

import app.photofox.vipsffm.VImage
import app.photofox.vipsffm.VipsOption
import java.lang.foreign.Arena
import java.nio.file.Path
import kotlin.io.path.absolutePathString

object VImageChainSample: RunnableSample {

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val outputPath = workingDirectory.resolve("rabbit_chain.jpg")
        val image = VImage.newFromFile(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg"
        )
            .thumbnailImage(
                400,
                VipsOption.Boolean("no_rotate", true) // image doesn't have rotation exif data - so no effect
            )
            .invert()
            .rotate(90.0)

        image.writeToFile(outputPath.absolutePathString())

        // image thumbnail is 323x400 after being shrunk to 400 on its longest edge (height)
        // then rotated 90 degrees to become 400x323
        if (image.width != 400) {
            return Result.failure(
                RuntimeException("expected width of 400, not ${image.height}")
            )
        }

        return SampleHelper.validate(
            outputPath,
            expectedSizeBoundsKb = 20L..100L
        )
    }
}