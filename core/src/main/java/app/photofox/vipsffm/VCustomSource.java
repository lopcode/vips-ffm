package app.photofox.vipsffm;

import app.photofox.vipsffm.jextract.CustomStreamReadCallback;
import app.photofox.vipsffm.jextract.CustomStreamSeekCallback;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

/// Models a libvips "custom streaming" source
///
/// Provides callbacks for read and seek operations
///
/// See [true streaming for libvips](https://www.libvips.org/2019/11/29/True-streaming-for-libvips.html)
public final class VCustomSource extends VSource {

    @FunctionalInterface
    public interface ReadCallback {

        long read(MemorySegment dataPointer, long length);
    }

    @FunctionalInterface
    public interface SeekCallback {

        long seek(int whence);
    }

    private final VCustomSource.ReadCallback readCallback;
    private final VCustomSource.SeekCallback seekCallback;

    public VCustomSource(
        Arena arena,
        VCustomSource.ReadCallback readCallback,
        VCustomSource.SeekCallback seekCallback
    ) throws VipsError {
        super(arena, VipsHelper.source_custom_new(arena));
        this.readCallback = readCallback;
        this.seekCallback = seekCallback;

        attachReadSignal(arena, this);
        if (seekCallback != null) {
            attachSeekSignal(arena, this, seekCallback);
        }
    }

    public VCustomSource(
        Arena arena,
        VCustomSource.ReadCallback readCallback
    ) throws VipsError {
        this(arena, readCallback, null);
    }

    private void attachReadSignal(Arena arena, VSource source) {
        var callback = new CustomStreamReadCallback.Function() {

            @Override
            public long apply(
                MemorySegment source,
                MemorySegment data,
                long length,
                MemorySegment handle
            ) {
                return readCallback.read(data, length);
            }
        };
        var callbackPointer = CustomStreamReadCallback.allocate(callback, arena);
        var result = VipsHelper.g_signal_connect_data(
            arena,
            source.address,
            "read",
            callbackPointer,
            MemorySegment.NULL,
            MemorySegment.NULL,
            0
        );
        if (result <= 0) {
            throw new VipsError("failed to create read signal");
        }
    }

    private void attachSeekSignal(Arena arena, VSource source, SeekCallback seekCallback) {
        var callback = new CustomStreamSeekCallback.Function() {

            @Override
            public long apply(
                MemorySegment source,
                MemorySegment data,
                int whence,
                MemorySegment handle
            ) {
                return seekCallback.seek(whence);
            }
        };
        var callbackPointer = CustomStreamSeekCallback.allocate(callback, arena);
        var result = VipsHelper.g_signal_connect_data(
            arena,
            source.address,
            "seek",
            callbackPointer,
            MemorySegment.NULL,
            MemorySegment.NULL,
            0
        );
        if (result <= 0) {
            throw new VipsError("failed to create seek signal");
        }
    }
}
