package app.photofox.vipsffm;

import app.photofox.vipsffm.jextract.VipsRaw;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VBlobArenaTest {

    @Test
    void scopedBufferExpiresWithArena() {
        ByteBuffer buffer;
        try (var arena = Arena.ofConfined()) {
            var blob = VBlob.newFromBytes(arena, new byte[]{1, 2, 3});
            buffer = blob.asArenaScopedByteBuffer();
            assertTrue(buffer.isDirect());
            assertEquals(3, buffer.remaining());
            assertEquals(1, buffer.get(0));
        }
        assertExpired(buffer);
    }

    @Test
    void dataSegmentUsesBlobArena() {
        try (var arena = Arena.ofConfined()) {
            var blob = VBlob.newFromBytes(arena, new byte[]{1, 2, 3});
            var data = blob.getUnsafeDataAddress();
            assertEquals(3, data.byteSize());
            assertEquals(arena.scope(), data.scope());
        }
    }

    @Test
    void confinedBufferRetainsThreadConfinement() {
        try (var arena = Arena.ofConfined()) {
            var buffer = VBlob.newFromBytes(arena, new byte[]{1}).asArenaScopedByteBuffer();
            var otherThread = new Thread(() -> {});
            assertFalse(MemorySegment.ofBuffer(buffer).isAccessibleBy(otherThread));
        }
    }

    @Test
    void sharedBufferCanBeReadByAnotherThreadUntilArenaCloses() throws InterruptedException {
        ByteBuffer buffer;
        try (var arena = Arena.ofShared()) {
            buffer = VBlob.newFromBytes(arena, new byte[]{42}).asArenaScopedByteBuffer();
            var value = new AtomicInteger();
            var failure = new AtomicReference<Throwable>();
            var thread = new Thread(() -> {
                try {
                    value.set(buffer.get(0));
                } catch (Throwable error) {
                    failure.set(error);
                }
            });
            thread.start();
            thread.join();
            assertNull(failure.get());
            assertEquals(42, value.get());
        }
        assertExpired(buffer);
    }

    @Test
    void copiesRemainUsableAfterArenaCloses() {
        byte[] bytes;
        ByteBuffer clone;
        try (var arena = Arena.ofConfined()) {
            var blob = VBlob.newFromBytes(arena, new byte[]{1, 2, 3});
            bytes = blob.getBytes();
            clone = blob.asClonedByteBuffer();
        }
        assertArrayEquals(new byte[]{1, 2, 3}, bytes);
        assertEquals(ByteBuffer.wrap(bytes), clone);
    }

    @Test
    void encodedImageBufferAlsoExpiresWithArena() {
        ByteBuffer buffer;
        try (var arena = Arena.ofConfined()) {
            var png = VImage.black(arena, 16, 16).pngsaveBuffer();
            buffer = png.asArenaScopedByteBuffer();
            assertEquals((byte) 137, buffer.get(0));
        }
        assertExpired(buffer);
    }

    @Test
    void imageMetadataBlobExpiresWithArena() {
        ByteBuffer buffer;
        try (var arena = Arena.ofConfined()) {
            var image = VImage.black(arena, 4, 4)
                .set("test-blob", VBlob.newFromBytes(arena, new byte[]{7, 8, 9}));
            buffer = image.getBlob("test-blob").asArenaScopedByteBuffer();
            assertEquals(3, buffer.remaining());
            assertEquals(9, buffer.get(2));
        }
        assertExpired(buffer);
    }

    @Test
    void helperBlobGetIsBoundToArena() {
        MemorySegment data;
        try (var arena = Arena.ofConfined()) {
            var blob = VBlob.newFromBytes(arena, new byte[]{4, 5, 6});
            var lengthOut = arena.allocate(VipsRaw.C_LONG);
            data = VipsHelper.blob_get(arena, blob.getUnsafeStructAddress(), lengthOut);
            assertEquals(arena.scope(), data.scope());
            assertEquals(3, lengthOut.get(VipsRaw.C_LONG, 0));
            assertArrayEquals(new byte[]{4, 5, 6}, data.reinterpret(3).toArray(ValueLayout.JAVA_BYTE));
        }
        assertFalse(data.scope().isAlive());
    }

    @Test
    void helperImageGetDataIsBoundToArena() {
        MemorySegment data;
        try (var arena = Arena.ofConfined()) {
            var image = VImage.black(arena, 2, 2);
            data = VipsHelper.image_get_data(arena, image.getUnsafeStructAddress());
            assertEquals(arena.scope(), data.scope());
            assertEquals(0, data.reinterpret(4).get(ValueLayout.JAVA_BYTE, 0));
        }
        assertFalse(data.scope().isAlive());
    }

    private static void assertExpired(ByteBuffer buffer) {
        // Check metadata first: the unpatched implementation must never read freed memory.
        assertFalse(MemorySegment.ofBuffer(buffer).scope().isAlive());
        assertThrows(IllegalStateException.class, () -> buffer.get(0));
    }
}
