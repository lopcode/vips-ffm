package app.photofox.vipsffm;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Objects;

public class VInterpolate {

    MemorySegment address;

    VInterpolate(MemorySegment address) throws VipsError {
        if (!VipsValidation.isValidPointer(address)) {
            throw new VipsError("invalid pointer used for creation");
        }
        this.address = address;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VInterpolate that)) return false;

        return Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(address);
    }

    /**
     * Gets the raw {@link MemorySegment} (C pointer) for this VipsInterpolate struct
     * The memory address' lifetime is bound to the scope of the arena that created it
     * Usage of the memory address is strongly discouraged, but it is available if some functionality is missing, and
     * you need to use it with {@link VipsHelper}
     */
    public MemorySegment getUnsafeStructAddress() {
        return this.address;
    }

    public static VInterpolate newFromName(Arena arena, String name) throws VipsError {
        var address = VipsHelper.interpolate_new(arena, name);
        return new VInterpolate(address);
    }
}
