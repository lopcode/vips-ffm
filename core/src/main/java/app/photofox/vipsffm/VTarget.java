package app.photofox.vipsffm;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

/**
 * Represents a VipsTarget, boxed to avoid exposing its raw MemorySegment
 */
public class VTarget {

    final MemorySegment address;

    VTarget(MemorySegment address) {
        this.address = address;
    }

    /**
     * Gets the raw [MemorySegment] (C pointer) for this target
     * Usage of the memory address is strongly discouraged, but it is available if some functionality is missing and you need to use it with [VipsHelper]
     */
    public MemorySegment getUnsafeAddress() {
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
