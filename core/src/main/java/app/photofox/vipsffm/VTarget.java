package app.photofox.vipsffm;

import app.photofox.vipsffm.jextract.VipsTarget;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

/**
 * Represents a VipsTarget
 * Its constructor is package private to prevent leaking MemorySegments in to the vips-ffm API
 * Use its static helper methods to create new targets
 */
public sealed class VTarget permits VCustomTarget {

    final Arena arena;
    final MemorySegment address;

    VTarget(Arena arena, MemorySegment address) throws VipsError {
        if (!VipsValidation.isValidPointer(address)) {
            throw new VipsError("invalid pointer used for creation");
        }
        this.arena = arena;
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

    /**
     * Create a new target pointed at a file descriptor
     * This target can be used with (for example) {@link VImage#writeToTarget(VTarget, String, VipsOption...)}
     */
    public static VTarget newToDescriptor(Arena arena, int descriptor) throws VipsError {
        var pointer = VipsHelper.target_new_to_descriptor(arena, descriptor);
        return new VTarget(arena, pointer);
    }

    /**
     * Create a new target pointed at an output file
     * This target can be used with (for example) {@link VImage#writeToTarget(VTarget, String, VipsOption...)}
     */
    public static VTarget newToFile(Arena arena, String filename) throws VipsError {
        var pointer = VipsHelper.target_new_to_file(arena, filename);
        return new VTarget(arena, pointer);
    }

    /**
     * Create a new memory-backed VipsTarget
     * This target can be used with (for example) {@link VImage#writeToTarget(VTarget, String, VipsOption...)}
     * After writing to this target, you can also retrieve the backing {@link VBlob} with {@link #getBlob()}
     */
    public static VTarget newToMemory(Arena arena) throws VipsError {
        var pointer = VipsHelper.target_new_to_memory(arena);
        return new VTarget(arena, pointer);
    }

    /**
     * Only valid for memory-backed targets (eg via {@link #newToMemory(Arena)})
     * Returns the contents of the backing VBlob
     */
    public VBlob getBlob() throws VipsError {
        var blob = VipsTarget.blob(this.address);
        return new VBlob(arena, blob);
    }

    /**
     * Create a new VipsTarget pointed at a Java {@link OutputStream}
     * The provided OutputStream is coupled to the arena's lifetime, and closed when its scope ends
     * Note that you can directly write an image to an OutputStream using {@link VImage#writeToStream(OutputStream, String, VipsOption...)}
     * This target can also be used with (for example) {@link VImage#writeToTarget(VTarget, String, VipsOption...)}
     */
    public static VTarget newFromOutputStream(
        Arena arena,
        OutputStream stream
    ) throws VipsError {
        VCustomTarget.WriteCallback writeCallback = (dataPointer) -> {
            // we must take a copy in byte[] form for OutputStream
            var bytes = dataPointer.toArray(ValueLayout.JAVA_BYTE);
            if (bytes.length == 0) {
                return 0;
            }
            try {
                stream.write(bytes);
            } catch (IOException e) {
                throw new VipsError("failed to write bytes to stream", e);
            }
            return bytes.length;
        };
        VCustomTarget.EndCallback endCallback = () -> {
            try {
                stream.flush();
                stream.close();
            } catch (IOException e) {
                // deliberately ignore
                return -1;
            }
            return 0;
        };
        var target = new VCustomTarget(arena, writeCallback, endCallback);
        // attempt to close stream when arena scope ends, in case users have not already done so
        target.address.reinterpret(arena, (_) -> {
            try {
                stream.close();
            } catch (IOException e) {
                // deliberately ignored
            }
        });
        return target;
    }
}
