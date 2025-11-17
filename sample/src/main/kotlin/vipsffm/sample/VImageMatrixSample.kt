package vipsffm.sample

import app.photofox.vipsffm.VImage
import app.photofox.vipsffm.VipsOption
import app.photofox.vipsffm.enums.VipsAlign
import app.photofox.vipsffm.enums.VipsInterpretation
import app.photofox.vipsffm.enums.VipsPrecision
import vipsffm.RunnableSample
import vipsffm.SampleHelper
import java.lang.foreign.Arena
import java.nio.file.Path
import kotlin.io.path.absolutePathString

/**
 * Sample showing example usage of VImage.newMatrix methods
 *
 * Often used for operations that need a mask, like a blur (or blur detection)
 */
object VImageMatrixSample: RunnableSample {

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val image = VImage.newFromFile(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg"
        )
        .thumbnailImage(400)

        val mask = VImage.newMatrixFromArray(
            arena,
            3,
            3,
            doubleArrayOf(-1.0, -1.0, -1.0, -1.0, 16.0, -1.0, -1.0, -1.0, -1.0)
        )
        mask.set("scale", 8)

        val outputPath = workingDirectory.resolve("rabbit_two.jpg")
        image
            .colourspace(VipsInterpretation.INTERPRETATION_B_W)
            .conv(
                mask,
                VipsOption.Enum("precision", VipsPrecision.PRECISION_INTEGER)
            )
            .writeToFile(outputPath.absolutePathString())

        return SampleHelper.validate(
            outputPath,
            expectedSizeBoundsKb = 50L..200L
        )
    }
}