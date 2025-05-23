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
        var blobAddress = VipsRaw.vips_blob_new(MemorySegment.NULL, offHeapSegment, offHeapSegment.byteSize());
        if (!VipsValidation.isValidPointer(blobAddress)) {
            throw new VipsError("invalid blob returned from libvips");
        }
        blobAddress.reinterpret(arena, VipsRaw::vips_area_unref);
        return new VBlob(arena, blobAddress);
    }

    /// @deprecated Replaced by [#getUnsafeStructAddress()]
    @Deprecated(since = "0.5.10", forRemoval = true)
    public MemorySegment getUnsafeAddress() throws VipsError {
        return this.getUnsafeStructAddress();
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

    /// Not recommended for use, use [#asByteBuffer()] instead
    ///
    /// Gets the raw [MemorySegment] (C pointer) for the data in this blob
    ///
    /// Sliced to the length of the data, which isn't always null terminated
    public MemorySegment getUnsafeDataAddress() throws VipsError {
        var lengthOutPointer = arena.allocate(C_LONG);
        var dataPointer = VipsRaw.vips_area_get_data(
            this.address,
            lengthOutPointer,
            MemorySegment.NULL,
            MemorySegment.NULL,
            MemorySegment.NULL
        );
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

    /// @deprecated Replaced by [#asArenaScopedByteBuffer()]
    @Deprecated(since = "0.5.10", forRemoval = true)
    public ByteBuffer asByteBuffer() {
        return this.asArenaScopedByteBuffer();
    }

    /// ByteBuffer representation of the data in this blob
    ///
    /// Mapped to native memory via DirectByteBuffer, hence does not make a copy, so the data has the
    /// same data lifetime as [#arena]
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
}
