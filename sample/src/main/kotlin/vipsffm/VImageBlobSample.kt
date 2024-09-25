package vipsffm

import app.photofox.vipsffm.VImage
import app.photofox.vipsffm.VSource
import app.photofox.vipsffm.VipsHelper
import java.lang.foreign.Arena
import java.nio.file.Path
import kotlin.io.path.absolutePathString

object VImageBlobSample: RunnableSample {

    // https://github.com/lopcode/vips-ffm/issues/68
    // tests saving an image to, and loading image from, a buffer
    // which incorrectly caused a gobject refcount on VipsBlob
    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val outputPath = workingDirectory.resolve("rabbit_blob.jpg")
        val imageBlob = VImage.newFromFile(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg"
        )
            .thumbnailImage(400)
            .jpegsaveBuffer()

        VImage.newImage(arena)
            .jpegloadBuffer(imageBlob)
            .writeToFile(outputPath.absolutePathString())

        return SampleHelper.validate(
            outputPath,
            expectedSizeBoundsKb = 50L..200L
        )
    }
}