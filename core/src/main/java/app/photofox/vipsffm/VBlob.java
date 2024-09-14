package app.photofox.vipsffm;

import java.lang.foreign.MemorySegment;

/**
 * Represents a VipsBlob, boxed to avoid exposing its raw MemorySegment
 */
public final class VBlob {

    final MemorySegment address;

    VBlob(MemorySegment address) {
        this.address = address;
    }

    /**
     * Gets the raw [MemorySegment] (C pointer) for this blob
     * The memory address' lifetime is bound to the scope of the [arena]
     * Usage of the memory address is strongly discouraged, but it is available if some functionality is missing and you need to use it with [VipsHelper]
     */
    public MemorySegment getUnsafeAddress() {
        return this.address;
    }
}
