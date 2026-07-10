package vipsffm.sample;

import app.photofox.vipsffm.VCustomSource;
import app.photofox.vipsffm.VCustomTarget;
import app.photofox.vipsffm.VImage;
import vipsffm.RunnableSample;
import vipsffm.SampleHelper;

import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Sample showing loading an image from a custom source and writing it to a custom source.
 *
 * Implemented using `FileChannel` for reading and writing, which is of little practical use but
 * demonstrates the use of custom sources and targets quite well.
 *
 * See https://www.libvips.org/2019/11/29/True-streaming-for-libvips.html
 */
public class VImageCustomSourceTargetSample implements RunnableSample {

    static class FileChannelSource {
        private final FileChannel input;

        FileChannelSource(Path path) throws IOException {
            this.input = FileChannel.open(path, StandardOpenOption.READ);
        }

        long read(MemorySegment buffer, long length) {
            try {
                var byteBuffer = buffer.asSlice(0, length).asByteBuffer();
                return input.read(byteBuffer);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        long seek(long offset, VCustomSource.SeekWhence whence) {
            try {
                var position = switch (whence) {
                    case SEEK_SET -> input.position(offset);
                    case SEEK_CUR -> input.position(input.position() + offset);
                    case SEEK_END -> input.position(input.size() + offset);
                };
                return position.position();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class FileChannelTarget {
        private final FileChannel output;

        FileChannelTarget(Path path) throws IOException {
            this.output = FileChannel.open(path, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        }

        long write(MemorySegment buffer) {
            try {
                return output.write(buffer.asByteBuffer());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        int end() {
            try {
                output.close();
                return 0;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run(Arena arena, Path workingDirectory) throws Exception {
        var outputPath = workingDirectory.resolve("fox_copy.jpg");

        // First, convert the fox image to a TIFF file, as TIFF uses seeking on the input and
        // is a good format for testing our custom source implementation
        var inputPath = workingDirectory.resolve("fox_input.tif");
        VImage.newFromStream(arena, ClassLoader.getSystemResourceAsStream("sample_images/fox.jpg"))
            .writeToFile(inputPath.toString());

        var src = new FileChannelSource(inputPath);
        var vipsSrc = new VCustomSource(arena, src::read, src::seek);

        var target = new FileChannelTarget(outputPath);
        var vipsTarget = new VCustomTarget(arena, target::write, target::end);

        VImage.thumbnailSource(arena, vipsSrc, 800)
            .writeToTarget(vipsTarget, ".jpg");

        SampleHelper.validate(outputPath, 20L, 100L);
    }
}
