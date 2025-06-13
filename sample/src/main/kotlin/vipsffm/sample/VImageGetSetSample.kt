package vipsffm.sample

import app.photofox.vipsffm.VBlob
import app.photofox.vipsffm.VImage
import org.slf4j.LoggerFactory
import vipsffm.RunnableSample
import java.lang.foreign.Arena
import java.nio.file.Path

/**
 * Sense checking basic metadata set and fetch functions in VImage
 */
object VImageGetSetSample: RunnableSample {

    val logger = LoggerFactory.getLogger(VImageGetSetSample::class.java)

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val sourceImage = VImage
            .newFromFile(
                arena,
                "sample/src/main/resources/sample_images/rabbit.jpg"
            )
            .set("test-name-string", "test-value")
            .set("test-name-int", 1234)
            .set("test-name-double", 1234.0)
            .set("test-name-blob", VBlob.newFromBytes(arena, byteArrayOf(0x01, 0x02, 0x03, 0x04)))
            .set("test-name-image", VImage.black(arena, 100, 100))

        val testStringValue = sourceImage.getString("test-name-string")
        if (testStringValue != "test-value") {
            return Result.failure(
                RuntimeException("unexpected value in metadata")
            )
        }

        if (sourceImage.getInt("test-name-int") != 1234) {
            return Result.failure(
                RuntimeException("unexpected value in metadata")
            )
        }

        if (sourceImage.getDouble("test-name-double") != 1234.0) {
            return Result.failure(
                RuntimeException("unexpected value in metadata")
            )
        }

        val bytes = sourceImage.getBlob("test-name-blob").asClonedByteBuffer()
        if (!bytes.array().contentEquals(byteArrayOf(0x01, 0x02, 0x03, 0x04))) {
            return Result.failure(
                RuntimeException("unexpected value in metadata")
            )
        }

        val image = sourceImage.getImage("test-name-image")
        if (image.width != 100 && image.height != 100) {
            return Result.failure(
                RuntimeException("unexpected value in metadata")
            )
        }

        val testKnownInvalidNameValue = sourceImage.getString("definitely-doesnt-exist")
        if (testKnownInvalidNameValue != null) {
            return Result.failure(
                RuntimeException("unexpected value in known empty field")
            )
        }

        val fieldNames = sourceImage.fields
        if (!fieldNames.containsAll(listOf("test-name-string", "test-name-int", "test-name-double", "test-name-blob", "test-name-image"))) {
            return Result.failure(
                RuntimeException("unexpected missing metadata entry in fields")
            )
        }

        return Result.success(Unit)
    }
}