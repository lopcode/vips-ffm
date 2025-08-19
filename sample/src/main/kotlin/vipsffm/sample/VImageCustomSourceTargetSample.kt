package vipsffm.sample

import app.photofox.vipsffm.VCustomSource
import app.photofox.vipsffm.VCustomTarget
import app.photofox.vipsffm.VImage
import vipsffm.RunnableSample
import vipsffm.SampleHelper
import java.io.IOException
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment
import java.nio.channels.FileChannel
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import java.util.function.Consumer

/**
 * Sample showing loading an image from a custom source and writing it to a custom source.
 *
 * Implemented using `FileChannel` for reading and writing, which is of little practical use but
 * demonstrates the use of custom sources and targets quite well.
 *
 * See https://www.libvips.org/2019/11/29/True-streaming-for-libvips.html
 */
object VImageCustomSourceTargetSample: RunnableSample {
    internal class FileChannelSource {
        val input: FileChannel

        constructor(path: Path) {
            this.input = FileChannel.open(path, StandardOpenOption.READ)
        }

        fun read(buffer: MemorySegment, length: Long): Long {
            val byteBuffer = buffer.asSlice(0, length).asByteBuffer()
            return input.read(byteBuffer).toLong()
        }

        fun seek(offset: Long, whence: VCustomSource.SeekWhence): Long {
            return when (whence) {
                VCustomSource.SeekWhence.SEEK_SET -> input.position(offset)
                VCustomSource.SeekWhence.SEEK_CUR -> input.position(input.position() + offset)
                VCustomSource.SeekWhence.SEEK_END -> input.position(input.size() + offset)
            }.position()
        }

        fun close() {
            input.close()
        }
    }

    class FileChannelTarget {
        private val output: FileChannel

        constructor(path: Path) {
            this.output = FileChannel.open(path, StandardOpenOption.WRITE, StandardOpenOption.CREATE)
        }

        fun write(buffer: MemorySegment): Long {
            return output.write(buffer.asByteBuffer()).toLong()
        }

        fun end(): Int {
            output.close()
            return 0
        }
    }

    override fun run(arena: Arena, workingDirectory: Path): Result<Unit> {
        val outputPath = workingDirectory.resolve("fox_copy.jpg")

        // First, convert the fox image to a TIFF file, as TIFF uses seeking on the input and
        // is a good format for testing our custom source implementation
        val inputPath = workingDirectory.resolve("fox_input.tif")
        VImage.newFromStream(arena, ClassLoader.getSystemResourceAsStream("sample_images/fox.jpg"))
            .writeToFile(inputPath.toString())

        val src = FileChannelSource(inputPath)
        val vipsSrc = VCustomSource(arena, src::read, src::seek)

        val target = FileChannelTarget(outputPath)
        val vipsTarget = VCustomTarget(arena, target::write, target::end)

        VImage.thumbnailSource(arena, vipsSrc, 800)
            .writeToTarget(vipsTarget, ".jpg")

        return SampleHelper.validate(
            outputPath,
            expectedSizeBoundsKb = 20..100L
        )
    }
}