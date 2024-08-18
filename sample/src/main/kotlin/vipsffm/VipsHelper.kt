package vipsffm

import app.photofox.vipsffm.generated.VipsRaw
import java.nio.file.Files
import java.nio.file.Path

object VipsHelper {

    fun runCatching(vipsFunction: () -> Int): Result<Unit> {
        val result = vipsFunction()
        if (result != 0) {
            val error = VipsRaw.vips_error_buffer().getString(0)
            return Result.failure(
                RuntimeException("failed to run vips command: $error")
            )
        }
        return Result.success(Unit)
    }

    fun validate(
        thumbnailPath: Path,
        expectedSizeBoundsKb: LongRange
    ): Result<Unit> {
        if (!Files.exists(thumbnailPath)) {
            return Result.failure(
                RuntimeException("wrote thumbnail, but failed to find at \"$thumbnailPath\"")
            )
        }

        val fileSizeKb = Files.size(thumbnailPath) / 1000
        if (!expectedSizeBoundsKb.contains(fileSizeKb)) {
            return Result.failure(
                RuntimeException("unexpected resulting thumbnail size $fileSizeKb")
            )
        }

        return Result.success(Unit)
    }
}