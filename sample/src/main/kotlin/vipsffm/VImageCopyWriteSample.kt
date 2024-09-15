package vipsffm

import app.photofox.vipsffm.VImage
import java.lang.foreign.Arena
import java.nio.file.Path
import kotlin.io.path.absolutePathString

object VImageCopyWriteSample: RunnableSample {

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val source = VImage.newFromFile(arena, "sample/src/main/resources/sample_images/fox.jpg")
        val outputPath = workingDirectory.resolve("fox_copy.jpg")
        val newImage = VImage.newImage(arena)
        source.write(newImage)
        newImage.writeToFile(outputPath.absolutePathString())

        return SampleHelper.validate(
            outputPath,
            expectedSizeBoundsKb = 800L..1200L
        )
    }
}