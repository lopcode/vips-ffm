package app.photofox.vipsffm;

import app.photofox.vipsffm.jextract.VipsArea;
import app.photofox.vipsffm.jextract.VipsRaw;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;

import static app.photofox.vipsffm.jextract.VipsRaw.C_LONG;

/// Represents a VipsBlob, which is backed by a contiguous area of off-heap memory
///
/// Its constructor is package private to prevent leaking MemorySegments in to the vips-ffm API
///
/// Use its static helper methods to create new blobs
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

    /// Creates a new VBlob from a fixed array of bytes
    ///
    /// This must copy the data - it's generally more efficient to use [VImage#newFromFile], [VImage#newFromSource], and friends
    ///
    /// @param arena An arena constraining the lifetime of this blob
    /// @param bytes The bytes to wrap
    public static VBlob newFromBytes(Arena arena, byte[] bytes) throws VipsError {
        var offHeapSegment = arena.allocateFrom(ValueLayout.JAVA_BYTE, bytes);
        return newFromDataSegment(arena, offHeapSegment);
    }

    static VBlob newFromDataSegment(Arena arena, MemorySegment dataSegment) throws VipsError {
        var blobAddress = VipsRaw.vips_blob_new(MemorySegment.NULL, dataSegment, dataSegment.byteSize());
        if (!VipsValidation.isValidPointer(blobAddress)) {
            throw new VipsError("invalid blob returned from libvips");
        }
        blobAddress.reinterpret(arena, VipsRaw::vips_area_unref);
        return new VBlob(arena, blobAddress);
    }

    /// Gets the raw [MemorySegment] (C pointer) for this VipsBlob struct
    ///
    /// You might want the data address instead [#getUnsafeDataAddress()]
    ///
    /// The memory address' lifetime is bound to the scope of the [#arena]
    ///
    /// Usage of the memory address is strongly discouraged, but it is available if some functionality is missing and you
    /// need to use it with [VipsHelper]
    public MemorySegment getUnsafeStructAddress() throws VipsError {
        return this.address;
    }

    /// Not recommended for use, use [#asArenaScopedByteBuffer()] or [#asClonedByteBuffer()] instead
    ///
    /// Gets the raw [MemorySegment] (C pointer) for the data in this blob
    ///
    /// Sliced to the length of the data, which isn't always null terminated
    public MemorySegment getUnsafeDataAddress() throws VipsError {
        var lengthOutPointer = arena.allocate(C_LONG);
        var dataPointer = VipsRaw.vips_blob_get(
            this.address,
            lengthOutPointer
        );
        if (!VipsValidation.isValidPointer(dataPointer)) {
            throw new VipsError("unexpected vblob bad data pointer");
        }
        var length = lengthOutPointer.get(C_LONG, 0);
        if (length < 0) {
            throw new VipsError("unexpected length of vblob data " + length);
        }
        return dataPointer.asSlice(0, length);
    }

    /// Size of the data in this blob
    public long byteSize() {
        return VipsArea.length(this.address);
    }

    /// ByteBuffer representation of the data in this blob
    ///
    /// Mapped to native memory via DirectByteBuffer, hence does not make a copy, so the data has the
    /// same data lifetime as [#arena]
    ///
    /// Note that because this is backed by native memory, you cannot use the [ByteBuffer#array()]
    /// method on the resulting buffer. Use [#asClonedByteBuffer()] or [#getBytes()] if you're
    /// looking for a full copy of the data.
    public ByteBuffer asArenaScopedByteBuffer() {
        return this.getUnsafeDataAddress().asByteBuffer();
    }

    /// ByteBuffer representation of the data in this blob
    ///
    /// A full copy of the data is taken, so that its contents are not coupled to the scope of [#arena]
    public ByteBuffer asClonedByteBuffer() {
        var buffer = this.asArenaScopedByteBuffer();
        if (buffer.capacity() == 0) {
            return ByteBuffer.allocate(0);
        }
        buffer.rewind();
        var newBuffer = ByteBuffer.allocate(buffer.capacity());
        newBuffer.put(buffer);
        newBuffer.rewind();
        return newBuffer;
    }

    /// byte[] representation of the data in this VipsBlob
    ///
    /// Useful if you're working with metadata stored on an image, like an ICC profile
    ///
    /// Note that a full copy of the data is taken
    public byte[] getBytes() {
        return this.getUnsafeDataAddress().toArray(ValueLayout.JAVA_BYTE);
    }
}
