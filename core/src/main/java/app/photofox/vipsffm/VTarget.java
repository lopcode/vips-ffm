package app.photofox.vipsffm;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

/**
 * Represents a VipsTarget, boxed to avoid exposing its raw MemorySegment
 */
public class VTarget {

    final MemorySegment address;

    VTarget(MemorySegment address) throws VipsError {
        if (!VipsValidation.isValidPointer(address)) {
            throw new VipsError("invalid pointer used for creation");
        }
        this.address = address;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VTarget vTarget)) return false;

        return address.equals(vTarget.address);
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
     * Gets the raw {@link MemorySegment} (C pointer) for this VipsTarget struct
     * The memory address' lifetime is bound to the scope of the arena that created it
     * Usage of the memory address is strongly discouraged, but it is available if some functionality is missing, and
     * you need to use it with {@link VipsHelper}
     */
    public MemorySegment getUnsafeStructAddress() {
        return this.address;
    }

    public static VTarget newToDescriptor(Arena arena, int descriptor) {
        var pointer = VipsHelper.target_new_to_descriptor(arena, descriptor);
        return new VTarget(pointer);
    }

    public static VTarget newToFile(Arena arena, String filename) {
        var pointer = VipsHelper.target_new_to_file(arena, filename);
        return new VTarget(pointer);
    }

    public static VTarget newToMemory(Arena arena) {
        var pointer = VipsHelper.target_new_to_memory(arena);
        return new VTarget(pointer);
    }
}
