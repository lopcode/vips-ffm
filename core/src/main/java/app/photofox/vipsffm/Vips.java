package app.photofox.vipsffm;

import java.lang.foreign.Arena;

/// Helper class for running Vips commands with an appropriate arena
///
/// Blocks untrusted operations by default
public class Vips {

    public static void init() {
        init(false, false);
    }

    public static void init(boolean allowUntrusted, boolean detectLeaks) {
        var arena = Arena.global();
        VipsHelper.init(arena, allowUntrusted);
        VipsHelper.leak_set(detectLeaks);
    }

    public static void run(VipsRunnable runnable) {
        try (var arena = Arena.ofConfined()) {
            runnable.run(arena);
        }
    }

    public static void shutdown() {
        VipsHelper.shutdown();
    }
}
