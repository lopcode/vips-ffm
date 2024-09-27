package vipsffm

import app.photofox.vipsffm.VImage
import app.photofox.vipsffm.VSource
import app.photofox.vipsffm.VTarget
import java.lang.foreign.Arena
import java.nio.file.Path
import kotlin.io.path.absolutePathString

object VTargetToFileSample: RunnableSample {

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val source = VSource.newFromFile(arena, "sample/src/main/resources/sample_images/fox.jpg")
        val sourceImage = VImage.newFromSource(arena, source, "")

        val target = VTarget.newToMemory(arena)
        sourceImage.writeToTarget(target, ".jpg")

        val blob = target.blob
        val outputSource = VSource.newFromBlob(arena, blob)
        val outputPath = workingDirectory.resolve("fox_copy.jpg")
        VImage.newFromSource(arena, outputSource, "")
            .writeToFile(outputPath.absolutePathString())

        return SampleHelper.validate(
            outputPath,
            expectedSizeBoundsKb = 800L..1200L
        )
    }
}