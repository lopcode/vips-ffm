package app.photofox.vipsffm;

import app.photofox.vipsffm.enums.VipsInteresting;
import com.criteo.vips.VipsImage;
import com.criteo.vips.enums.VipsImageFormat;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.lang.foreign.Arena;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class BenchmarkTests {

    @Test
    void runBenchmarks() throws Exception {
        var options = new OptionsBuilder()
            .include(this.getClass().getName() + ".*")
            .mode(Mode.AverageTime)
            .timeUnit(TimeUnit.MILLISECONDS)
            .warmupIterations(3)
            .measurementTime(TimeValue.seconds(1))
            .measurementIterations(10)
            .threads(1)
            .forks(1)
            .shouldFailOnError(true)
            .shouldDoGC(true)
            .build();

        new Runner(options).run();
    }

    @State(Scope.Thread)
    public static class BenchmarkState {

        VSource sourceImage;
        byte[] sourceImageBytes;
        Arena arena = Arena.ofConfined();

        @Setup(Level.Trial)
        public void init() throws Exception {
            Vips.init(false, true);
            VipsHelper.cache_set_max(0);

            var samplePath = "../sample/src/main/resources/sample_images/fox.jpg";
            sourceImage = VSource.newFromFile(
                arena,
                samplePath
            );
            sourceImageBytes = Files.readAllBytes(Path.of(samplePath));
        }

        @TearDown
        public void tearDown() {
            arena.close();
            Vips.shutdown();
        }
    }

    @Benchmark
    public void thumbnailOnly(BenchmarkState state) {
        Vips.run(arena -> {
            var target = VTarget.newToMemory(arena);
            var image = VImage.newFromSource(arena, state.sourceImage, "");
            image
                .thumbnailImage(400)
                .writeToTarget(target, ".jpg");
        });
    }

    @Benchmark
    public void frameBenchmarkUsingVipsFfm(BenchmarkState state) {
        Vips.run(arena -> {
            var target = VTarget.newToMemory(arena);
            var image = VImage.newFromSource(arena, state.sourceImage, "");
            var insertSize = 512;
            var paddingSize = 100;
            var finalImageSize = insertSize + paddingSize;
            var backgroundImage = VImage.newImage(arena)
                .black(finalImageSize, finalImageSize);
            var insertImage = image
                .thumbnailImage(
                    insertSize,
                    VipsOption.Int("height", insertSize),
                    VipsOption.Enum("crop", VipsInteresting.INTERESTING_CENTRE)
                );
            backgroundImage
                .insert(insertImage, paddingSize / 2, paddingSize / 2)
                .writeToTarget(target, ".jpg");
        });
    }

//    jvips doesn't support arm64 :(
//    @Benchmark
//    public void frameBenchmarkUsingJVips(BenchmarkState state) {
//        var image = new VipsImage(state.sourceImageBytes, state.sourceImageBytes.length);
//        var insertSize = 512;
//        var paddingSize = 100;
//        var finalImageSize = insertSize + paddingSize;
//        var backgroundImage = VipsImage.black(finalImageSize, finalImageSize);
//        image.thumbnailImage(insertSize, insertSize, false); // todo: how to crop?
//        backgroundImage.insert(image, paddingSize / 2, paddingSize / 2);
//        backgroundImage.writeToArray(VipsImageFormat.JPG, false);
//        image.release();
//        backgroundImage.release();
//    }
}
