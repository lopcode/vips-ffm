package vipsffm.sample

import app.photofox.vipsffm.VImage
import vipsffm.RunnableSample
import java.lang.foreign.Arena
import java.nio.file.Path

object VImageFindTrimSample : RunnableSample {

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val result = VImage.newFromFile(
            arena,
            "sample/src/main/resources/sample_images/jxl.png"
        ).findTrim()

        assert(result.top == 10)
        assert(result.left == 7)
        assert(result.width == 323)
        assert(result.height == 115)
        return Result.success(Unit)
    }
}