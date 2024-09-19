package app.photofox.vipsffm;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Objects;

public class VInterpolate {

    MemorySegment address;

    VInterpolate(MemorySegment address) {
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

    public static VInterpolate newFromName(Arena arena, String name) throws VipsError {
        var address = VipsHelper.interpolate_new(arena, name);
        return new VInterpolate(address);
    }
}
