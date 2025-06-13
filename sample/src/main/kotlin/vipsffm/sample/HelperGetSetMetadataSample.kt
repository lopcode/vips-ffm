package vipsffm.sample

import app.photofox.vipsffm.VImage
import app.photofox.vipsffm.VipsHelper
import app.photofox.vipsffm.VipsValidation
import app.photofox.vipsffm.jextract.VipsRaw.C_POINTER
import org.slf4j.LoggerFactory
import vipsffm.RunnableSample
import java.lang.foreign.Arena
import java.nio.file.Path

/**
 * Sense checking basic metadata set and fetch functions in VipsHelper
 * Note that you shouldn't use these directly, use VImage::set functions instead
 */
object HelperGetSetMetadataSample: RunnableSample {

    val logger = LoggerFactory.getLogger(HelperGetSetMetadataSample::class.java)

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val sourceImage = VImage.newFromFile(
            arena,
            "sample/src/main/resources/sample_images/rabbit.jpg"
        )

        VipsHelper.image_set_string(
            arena,
            sourceImage.unsafeStructAddress,
            "test-name",
            "test-value"
        )

        val stringPointer = arena.allocate(C_POINTER)
        val result = VipsHelper.image_get_string(
            arena,
            sourceImage.unsafeStructAddress,
            "test-name",
            stringPointer
        )
        if (!VipsValidation.isValidResult(result)) {
            VipsValidation.throwVipsError("image_get_string");
        }
        val testValue = stringPointer.get(C_POINTER, 0).getString(0)
        if (testValue != "test-value") {
            throw RuntimeException("unexpected metadata value")
        }

        return Result.success(Unit)
    }
}