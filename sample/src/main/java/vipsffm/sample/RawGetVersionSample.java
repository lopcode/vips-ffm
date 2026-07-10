package vipsffm.sample;

import app.photofox.vipsffm.jextract.VipsRaw;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vipsffm.RunnableSample;

import java.lang.foreign.Arena;
import java.nio.file.Path;

/**
 * Sense check that version string via VipsRaw works
 */
public class RawGetVersionSample implements RunnableSample {

    private static final Logger logger = LoggerFactory.getLogger(RawGetVersionSample.class);

    @Override
    public void run(Arena arena, Path workingDirectory) {
        var result = VipsRaw.vips_init(arena.allocateFrom("vips-ffm"));
        if (result != 0) {
            throw new RuntimeException("failed to initialise libvips, code " + result);
        }

        var versionPointer = VipsRaw.vips_version_string();
        var vipsVersion = versionPointer == null ? null : versionPointer.getString(0);
        if (vipsVersion == null || vipsVersion.isBlank()) {
            throw new RuntimeException("failed to get libvips version");
        }

        logger.info("libvips version: \"{}\"", vipsVersion);
    }
}
