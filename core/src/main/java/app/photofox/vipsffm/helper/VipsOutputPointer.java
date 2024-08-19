package app.photofox.vipsffm.helper;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

// models output pointers in vips functions (eg VipsImage **out)
public class VipsOutputPointer {

    private final MemorySegment outPointer;
    private MemorySegment dereferencedPointer;

    public VipsOutputPointer(Arena arena) {
        this.outPointer = arena.allocate(ValueLayout.ADDRESS);
    }

    // internal - do not use
    public MemorySegment pointerOrNull$internal() {
        return this.outPointer;
    }

    // internal - do not use
    public void setReinterpretedPointer$internal(MemorySegment reinterpretedPointer) {
        this.dereferencedPointer = reinterpretedPointer;
    }

    public MemorySegment dereferencedOrNull() {
        if (!VipsValidation.isValidPointer(this.dereferencedPointer)) {
            return null;
        }
        return this.dereferencedPointer;
    }

    public MemorySegment dereferencedOrThrow() throws VipsError {
        var dereferencedPointer = this.dereferencedOrNull();
        if (dereferencedPointer == null) {
            throw new VipsError("dereferenced output pointer unexpectedly null");
        }
        return dereferencedPointer;
    }
}
