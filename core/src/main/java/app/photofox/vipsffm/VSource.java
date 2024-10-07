package app.photofox.vipsffm;

import java.io.IOException;
import java.io.InputStream;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

/**
 * Represents a VipsSource
 * Its constructor is package private to prevent leaking MemorySegments in to the vips-ffm API
 * Use its static helper methods to create new sources
 */
public sealed class VSource permits VCustomSource {

    final Arena arena;
    final MemorySegment address;

    VSource(Arena arena, MemorySegment address) throws VipsError {
        if (!VipsValidation.isValidPointer(address)) {
            throw new VipsError("invalid pointer used for creation");
        }
        this.arena = arena;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VSource vSource)) return false;

        return address.equals(vSource.address);
    }

    @Override
    public int hashCode() {
        return address.hashCode();
    }

    /**
     * @deprecated See {@link #getUnsafeStructAddress}
     */
    @Deprecated(
        since = "0.5.10",
        forRemoval = true
    )
    public MemorySegment getUnsafeAddress() {
        return this.getUnsafeStructAddress();
    }

    /**
     * Gets the raw {@link MemorySegment} (C pointer) for this VipsSource struct
     * The memory address' lifetime is bound to the scope of the arena that created it
     * Usage of the memory address is strongly discouraged, but it is available if some functionality is missing, and
     * you need to use it with {@link VipsHelper}
     */
    public MemorySegment getUnsafeStructAddress() {
        return this.address;
    }

    /**
     * Create a new VSource from a file descriptor
     */
    public static VSource newFromDescriptor(Arena arena, int descriptor) throws VipsError {
        var pointer = VipsHelper.source_new_from_descriptor(arena, descriptor);
        return new VSource(arena, pointer);
    }

    /**
     * Create a new VSource from a file path
     */
    public static VSource newFromFile(Arena arena, String filename) throws VipsError {
        var pointer = VipsHelper.source_new_from_file(arena, filename);
        return new VSource(arena, pointer);
    }

    /**
     * Create a new VSource from a VBlob, usually received from a Vips operation
     */
    public static VSource newFromBlob(Arena arena, VBlob blob) throws VipsError {
        var pointer = VipsHelper.source_new_from_blob(arena, blob.address);
        return new VSource(arena, pointer);
    }

    /**
     * Create a new VSource directly from some bytes
     * Note that this makes a full copy of the data, which is inefficient - prefer {@link VImage#newFromFile(Arena, String, VipsOption...)}
     * and friends
     */
    public static VSource newFromBytes(Arena arena, byte[] bytes) throws VipsError {
        var blob = VBlob.newFromBytes(arena, bytes);
        return newFromBlob(arena, blob);
    }

    public static VSource newFromOptions(Arena arena, String options) throws VipsError {
        var pointer = VipsHelper.source_new_from_options(arena, options);
        return new VSource(arena, pointer);
    }

    /**
     * Creates a new VSource from a Java {@link InputStream}
     * The provided InputStream is coupled to the arena's lifetime, and closed when its scope ends
     * Note that you can read an image directly from an InputStream using {@link VImage#newFromStream(Arena, InputStream, VipsOption...)}
     * This stream does not support seeking, because InputStream does not support it, so cannot be maximally
     * efficient - but it is still likely more efficient than taking a full intermediate copy of bytes
     */
    public static VSource newFromInputStream(Arena arena, InputStream stream) throws VipsError {
        VCustomSource.ReadCallback readCallback = (dataPointer, length) -> {
            if (length < 0) {
                throw new VipsError("invalid length to read provided: " + length);
            }
            // bytebuffer only supports reading int max bytes at a time
            var clippedLength = (int) Math.min(length, Integer.MAX_VALUE);
            byte[] bytes;
            try {
                bytes = stream.readNBytes(clippedLength);
            } catch (IOException e) {
                throw new VipsError("failed to read bytes from stream", e);
            }
            var buffer = dataPointer.asSlice(0, clippedLength).asByteBuffer();
            buffer.put(bytes);
            return bytes.length;
        };
        var source = new VCustomSource(arena, readCallback);
        // attempt to close stream when arena scope ends, in case users have not already done so
        source.address.reinterpret(arena, (_) -> {
            try {
                stream.close();
            } catch (IOException e) {
                // deliberately ignored
            }
        });
        return source;
    }
}
