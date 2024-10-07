package app.photofox.vipsffm;

import app.photofox.vipsffm.jextract.CustomStreamEndCallback;
import app.photofox.vipsffm.jextract.CustomStreamWriteCallback;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

/**
 * Models a libvips "custom streaming" target
 * Provides callbacks for write and end operations
 * See <a href="https://www.libvips.org/2019/11/29/True-streaming-for-libvips.html">true streaming for libvips</a>
 */
public final class VCustomTarget extends VTarget {

    @FunctionalInterface
    public interface WriteCallback {

        long write(MemorySegment dataPointer);
    }

    @FunctionalInterface
    public interface EndCallback {

        int end();
    }

    private final WriteCallback writeCallback;
    private final EndCallback endCallback;

    public VCustomTarget(
        Arena arena,
        WriteCallback writeCallback,
        EndCallback endCallback
    ) throws VipsError {
        super(arena, VipsHelper.target_custom_new(arena));
        this.writeCallback = writeCallback;
        this.endCallback = endCallback;

        attachWriteSignal(arena, this);
        attachEndSignal(arena, this);
    }

    private void attachWriteSignal(Arena arena, VTarget target) {
        var callback = new CustomStreamWriteCallback.Function() {

            @Override
            public long apply(
                MemorySegment source,
                MemorySegment data,
                long length,
                MemorySegment handle
            ) {
                var segment = data.asSlice(0, length);
                return writeCallback.write(segment);
            }
        };
        var callbackPointer = CustomStreamWriteCallback.allocate(callback, arena);
        var result = VipsHelper.g_signal_connect_data(
            arena,
            target.address,
            "write",
            callbackPointer,
            MemorySegment.NULL,
            MemorySegment.NULL,
            0
        );
        if (result <= 0) {
            throw new VipsError("failed to create write signal");
        }
    }

    private void attachEndSignal(Arena arena, VTarget target) {
        var callback = new CustomStreamEndCallback.Function() {

            @Override
            public int apply(
                MemorySegment source,
                MemorySegment handle
            ) {
                return endCallback.end();
            }
        };
        var callbackPointer = CustomStreamEndCallback.allocate(callback, arena);
        var result = VipsHelper.g_signal_connect_data(
            arena,
            target.address,
            "end",
            callbackPointer,
            MemorySegment.NULL,
            MemorySegment.NULL,
            0
        );
        if (result <= 0) {
            throw new VipsError("failed to create end signal");
        }
    }
}
