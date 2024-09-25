package app.photofox.vipsffm;

import app.photofox.vipsffm.jextract.VipsArea;
import app.photofox.vipsffm.jextract.VipsRaw;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.ByteBuffer;

import static app.photofox.vipsffm.jextract.VipsRaw.C_LONG;

/**
 * Represents a VipsBlob, boxed to avoid exposing its raw MemorySegment
 */
public final class VBlob {

    private final Arena arena;
    final MemorySegment address;

    VBlob(
        Arena arena,
        MemorySegment address
    ) throws VipsError {
        if (!VipsValidation.isValidPointer(address)) {
            throw new VipsError("invalid pointer used for creation");
        }
        this.arena = arena;
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

    public long byteSize() {
        return VipsArea.length(this.address);
    }

    public ByteBuffer asByteBuffer() {
        var lengthOutPointer = arena.allocate(C_LONG);
        var dataPointer = VipsRaw.vips_area_get_data(this.address, lengthOutPointer, MemorySegment.NULL, MemorySegment.NULL, MemorySegment.NULL);
        var length = lengthOutPointer.get(C_LONG, 0);
        if (length < 0) {
            throw new VipsError("unexpected length of vblob data " + length);
        }
        return dataPointer.asSlice(0, length).asByteBuffer();
    }
}
