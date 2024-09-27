package vipsffm.sample

import app.photofox.vipsffm.VImage
import app.photofox.vipsffm.VSource
import app.photofox.vipsffm.VTarget
import vipsffm.RunnableSample
import vipsffm.SampleHelper
import java.lang.foreign.Arena
import java.nio.file.Path
import kotlin.io.path.absolutePathString

object VSourceTargetSample: RunnableSample {

    private const val ORIGINAL_WIDTH = 3115
    private const val ORIGINAL_HEIGHT = 3853

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val source = VSource.newFromFile(arena, "sample/src/main/resources/sample_images/fox.jpg")
        val sourceImage = VImage.newFromSource(arena, source, "")

        val sourceWidth = sourceImage.width
        val sourceHeight = sourceImage.height
        if (sourceWidth != ORIGINAL_WIDTH || sourceHeight != ORIGINAL_HEIGHT) {
            return Result.failure(
                RuntimeException("expected size ${ORIGINAL_WIDTH}x$ORIGINAL_HEIGHT, got ${sourceWidth}x${sourceHeight}")
            )
        }

        val outputPath = workingDirectory.resolve("fox_copy.jpg")
        val target = VTarget.newToFile(arena, outputPath.absolutePathString())
        sourceImage.writeToTarget(target, ".jpg")

        return SampleHelper.validate(
            outputPath,
            expectedSizeBoundsKb = 800L..1200L
        )
    }
}