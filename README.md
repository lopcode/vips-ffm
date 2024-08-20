# vips-ffm

[libvips](https://github.com/libvips/libvips) bindings for JVM projects, using the "Foreign Function & Memory API"
([JEP 454](https://openjdk.org/jeps/454)), and the "Class-File API" ([JEP 457](https://openjdk.org/jeps/457)) released in JDK 22. The combination
of libvips, FFM, and auto-generated helpers makes for performant, safe, and ergonomic image manipulation in JVM systems.
Supports a vast range of image formats, including HEIC, JXL, WebP, PNG, JPEG, and more. Pronounced "vips (like zips)
eff-eff-emm".

Bindings are automatically generated using `jextract`, and enhanced with some helpful wrapper functions to make usage
more idiomatic.

Incubating in [Photo Fox](https://github.com/lopcode/photo-fox).

## Project goals

* Publish to GitHub Packages via Gradle, so that using the library is as easy as
`implementation("app.photofox:vips-ffm-core:$version")` (TODO)
* Automate as much as possible, including API generation via [jextract](https://github.com/openjdk/jextract), so
  upstream changes can be rapidly integrated ✅
* Core module should only include this automated output, with a minimum of extra things that can break as upstreams
  change ✅
* If helpers are required, publish in another artifact ✅
  * Generate these too, if possible
* Keep generated APIs as similar to the original as possible
* Incubate in Photo Fox with some "real world" usage

## Samples

Samples are included that show various usages of the `libvips` bindings. They include validations, and run on GitHub
Actions to validate new versions during development.

To get set up to run samples (on macOS):
* `brew install vips`
* `sdk use java 22-open`
* `./setup_lib_symlinks.sh`
* (Optional, to regenerate bindings) `./generate_ffm_bindings.sh`
* Then either:
  * Run `./run_samples.sh` in your terminal
  * Run `VipsFfm` in IntelliJ to run samples and validations

```
[main] INFO vipsffm.SampleRunner - clearing sample run directory at path "sample_run"
[main] INFO vipsffm.SampleRunner - running sample "RawGetVersionSample"...
[main] INFO vipsffm.RawGetVersionSample - libvips version: "8.15.2"
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "HelperGetVersionSample"...
[main] INFO vipsffm.HelperGetVersionSample - libvips version: "8.15.2"
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "RawCreateThumbnailSample"...
[main] INFO vipsffm.RawGetVersionSample - source image size: 2490 x 3084
[main] INFO vipsffm.RawGetVersionSample - output image size: 323 x 400
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "HelperCreateThumbnailSample"...
[main] INFO vipsffm.RawGetVersionSample - source image size: 2490 x 3084
[main] INFO vipsffm.RawGetVersionSample - thumbnail image size: 323 x 400
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - shutting down vips to check for memory leaks...
memory: high-water mark 36.55 MB
[main] INFO vipsffm.SampleRunner - all samples ran successfully 🎉
```

### Thumbnail sample

To get a feeling for the bindings, here's an indicative sample written in Kotlin (using the Java bindings) that:
* Loads an original JPEG image from disk
* Writes a copy of it to disk
* Creates a 400px thumbnail from the original, and writes that to disk 

```kt
Arena.ofConfined().use { arena ->
    val vips = Vips(arena)

    val sourceImage = vips.imageNewFromFile(
        "sample/src/main/resources/sample_images/rabbit.jpg",
        VipsIntOption("access", VipsRaw.VIPS_ACCESS_SEQUENTIAL())
    )
    val sourceWidth = VipsImage.Xsize(sourceImage)
    val sourceHeight = VipsImage.Ysize(sourceImage)
    logger.info("source image size: $sourceWidth x $sourceHeight")

    val outputPath = workingDirectory.resolve("rabbit_copy.jpg")
    vips.imageWriteToFile(sourceImage, outputPath.absolutePathString())

    val outputImagePointer = VipsOutputPointer(arena)
    vips.thumbnail("sample/src/main/resources/sample_images/rabbit.jpg", outputImagePointer, 400)
    val thumbnailImage = outputImagePointer.dereferencedOrThrow()
    val thumbnailPath = workingDirectory.resolve("rabbit_thumbnail_400.jpg")
    vips.imageWriteToFile(thumbnailImage, thumbnailPath.absolutePathString())

    val thumbnailWidth = VipsImage.Xsize(thumbnailImage)
    val thumbnailHeight = VipsImage.Ysize(thumbnailImage)
    logger.info("thumbnail image size: $thumbnailWidth x $thumbnailHeight")
}
```