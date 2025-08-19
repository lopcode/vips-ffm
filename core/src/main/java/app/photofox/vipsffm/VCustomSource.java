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

        /**
         * Read data from the input and write it to the provided memory segment
         *
         * @param dataPointer Pointer to the memory segment where the data should be written
         * @param length      The maximum number of bytes to read
         * @return The number of bytes actually read, or -1 on error
         */
        long read(MemorySegment dataPointer, long length);
    }

    @FunctionalInterface
    public interface SeekCallback {

        /**
         * Seek to a specific position in the input
         *
         * @param offset Relative offset in bytes from the position specified by {@code whence}
         * @param whence Where to seek from, one of {@link SeekWhence}
         * @return the new position in the input, or -1 on error
         */
        long seek(long offset, SeekWhence whence);
    }

    public enum SeekWhence {
        /** Seek from the beginning of the input */
        SEEK_SET(0),
        /** Seek from the current position in the input */
        SEEK_CUR(1),
        /** Seek from the end of the input */
        SEEK_END(2);

        private final int value;

        public static SeekWhence fromValue(int value) {
            return switch (value) {
                case 0 -> SEEK_SET;
                case 1 -> SEEK_CUR;
                case 2 -> SEEK_END;
                default -> throw new IllegalArgumentException("Unknown seek whence value: " + value);
            };
        }

        SeekWhence(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
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
            attachSeekSignal(arena, this);
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

    private void attachSeekSignal(Arena arena, VSource source) {
        var callback = new CustomStreamSeekCallback.Function() {

            @Override
            public long apply(
                MemorySegment source,
                long offset,
                int whence,
                MemorySegment handle
            ) {
                return seekCallback.seek(offset, SeekWhence.fromValue(whence));
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
