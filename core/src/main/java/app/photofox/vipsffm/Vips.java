package app.photofox.vipsffm;

import java.lang.foreign.Arena;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

/// Helper class for running Vips commands with an appropriate arena
///
/// Blocks untrusted operations by default
public class Vips {

    private static final AtomicBoolean HAS_INITIALISED = new AtomicBoolean(false);

    static {
        autoInit();
    }

    /// Note that you do not usually need to call [Vips#init] yourself, as initialisation is performed
    /// automatically when vips-ffm classes are used
    public static void init() {
        initOnce();
    }

    /// @deprecated Please migrate to using [Vips#allowUntrustedOperations] and [Vips#enableLeakDetection], and note
    /// that calling [Vips#init] is no longer required
    @Deprecated(forRemoval = true)
    public static void init(boolean allowUntrusted, boolean detectLeaks) {
        initOnce();
        if (allowUntrusted) {
            Vips.allowUntrustedOperations();
        }
        if (detectLeaks) {
            Vips.enableLeakDetection();
        }
    }

    // Intentionally package-private
    static void autoInit() {
        if (HAS_INITIALISED.get()) {
            // Optimistically skip reading system property
            return;
        }
        var shouldAutoInitString = Optional.ofNullable(System.getProperty("vipsffm.autoinit"))
            .orElse("true")
            .toLowerCase(Locale.ENGLISH);
        var shouldAutoInit = Boolean.parseBoolean(shouldAutoInitString);
        if (!shouldAutoInit) {
            return;
        }

        initOnce();
    }

    private static void initOnce() {
        if (HAS_INITIALISED.get()) {
            return;
        }
        VipsHelper.init(Arena.global());
        HAS_INITIALISED.set(true);
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

    /// Enables leak detection
    ///
    /// Calling [Vips#shutdown] will make libvips print out any leaks, and what classes hold memory references
    /// causing these leaks
    public static void enableLeakDetection() {
        VipsHelper.leak_set(true);
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
