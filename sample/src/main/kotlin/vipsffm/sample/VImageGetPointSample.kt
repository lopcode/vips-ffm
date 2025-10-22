package vipsffm.sample

import app.photofox.vipsffm.VBlob
import app.photofox.vipsffm.VImage
import org.slf4j.LoggerFactory
import vipsffm.RunnableSample
import java.lang.foreign.Arena
import java.nio.file.Path

/**
 * Sample to get the color values at a specific point in an image
 */
object VImageGetPointSample: RunnableSample {

    val logger = LoggerFactory.getLogger(VImageGetPointSample::class.java)

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val sourceImage = VImage
            .newFromFile(
                arena,
                "sample/src/main/resources/sample_images/rabbit.jpg"
            )

        val point = sourceImage.getpoint(100, 100)
        if (point.size != 3) {
            return Result.failure(
                RuntimeException("unexpected number of channels at 100,100: ${point.size}")
            )
        }
        val red = point.get(0).toInt()
        val green = point.get(1).toInt()
        val blue = point.get(2).toInt()
        if (red != 154 ||
            green != 165 ||
            blue != 135) {
            return Result.failure(
                RuntimeException("unexpected pixel value at 100,100: R=${red} G=${green} B=${blue}")
            )
        }

        return Result.success(Unit)
    }
}