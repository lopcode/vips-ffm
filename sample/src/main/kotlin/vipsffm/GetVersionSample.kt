package vipsffm

import app.photofox.vipsffm.generated.vips_h.vips_init
import app.photofox.vipsffm.generated.vips_h.vips_version_string
import org.slf4j.LoggerFactory
import java.lang.foreign.Arena
import java.nio.file.Path

object GetVersionSample : RunnableSample {

    val logger = LoggerFactory.getLogger(GetVersionSample::class.java)

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val result = vips_init(arena.allocateFrom("vips-ffm"))
        if (result != 0) {
            return Result.failure(
                RuntimeException("failed to initialise libvips, code $result")
            )
        }

        val vipsVersion = vips_version_string()?.getString(0)
        if (vipsVersion.isNullOrBlank()) {
            return Result.failure(
                RuntimeException("failed to get libvips version")
            )
        }

        logger.info("libvips version: \"$vipsVersion\"")
        return Result.success(Unit)
    }
}
