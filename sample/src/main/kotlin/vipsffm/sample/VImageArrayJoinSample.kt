package vipsffm.sample

import app.photofox.vipsffm.VImage
import app.photofox.vipsffm.VipsOption
import app.photofox.vipsffm.enums.VipsAlign
import vipsffm.RunnableSample
import vipsffm.SampleHelper
import java.lang.foreign.Arena
import java.nio.file.Path
import kotlin.io.path.absolutePathString

/**
 * Sample showing example usage of VImage.arrayjoin
 */
object VImageArrayJoinSample: RunnableSample {

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val outputPath = workingDirectory.resolve("rabbit_two.jpg")
        val image = VImage.thumbnail(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg",
            400
        )

        VImage.arrayjoin(
            arena,
            listOf(image, image),
            VipsOption.Enum("valign", VipsAlign.ALIGN_CENTRE),
            VipsOption.Enum("halign", VipsAlign.ALIGN_CENTRE),
            VipsOption.Int("across", 2),
            VipsOption.Int("shim", 10)
        )
        .writeToFile(outputPath.absolutePathString())

        return SampleHelper.validate(
            outputPath,
            expectedSizeBoundsKb = 50L..200L
        )
    }
}