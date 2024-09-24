package vipsffm

import app.photofox.vipsffm.VImage
import app.photofox.vipsffm.VSource
import app.photofox.vipsffm.VipsHelper
import app.photofox.vipsffm.VipsOption
import app.photofox.vipsffm.enums.VipsAlign
import java.lang.foreign.Arena
import java.nio.file.Path
import kotlin.io.path.absolutePathString

object VImageArrayJoinSample: RunnableSample {

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val outputPath = workingDirectory.resolve("rabbit_two.jpg")
        val image = VImage.newFromFile(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg"
        )
            .thumbnailImage(400)

        image
            .arrayjoin(
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