package app.photofox.vipsffm;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
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

    private static void assertExpired(ByteBuffer buffer) {
        // Check metadata first: the unpatched implementation must never read freed memory.
        assertFalse(MemorySegment.ofBuffer(buffer).scope().isAlive());
        assertThrows(IllegalStateException.class, () -> buffer.get(0));
    }
}
