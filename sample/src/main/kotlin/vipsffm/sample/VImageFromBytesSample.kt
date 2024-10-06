package vipsffm.sample

import app.photofox.vipsffm.VImage
import app.photofox.vipsffm.VSource
import vipsffm.RunnableSample
import vipsffm.SampleHelper
import java.lang.foreign.Arena
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.absolutePathString

object VImageFromBytesSample: RunnableSample {

    // note that this is generally inefficient, use a "VImage.newFrom" method if available
    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val path = Path.of("sample/src/main/resources/sample_images/rabbit.jpg")
        val bytes = Files.readAllBytes(path)
        val image = VImage.newFromBytes(arena, bytes)
            .thumbnailImage(400)

        val outputPath = workingDirectory.resolve("rabbit_copy.jpg")
        image.writeToFile(outputPath.absolutePathString())

        return SampleHelper.validate(
            outputPath,
            expectedSizeBoundsKb = 20L..100L
        )
    }
}