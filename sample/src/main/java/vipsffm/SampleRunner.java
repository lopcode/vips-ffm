package vipsffm;

import app.photofox.vipsffm.Vips;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vipsffm.sample.HelperGetSetMetadataSample;
import vipsffm.sample.HelperGetVersionSample;
import vipsffm.sample.RawGetVersionSample;
import vipsffm.sample.VBlobByteBufferSample;
import vipsffm.sample.VImageArrayJoinSample;
import vipsffm.sample.VImageBlobSample;
import vipsffm.sample.VImageCachingSample;
import vipsffm.sample.VImageChainSample;
import vipsffm.sample.VImageCopyWriteSample;
import vipsffm.sample.VImageCreateThumbnailSample;
import vipsffm.sample.VImageCustomSourceTargetSample;
import vipsffm.sample.VImageFindTrimSample;
import vipsffm.sample.VImageFromBytesSample;
import vipsffm.sample.VImageFromMemoryToMemorySample;
import vipsffm.sample.VImageGetPagesSample;
import vipsffm.sample.VImageGetPointSample;
import vipsffm.sample.VImageGetSetSample;
import vipsffm.sample.VImageJoinSample;
import vipsffm.sample.VImageMatrixSample;
import vipsffm.sample.VImageStreamSample;
import vipsffm.sample.VOptionHyphenSample;
import vipsffm.sample.VSourceTargetSample;
import vipsffm.sample.VTargetToFileSample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class SampleRunner {

    private static final Logger logger = LoggerFactory.getLogger(SampleRunner.class);

    public static void main(String[] args) throws IOException {
        var samples = List.of(
            new RawGetVersionSample(),
            new HelperGetVersionSample(),
            new VImageCreateThumbnailSample(),
            new VImageChainSample(),
            new VSourceTargetSample(),
            new VImageCopyWriteSample(),
            new VOptionHyphenSample(),
            new VImageCachingSample(),
            new VImageBlobSample(),
            new VImageArrayJoinSample(),
            new VBlobByteBufferSample(),
            new VTargetToFileSample(),
            new VImageJoinSample(),
            new VImageFromBytesSample(),
            new VImageStreamSample(),
            new VImageGetPagesSample(),
            new VImageGetPointSample(),
            new HelperGetSetMetadataSample(),
            new VImageGetSetSample(),
            new VImageFindTrimSample(),
            new VImageFromMemoryToMemorySample(),
            new VImageCustomSourceTargetSample(),
            new VImageMatrixSample()
        );
        var sampleParentRunPath = Paths.get("sample_run");
        if (Files.exists(sampleParentRunPath)) {
            logger.info("clearing sample run directory at path \"{}\"", sampleParentRunPath);
            deleteRecursively(sampleParentRunPath);
        }
        Files.deleteIfExists(sampleParentRunPath);
        Files.createDirectory(sampleParentRunPath);

        Vips.enableLeakDetection();
        for (var sample : samples) {
            Vips.run(arena -> {
                var sampleName = sample.getClass().getSimpleName();
                logger.info("running sample \"{}\"...", sampleName);
                try {
                    var sampleDirectoryName = makeSampleDirectoryName(sampleName);
                    var sampleRunPath = sampleParentRunPath.resolve(sampleDirectoryName);
                    Files.createDirectory(sampleRunPath);

                    sample.run(arena, sampleRunPath);
                } catch (Exception e) {
                    logger.error("validation failed ❌", e);
                    System.exit(1);
                }
                logger.info("validation succeeded ✅");
            });
        }
        logger.info("shutting down vips to check for memory leaks...");
        Vips.shutdown();
        logger.info("all samples ran successfully 🎉");
        System.exit(0);
    }

    private static String makeSampleDirectoryName(String original) {
        return original
            .replace(" ", "_")
            .toLowerCase(Locale.ENGLISH);
    }

    private static void deleteRecursively(Path path) throws IOException {
        try (var paths = Files.walk(path)) {
            paths.sorted(Comparator.reverseOrder()).forEach(it -> {
                try {
                    Files.delete(it);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
