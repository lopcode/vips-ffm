package vipsffm.sample;

import app.photofox.vipsffm.VipsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vipsffm.RunnableSample;

import java.lang.foreign.Arena;
import java.nio.file.Path;

/**
 * Sense check that version string via helper works
 */
public class HelperGetVersionSample implements RunnableSample {

    private static final Logger logger = LoggerFactory.getLogger(HelperGetVersionSample.class);

    @Override
    public void run(Arena arena, Path workingDirectory) {
        var version = VipsHelper.version_string();
        if (version == null || version.isBlank()) {
            throw new RuntimeException("failed to get libvips version");
        }

        logger.info("libvips version: \"{}\"", version);
    }
}
