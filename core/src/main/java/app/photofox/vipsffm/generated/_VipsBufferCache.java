// Generated by jextract

package app.photofox.vipsffm.generated;

import java.lang.invoke.*;
import java.lang.foreign.*;
import java.nio.ByteOrder;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.PathElement.*;

/**
 * {@snippet lang=c :
 * struct _VipsBufferCache {
 *     GSList *buffers;
 *     GThread *thread;
 *     struct _VipsImage *im;
 *     VipsBufferThread *buffer_thread;
 *     GSList *reserve;
 *     int n_reserve;
 * }
 * }
 */
public class _VipsBufferCache {

    _VipsBufferCache() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
        VipsRaw.C_POINTER.withName("buffers"),
        VipsRaw.C_POINTER.withName("thread"),
        VipsRaw.C_POINTER.withName("im"),
        VipsRaw.C_POINTER.withName("buffer_thread"),
        VipsRaw.C_POINTER.withName("reserve"),
        VipsRaw.C_INT.withName("n_reserve"),
        MemoryLayout.paddingLayout(4)
    ).withName("_VipsBufferCache");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final AddressLayout buffers$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("buffers"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * GSList *buffers
     * }
     */
    public static final AddressLayout buffers$layout() {
        return buffers$LAYOUT;
    }

    private static final long buffers$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * GSList *buffers
     * }
     */
    public static final long buffers$offset() {
        return buffers$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * GSList *buffers
     * }
     */
    public static MemorySegment buffers(MemorySegment struct) {
        return struct.get(buffers$LAYOUT, buffers$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * GSList *buffers
     * }
     */
    public static void buffers(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(buffers$LAYOUT, buffers$OFFSET, fieldValue);
    }

    private static final AddressLayout thread$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("thread"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * GThread *thread
     * }
     */
    public static final AddressLayout thread$layout() {
        return thread$LAYOUT;
    }

    private static final long thread$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * GThread *thread
     * }
     */
    public static final long thread$offset() {
        return thread$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * GThread *thread
     * }
     */
    public static MemorySegment thread(MemorySegment struct) {
        return struct.get(thread$LAYOUT, thread$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * GThread *thread
     * }
     */
    public static void thread(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(thread$LAYOUT, thread$OFFSET, fieldValue);
    }

    private static final AddressLayout im$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("im"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * struct _VipsImage *im
     * }
     */
    public static final AddressLayout im$layout() {
        return im$LAYOUT;
    }

    private static final long im$OFFSET = 16;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * struct _VipsImage *im
     * }
     */
    public static final long im$offset() {
        return im$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * struct _VipsImage *im
     * }
     */
    public static MemorySegment im(MemorySegment struct) {
        return struct.get(im$LAYOUT, im$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * struct _VipsImage *im
     * }
     */
    public static void im(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(im$LAYOUT, im$OFFSET, fieldValue);
    }

    private static final AddressLayout buffer_thread$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("buffer_thread"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * VipsBufferThread *buffer_thread
     * }
     */
    public static final AddressLayout buffer_thread$layout() {
        return buffer_thread$LAYOUT;
    }

    private static final long buffer_thread$OFFSET = 24;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * VipsBufferThread *buffer_thread
     * }
     */
    public static final long buffer_thread$offset() {
        return buffer_thread$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * VipsBufferThread *buffer_thread
     * }
     */
    public static MemorySegment buffer_thread(MemorySegment struct) {
        return struct.get(buffer_thread$LAYOUT, buffer_thread$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * VipsBufferThread *buffer_thread
     * }
     */
    public static void buffer_thread(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(buffer_thread$LAYOUT, buffer_thread$OFFSET, fieldValue);
    }

    private static final AddressLayout reserve$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("reserve"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * GSList *reserve
     * }
     */
    public static final AddressLayout reserve$layout() {
        return reserve$LAYOUT;
    }

    private static final long reserve$OFFSET = 32;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * GSList *reserve
     * }
     */
    public static final long reserve$offset() {
        return reserve$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * GSList *reserve
     * }
     */
    public static MemorySegment reserve(MemorySegment struct) {
        return struct.get(reserve$LAYOUT, reserve$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * GSList *reserve
     * }
     */
    public static void reserve(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(reserve$LAYOUT, reserve$OFFSET, fieldValue);
    }

    private static final OfInt n_reserve$LAYOUT = (OfInt)$LAYOUT.select(groupElement("n_reserve"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int n_reserve
     * }
     */
    public static final OfInt n_reserve$layout() {
        return n_reserve$LAYOUT;
    }

    private static final long n_reserve$OFFSET = 40;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int n_reserve
     * }
     */
    public static final long n_reserve$offset() {
        return n_reserve$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int n_reserve
     * }
     */
    public static int n_reserve(MemorySegment struct) {
        return struct.get(n_reserve$LAYOUT, n_reserve$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int n_reserve
     * }
     */
    public static void n_reserve(MemorySegment struct, int fieldValue) {
        struct.set(n_reserve$LAYOUT, n_reserve$OFFSET, fieldValue);
    }

    /**
     * Obtains a slice of {@code arrayParam} which selects the array element at {@code index}.
     * The returned segment has address {@code arrayParam.address() + index * layout().byteSize()}
     */
    public static MemorySegment asSlice(MemorySegment array, long index) {
        return array.asSlice(layout().byteSize() * index);
    }

    /**
     * The size (in bytes) of this struct
     */
    public static long sizeof() { return layout().byteSize(); }

    /**
     * Allocate a segment of size {@code layout().byteSize()} using {@code allocator}
     */
    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout());
    }

    /**
     * Allocate an array of size {@code elementCount} using {@code allocator}.
     * The returned segment has size {@code elementCount * layout().byteSize()}.
     */
    public static MemorySegment allocateArray(long elementCount, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(elementCount, layout()));
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction} (if any).
     * The returned segment has size {@code layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, Arena arena, Consumer<MemorySegment> cleanup) {
        return reinterpret(addr, 1, arena, cleanup);
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction} (if any).
     * The returned segment has size {@code elementCount * layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, long elementCount, Arena arena, Consumer<MemorySegment> cleanup) {
        return addr.reinterpret(layout().byteSize() * elementCount, arena, cleanup);
    }
}
