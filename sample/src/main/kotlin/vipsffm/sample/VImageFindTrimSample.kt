package vipsffm.sample

import app.photofox.vipsffm.VImage
import vipsffm.RunnableSample
import java.lang.foreign.Arena
import java.nio.file.Path

object VImageFindTrimSample : RunnableSample {

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val results = VImage.newFromFile(
            arena,
            "sample/src/main/resources/sample_images/jxl.png"
        ).findTrim()
        assert(results.size == 4) {
            "Not enough results of findTrim operation"
        }
        assert(results["top"]?.valueOrThrow() == 10)
        assert(results["left"]?.valueOrThrow() == 7)
        assert(results["width"]?.valueOrThrow() == 323)
        assert(results["height"]?.valueOrThrow() == 115)
        return Result.success(Unit)
    }
}