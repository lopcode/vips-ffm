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

    /**
     * Gets the raw [MemorySegment] (C pointer) for this source
     * Usage of the memory address is strongly discouraged, but it is available if some functionality is missing and you need to use it with [VipsHelper]
     */
    public MemorySegment getUnsafeAddress() {
        return this.address;
    }

    public static VSource newFromDescriptor(Arena arena, int descriptor) throws VipsError {
        var pointer = VipsHelper.source_new_from_descriptor(arena, descriptor);
        return new VSource(pointer);
    }

    public static VSource newFromFile(Arena arena, String filename) throws VipsError {
        var pointer = VipsHelper.source_new_from_file(arena, filename);
        return new VSource(pointer);
    }

    public static VSource newFromBlob(Arena arena, VBlob blob) throws VipsError {
        var pointer = VipsHelper.source_new_from_blob(arena, blob.address);
        return new VSource(pointer);
    }

    public static VSource newFromOptions(Arena arena, String options) throws VipsError {
        var pointer = VipsHelper.source_new_from_options(arena, options);
        return new VSource(pointer);
    }
}
