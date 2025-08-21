package app.photofox.vipsffm;

import java.lang.foreign.Arena;

/// Helper class for running Vips commands with an appropriate arena
///
/// Blocks untrusted operations by default
public class Vips {

    private static boolean isInitialized = false;

    public static void init() {
        init(false, false);
    }

    public static void init(boolean allowUntrusted, boolean detectLeaks) {
        if (isInitialized) {
            throw new IllegalStateException("Vips has already been initialized!");
        }
        var arena = Arena.global();
        VipsHelper.init(arena, allowUntrusted);
        VipsHelper.leak_set(detectLeaks);
        isInitialized = true;
    }

    public static void checkWasInitialized() {
        if (!isInitialized) {
            throw new IllegalStateException("Vips has not been initialized. Call Vips.init() first!");
        }
    }

    /// Provides a scoped arena to provide a memory boundary for running libvips operations
    ///
    /// After the scope has ended, any memory allocated whilst using libvips within it will be freed
    public static void run(VipsRunnable runnable) {
        try (var arena = Arena.ofConfined()) {
            runnable.run(arena);
        }
    }

    public static void shutdown() {
        VipsHelper.shutdown();
    }

    /// Permits untrusted operations, such as loading PDFs
    ///
    /// vips-ffm blocks these by default - see the [libvips docs](https://www.libvips.org/API/8.17/func.block_untrusted_set.html)
    /// for guidance
    public static void allowUntrustedOperations() {
        VipsHelper.block_untrusted_set(false);
    }

    /// Disables the libvips operations cache
    ///
    /// At the time of writing libvips caches 100 operations by default, which might not be useful in long-running
    /// applications (like servers).
    ///
    /// See also: [libvips docs](https://www.libvips.org/API/8.17/how-it-works.html#operation-cache)
    public static void disableOperationCache() {
        VipsHelper.cache_set_max(0);
    }
}
