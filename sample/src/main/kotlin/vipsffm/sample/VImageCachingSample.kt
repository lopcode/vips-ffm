package vipsffm.sample

import app.photofox.vipsffm.VImage
import app.photofox.vipsffm.enums.VipsDirection
import vipsffm.RunnableSample
import vipsffm.SampleHelper
import java.lang.foreign.Arena
import java.nio.file.Path
import kotlin.io.path.absolutePathString

object VImageCachingSample: RunnableSample {

    // https://github.com/lopcode/vips-ffm/issues/62
    // cached operations reliably crashed on the second invocation
    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val outputPath = workingDirectory.resolve("rabbit_chain.jpg")

        (0 ..< 3).forEach { _ ->
            val image = VImage.newFromFile(
                arena,
                "sample/src/main/resources/sample_images/rabbit.jpg"
            )
                .thumbnailImage(400)
                .flip(VipsDirection.DIRECTION_VERTICAL)
                .autorot()

            image.writeToFile(outputPath.absolutePathString())
        }

        return SampleHelper.validate(
            outputPath,
            expectedSizeBoundsKb = 50..200L
        )
    }
}