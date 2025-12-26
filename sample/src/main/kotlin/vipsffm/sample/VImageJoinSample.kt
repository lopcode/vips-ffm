package vipsffm.sample

import app.photofox.vipsffm.VImage
import app.photofox.vipsffm.enums.VipsDirection
import vipsffm.RunnableSample
import vipsffm.SampleHelper
import java.lang.foreign.Arena
import java.nio.file.Path
import kotlin.io.path.absolutePathString

/**
 * Sample showing usage of the VImage.join operation
 */
object VImageJoinSample: RunnableSample {

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val sourceImage = VImage.thumbnail(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg",
            500
        )
        val joinImage = VImage.thumbnail(
            arena,
            "sample/src/main/resources/sample_images/fox.jpg",
            500
        )
        val outputPath = workingDirectory.resolve("rabbit_fox_joined.jpg")
        sourceImage.join(joinImage, VipsDirection.DIRECTION_HORIZONTAL)
            .writeToFile(outputPath.absolutePathString())

        return SampleHelper.validate(
            outputPath,
            expectedSizeBoundsKb = 20L..100L
        )
    }
}