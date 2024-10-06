package app.photofox.vipsffm;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

/**
 * Represents a VipsSource, boxed to avoid exposing its raw MemorySegment
 */
public final class VSource {

    final MemorySegment address;

    VSource(MemorySegment address) throws VipsError {
        if (!VipsValidation.isValidPointer(address)) {
            throw new VipsError("invalid pointer used for creation");
        }
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
        return new VSource(pointer);
    }

    /**
     * Create a new VSource from a file path
     */
    public static VSource newFromFile(Arena arena, String filename) throws VipsError {
        var pointer = VipsHelper.source_new_from_file(arena, filename);
        return new VSource(pointer);
    }

    /**
     * Create a new VSource from a VBlob, usually received from a Vips operation
     */
    public static VSource newFromBlob(Arena arena, VBlob blob) throws VipsError {
        var pointer = VipsHelper.source_new_from_blob(arena, blob.address);
        return new VSource(pointer);
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
        return new VSource(pointer);
    }
}
