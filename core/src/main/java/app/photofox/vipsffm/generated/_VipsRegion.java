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
 * struct _VipsRegion {
 *     VipsObject parent_object;
 *     VipsImage *im;
 *     VipsRect valid;
 *     RegionType type;
 *     VipsPel *data;
 *     int bpl;
 *     void *seq;
 *     GThread *thread;
 *     VipsWindow *window;
 *     VipsBuffer *buffer;
 *     gboolean invalid;
 * }
 * }
 */
public class _VipsRegion {

    _VipsRegion() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
        _VipsObject.layout().withName("parent_object"),
        VipsRaw.C_POINTER.withName("im"),
        _VipsRect.layout().withName("valid"),
        VipsRaw.C_INT.withName("type"),
        MemoryLayout.paddingLayout(4),
        VipsRaw.C_POINTER.withName("data"),
        VipsRaw.C_INT.withName("bpl"),
        MemoryLayout.paddingLayout(4),
        VipsRaw.C_POINTER.withName("seq"),
        VipsRaw.C_POINTER.withName("thread"),
        VipsRaw.C_POINTER.withName("window"),
        VipsRaw.C_POINTER.withName("buffer"),
        VipsRaw.C_INT.withName("invalid"),
        MemoryLayout.paddingLayout(4)
    ).withName("_VipsRegion");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final GroupLayout parent_object$LAYOUT = (GroupLayout)$LAYOUT.select(groupElement("parent_object"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * VipsObject parent_object
     * }
     */
    public static final GroupLayout parent_object$layout() {
        return parent_object$LAYOUT;
    }

    private static final long parent_object$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * VipsObject parent_object
     * }
     */
    public static final long parent_object$offset() {
        return parent_object$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * VipsObject parent_object
     * }
     */
    public static MemorySegment parent_object(MemorySegment struct) {
        return struct.asSlice(parent_object$OFFSET, parent_object$LAYOUT.byteSize());
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * VipsObject parent_object
     * }
     */
    public static void parent_object(MemorySegment struct, MemorySegment fieldValue) {
        MemorySegment.copy(fieldValue, 0L, struct, parent_object$OFFSET, parent_object$LAYOUT.byteSize());
    }

    private static final AddressLayout im$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("im"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * VipsImage *im
     * }
     */
    public static final AddressLayout im$layout() {
        return im$LAYOUT;
    }

    private static final long im$OFFSET = 80;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * VipsImage *im
     * }
     */
    public static final long im$offset() {
        return im$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * VipsImage *im
     * }
     */
    public static MemorySegment im(MemorySegment struct) {
        return struct.get(im$LAYOUT, im$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * VipsImage *im
     * }
     */
    public static void im(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(im$LAYOUT, im$OFFSET, fieldValue);
    }

    private static final GroupLayout valid$LAYOUT = (GroupLayout)$LAYOUT.select(groupElement("valid"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * VipsRect valid
     * }
     */
    public static final GroupLayout valid$layout() {
        return valid$LAYOUT;
    }

    private static final long valid$OFFSET = 88;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * VipsRect valid
     * }
     */
    public static final long valid$offset() {
        return valid$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * VipsRect valid
     * }
     */
    public static MemorySegment valid(MemorySegment struct) {
        return struct.asSlice(valid$OFFSET, valid$LAYOUT.byteSize());
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * VipsRect valid
     * }
     */
    public static void valid(MemorySegment struct, MemorySegment fieldValue) {
        MemorySegment.copy(fieldValue, 0L, struct, valid$OFFSET, valid$LAYOUT.byteSize());
    }

    private static final OfInt type$LAYOUT = (OfInt)$LAYOUT.select(groupElement("type"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * RegionType type
     * }
     */
    public static final OfInt type$layout() {
        return type$LAYOUT;
    }

    private static final long type$OFFSET = 104;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * RegionType type
     * }
     */
    public static final long type$offset() {
        return type$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * RegionType type
     * }
     */
    public static int type(MemorySegment struct) {
        return struct.get(type$LAYOUT, type$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * RegionType type
     * }
     */
    public static void type(MemorySegment struct, int fieldValue) {
        struct.set(type$LAYOUT, type$OFFSET, fieldValue);
    }

    private static final AddressLayout data$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("data"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * VipsPel *data
     * }
     */
    public static final AddressLayout data$layout() {
        return data$LAYOUT;
    }

    private static final long data$OFFSET = 112;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * VipsPel *data
     * }
     */
    public static final long data$offset() {
        return data$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * VipsPel *data
     * }
     */
    public static MemorySegment data(MemorySegment struct) {
        return struct.get(data$LAYOUT, data$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * VipsPel *data
     * }
     */
    public static void data(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(data$LAYOUT, data$OFFSET, fieldValue);
    }

    private static final OfInt bpl$LAYOUT = (OfInt)$LAYOUT.select(groupElement("bpl"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int bpl
     * }
     */
    public static final OfInt bpl$layout() {
        return bpl$LAYOUT;
    }

    private static final long bpl$OFFSET = 120;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int bpl
     * }
     */
    public static final long bpl$offset() {
        return bpl$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int bpl
     * }
     */
    public static int bpl(MemorySegment struct) {
        return struct.get(bpl$LAYOUT, bpl$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int bpl
     * }
     */
    public static void bpl(MemorySegment struct, int fieldValue) {
        struct.set(bpl$LAYOUT, bpl$OFFSET, fieldValue);
    }

    private static final AddressLayout seq$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("seq"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * void *seq
     * }
     */
    public static final AddressLayout seq$layout() {
        return seq$LAYOUT;
    }

    private static final long seq$OFFSET = 128;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * void *seq
     * }
     */
    public static final long seq$offset() {
        return seq$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * void *seq
     * }
     */
    public static MemorySegment seq(MemorySegment struct) {
        return struct.get(seq$LAYOUT, seq$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * void *seq
     * }
     */
    public static void seq(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(seq$LAYOUT, seq$OFFSET, fieldValue);
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

    private static final long thread$OFFSET = 136;

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

    private static final AddressLayout window$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("window"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * VipsWindow *window
     * }
     */
    public static final AddressLayout window$layout() {
        return window$LAYOUT;
    }

    private static final long window$OFFSET = 144;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * VipsWindow *window
     * }
     */
    public static final long window$offset() {
        return window$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * VipsWindow *window
     * }
     */
    public static MemorySegment window(MemorySegment struct) {
        return struct.get(window$LAYOUT, window$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * VipsWindow *window
     * }
     */
    public static void window(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(window$LAYOUT, window$OFFSET, fieldValue);
    }

    private static final AddressLayout buffer$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("buffer"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * VipsBuffer *buffer
     * }
     */
    public static final AddressLayout buffer$layout() {
        return buffer$LAYOUT;
    }

    private static final long buffer$OFFSET = 152;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * VipsBuffer *buffer
     * }
     */
    public static final long buffer$offset() {
        return buffer$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * VipsBuffer *buffer
     * }
     */
    public static MemorySegment buffer(MemorySegment struct) {
        return struct.get(buffer$LAYOUT, buffer$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * VipsBuffer *buffer
     * }
     */
    public static void buffer(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(buffer$LAYOUT, buffer$OFFSET, fieldValue);
    }

    private static final OfInt invalid$LAYOUT = (OfInt)$LAYOUT.select(groupElement("invalid"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * gboolean invalid
     * }
     */
    public static final OfInt invalid$layout() {
        return invalid$LAYOUT;
    }

    private static final long invalid$OFFSET = 160;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * gboolean invalid
     * }
     */
    public static final long invalid$offset() {
        return invalid$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * gboolean invalid
     * }
     */
    public static int invalid(MemorySegment struct) {
        return struct.get(invalid$LAYOUT, invalid$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * gboolean invalid
     * }
     */
    public static void invalid(MemorySegment struct, int fieldValue) {
        struct.set(invalid$LAYOUT, invalid$OFFSET, fieldValue);
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
