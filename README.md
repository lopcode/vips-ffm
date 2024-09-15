# vips-ffm

[libvips](https://github.com/libvips/libvips) bindings for JVM projects, using the "Foreign Function & Memory API"
([JEP 454](https://openjdk.org/jeps/454)), and the "Class-File API" ([JEP 457](https://openjdk.org/jeps/457)) released in JDK 22. The combination
of libvips, FFM, and auto-generated helpers means these bindings are complete (supporting all libvips operations), safe,
and fast.

Supports a vast range of image formats, including HEIC, JXL, WebP, PNG, JPEG, and more. Pronounced "vips (like zips)
eff-eff-emm".

Used the library, or just like what you've read so far? Please give the repo a star 🌟️!

## Usage

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("app.photofox.vips-ffm:vips-ffm-core:0.0.8")
}
```

As the project uses the FFM API, it must target JDK 22+.

All libvips operations are exposed via helper classes, like `VImage`. You must provide an [Arena][1] to operations like
`VImage.newFromFile`, and this constrains the lifetime of objects generated during usage. Be careful to only keep the 
arena, and image, in scope for as long as you need to! If the arena doesn't close, your memory usage will grow forever.
Constructing the `VImage` object is cheap, as it's just a wrapper, so make them as you need.

This library **does not** include `libvips` in the download, you must add it to the system you're building on, then make
sure it's available in `DYLD_LIBRARY_PATH` (on macOS) or `LD_LIBRARY_PATH` (on Linux). 

🚨 Bindings generated by `jextract` are available in `VipsRaw`, and wrapped with validation in `VipsHelper`. It's
difficult to use `VipsRaw` functions without accidentally causing memory leaks, or even segfaults! If what you want to
do is available in `VImage` and other `V`-prefixed classes, use those instead. If you notice something missing, open a
GitHub Issue.

### Thumbnail sample

To get a feeling for the bindings, here's an indicative sample written in Kotlin (using the Java bindings) that:
* Loads an original JPEG image from disk
* Writes a copy of it to disk
* Creates a 400px thumbnail from the original, and writes that to disk

```kotlin
import app.photofox.vipsffm.generated.Vips
import java.lang.foreign.Arena

// ...

Arena.ofConfined().use { arena ->
    val sourceImage = VImage.newFromFile(
      arena,
      "sample/src/main/resources/sample_images/rabbit.jpg",
      VipsOption.Int("access", VipsRaw.VIPS_ACCESS_SEQUENTIAL())
    )
    val sourceWidth = sourceImage.width
    val sourceHeight = sourceImage.height
    logger.info("source image size: $sourceWidth x $sourceHeight")

    val outputPath = workingDirectory.resolve("rabbit_copy.jpg")
    sourceImage.writeToFile(outputPath.absolutePathString())

    val thumbnail = sourceImage.thumbnail(
      "sample/src/main/resources/sample_images/rabbit.jpg",
      400
    )
    val thumbnailWidth = thumbnail.width
    val thumbnailHeight = thumbnail.height
    logger.info("thumbnail image size: $thumbnailWidth x $thumbnailHeight")
}
```

The project has several samples, [described below](#samples).

## Project goals

Ideas and suggestions are welcome, but please make sure they fit in to these goals, or you have a good argument about
why a goal should change!

* Avoid manual work by automating as much as possible. This means upstream changes can be rapidly integrated.
* Use the libvips GObject API for operations, as described in the [libvips documentation](https://www.libvips.org/API/current/binding.html)
* Provide access to the raw bindings (`VipsHelper`), so users aren't blocked by helper bugs or API annoyances.
* Incubate in [Photo Fox](https://github.com/lopcode/photo-fox) with some "real world" usage.

## Samples

Samples are included that show various usages of the `libvips` bindings. They include validations, and run on GitHub
Actions as "end-to-end tests" during development.

To get set up to run samples (on macOS):
* `brew install vips`
* `sdk use java 22-open`
* `./setup_lib_symlinks.sh`
* (Optional, to regenerate bindings) `./generate_ffm_bindings.sh`
* Then either:
  * Run `./run_samples.sh` in your terminal
  * Run `SampleRunner` in IntelliJ to run samples and validations

```
[main] INFO vipsffm.SampleRunner - clearing sample run directory at path "sample_run"
[main] INFO vipsffm.SampleRunner - running sample "RawGetVersionSample"...
[main] INFO vipsffm.RawGetVersionSample - libvips version: "8.15.3"
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "HelperGetVersionSample"...
[main] INFO vipsffm.HelperGetVersionSample - libvips version: "8.15.3"
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "VImageCreateThumbnailSample"...
[main] INFO vipsffm.RawGetVersionSample - source image size: 2490 x 3084
[main] INFO vipsffm.RawGetVersionSample - thumbnail image size: 323 x 400
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "VImageChainSample"...
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "VSourceTargetSample"...
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "VImageWriteSample"...
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - shutting down vips to check for memory leaks...
memory: high-water mark 82.66 MB
[main] INFO vipsffm.SampleRunner - all samples ran successfully 🎉
```

## Releasing

* GitHub Releases automatically result in a deployment to GitHub Packages
* Maven Central releases happen manually 
  * This can only be done by @lopcode
  * And only after a GitHub Release is made
  * Run `./publish_release_to_maven_central.sh <version matching github release version>` 

[1]: https://docs.oracle.com/en/java/javase/22/core/memory-segments-and-arenas.html