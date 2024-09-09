package vipsffm

import app.photofox.vipsffm.VipsHelper
import org.slf4j.LoggerFactory
import java.lang.foreign.Arena
import java.nio.file.Path

object HelperGetVersionSample : RunnableSample {

    val logger = LoggerFactory.getLogger(HelperGetVersionSample::class.java)

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val version = VipsHelper.version_string()
        if (version.isNullOrBlank()) {
            return Result.failure(
                RuntimeException("failed to get libvips version")
            )
        }

        logger.info("libvips version: \"$version\"")
        return Result.success(Unit)
    }
}
