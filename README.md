# vips-ffm

Fast, safe, complete [libvips](https://github.com/libvips/libvips) bindings for image processing in Java / JVM projects.

Supports a vast range of image formats, including HEIC, JXL, WebP, PNG, JPEG, and more. Pronounced "vips (like zips)
eff-eff-emm". The project is relatively new, but aims to be production ready. Tested on macOS 14, Windows 11, and Linux
(Ubuntu 24.04, Debian 12.1, with and without jemalloc). Should work on any architecture you can use libvips and
Java on (arm64/amd64/etc).

Uses the "Foreign Function & Memory API" ([JEP 454](https://openjdk.org/jeps/454)), and the "Class-File API" ([JEP 457](https://openjdk.org/jeps/457)) released in JDK 22.
Built in such a way that it's usually the fastest image processing library available for Java.

Used the library? I'd love to hear from more users - let me know in [Discussions](https://github.com/lopcode/vips-ffm/discussions). Please also give [the repo](https://github.com/lopcode/vips-ffm)
a star 🌟️!

## Usage

`vips-ffm` is available on Maven Central. To get set up with Gradle:

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("app.photofox.vips-ffm:vips-ffm-core:1.9.3")
}
```

Figure out what you're trying to do by looking at the [libvips documentation](https://www.libvips.org/API/current/)
first, then use it through one of the helper classes (for example, [VImage](https://vipsffm.photofox.app/app.photofox.vipsffm/app/photofox/vipsffm/VImage.html)).
There are also lots of examples in the [samples](#samples).

You must add `--enable-native-access=ALL-UNNAMED` to your JVM runtime arguments. If you don't, you'll get a warning
about "Restricted methods". In the future, the JVM will throw an error if you don't explicitly include this flag.

As the project uses the Java FFM API, and Markdown comments, your target must also be JDK 23+. Bindings are currently
generated from libvips `8.17.2` (but should be safe to use with different minor or patch versions).

> [!NOTE]
> This library **does not** include `libvips` in the download, you must add it to the system/container you're building
> for. See details in [native library loading](#native-library-loading).

### Thumbnail sample

To get a feeling for the bindings, here's an indicative sample written in Kotlin (using the Java bindings) that:
* Loads an original JPEG image from disk
* Writes a copy of it to disk
* Creates a 400px thumbnail from the original, and writes that to disk

```kotlin
import app.photofox.vipsffm.Vips
import app.photofox.vipsffm.VImage
import app.photofox.vipsffm.VipsOption
import app.photofox.vipsffm.enums.VipsAccess

// ...

// Use `Vips.run` to wrap your usage of the API, and get an arena with an appropriate lifetime to use
// Usage of the API, arena, and resulting V-Objects must be done from the thread that called `Vips.run`
Vips.run { arena ->
    val sourceImage = VImage.newFromFile(
      arena,
      "sample/src/main/resources/sample_images/rabbit.jpg"
    )
    val sourceWidth = sourceImage.width
    val sourceHeight = sourceImage.height
    logger.info("source image size: $sourceWidth x $sourceHeight")

    val outputPath = workingDirectory.resolve("rabbit_copy.jpg")
    sourceImage.writeToFile(outputPath.absolutePathString())

    val thumbnail = sourceImage.thumbnailImage(
      400,
      VipsOption.Boolean("auto-rotate", true) // example of an option
    )
    val thumbnailWidth = thumbnail.width
    val thumbnailHeight = thumbnail.height
    logger.info("thumbnail image size: $thumbnailWidth x $thumbnailHeight")
}

// Optionally call at the end of your program, for memory leak detection, from any thread
Vips.shutdown()
```

## Samples

Samples are included that show various usages of these bindings. They include validations, and run on GitHub Actions as
"end-to-end tests" during development. You can find them all listed [here](https://github.com/lopcode/vips-ffm/tree/main/sample/src/main/kotlin/vipsffm/sample).

To get set up to run samples (on macOS):
* `brew install vips`
* `sdk use java 23-open`
* Then either:
  * Run `./run_samples.sh` in your terminal
  * Use the included `Run samples` profile in IntelliJ

```
[main] INFO vipsffm.SampleRunner - clearing sample run directory at path "sample_run"
[main] INFO vipsffm.SampleRunner - running sample "RawGetVersionSample"...
[main] INFO vipsffm.sample.RawGetVersionSample - libvips version: "8.15.5"
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "HelperGetVersionSample"...
[main] INFO vipsffm.sample.HelperGetVersionSample - libvips version: "8.15.5"
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "VImageCreateThumbnailSample"...
[main] INFO vipsffm.sample.VImageCreateThumbnailSample - source image size: 2490 x 3084
[main] INFO vipsffm.sample.VImageCreateThumbnailSample - thumbnail image size: 323 x 400
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "VImageChainSample"...
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "VSourceTargetSample"...
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "VImageCopyWriteSample"...
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "VOptionHyphenSample"...
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "VImageCachingSample"...
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "VImageBlobSample"...
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "VImageArrayJoinSample"...
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "VBlobByteBufferSample"...
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "VTargetToFileSample"...
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "VImageJoinSample"...
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "VImageFromBytesSample"...
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - running sample "VImageStreamSample"...
[main] INFO vipsffm.SampleRunner - validation succeeded ✅
[main] INFO vipsffm.SampleRunner - shutting down vips to check for memory leaks...
memory: high-water mark 151.24 MB
[main] INFO vipsffm.SampleRunner - all samples ran successfully 🎉
```

### Detailed usage

Most operations **do not** use the C API directly (as described in the [bindings docs](https://www.libvips.org/API/current/binding.html)) - they
should be safe to use with different libvips versions, assuming there haven't been major changes.

All libvips operations are exposed via helper classes, like `VImage`. You must provide an [Arena][1] to operations like
`VImage.newFromFile`, which constrains the lifetime of objects generated during usage. You can get an appropriate arena
by using `Vips.run` as shown in the [sample](#thumbnail-sample) below. `VImage` and associated enums have extensive
Javadocs included, which are automatically generated from the same source that the libvips website uses, for ease of use.
These helper objects expose their raw pointers as a last resort via functions like `VTarget.getUnsafeStructAddress` - if
you need to use these raw pointers and can't find an alternative, please file a GitHub Issue.

Helper enums are generated for the version of libvips shown above. If you need to use an enum from another version,
which isn't present in `vips-ffm`, you can use `VipsOption.Enum(rawValue)` or `VEnum.Raw(rawValue)`.

> [!CAUTION]
> Bindings generated by `jextract` are available in `VipsRaw`, and wrapped with validation in `VipsHelper`. These
> functions are difficult to use without accidentally causing memory leaks, or even segfaults! If what you want to do is
> available in `VImage` and other `V`-prefixed classes, use those instead. If you notice something missing, please open
> a GitHub Issue.

## Initialisation

Initialisation of libvips is performed automatically the first time the `Vips`, `VipsHelper`, or `VipsInvoker` classes
are initialised (which will cover almost all normal usage of vips-ffm). Previous versions of vips-ffm required users to
call `Vips.init` manually, but this is no longer required.

If you'd like to disable auto-initialisation of libvips, set the system property `vipsffm.autoinit` to the string value
`false`.

## Docker checks

These samples are also run in Docker containers, to verify behaviour on specific Linux distributions. They're useful to
look at if you're deploying `libvips` and `vips-ffm` workloads using containers.

You can find them in the [`docker_tests`](docker_tests) folder.

## Native library loading

This library requires the `libvips`, `glib`, and `gobject` native libraries to be present in your library path:
* On macOS: `DYLD_LIBRARY_PATH` (installed with `brew install vips`)
* On Linux: `LD_LIBRARY_PATH` (installed with `apt install libvips-dev` on Debian / Ubuntu)
* On Windows: `PATH`

The naming conventions of these libraries are not consistent across operating systems, so vips-ffm attempts to load each
in the following order:
* `vips`, `vips.{abiNumber}`, `libvips-{abiNumber}` 
* `glib-2.0`, `glib-2.0.{abiNumber}`, `libglib-2.0-{abiNumber}`
* `gobject-2.0`, `gobject-2.0.{abiNumber}`, `libgobject-2.0-{abiNumber}`

Override properties are provided to set your own "ABI number", but note that vips-ffm might not support that version
yet (which could manifest as crashes/segfaults):
* `vipsffm.abinumber.vips.override`, default: `42`
* `vipsffm.abinumber.glib.override`, default: `0`
* `vipsffm.abinumber.gobject.override`, default: `0`

If you want to manually override the library lookup path for any of the above (for example, if you're using a platform
like Android where it's hard to set the system library path), you can do so using these system properties:
* libvips: `vipsffm.libpath.vips.override` (eg `/opt/homebrew/lib/libvips.dylib`)
* glib: `vipsffm.libpath.glib.override`
* gobject: `vipsffm.libpath.gobject.override`

## Operationalisation

libvips maintain [a checklist](https://www.libvips.org/API/8.17/developer-checklist.html) of things to be aware of when
using the library. Of particular note for vips-ffm is memory usage - especially if the library is used for long-running
application (like a server).

### Operation cache

At the time of writing, libvips maintains a cache of the 100 most recent operations ([see docs](https://www.libvips.org/API/8.17/how-it-works.html#operation-cache)).
If running an image proxy, or something that processes lots of different images, you won't see any benefit, and can
disable it:

```java
Vips.disableOperationCache();
```

### Memory allocation

On glibc-based Linux systems (e.g. Debian, Red Hat), the default memory allocator performs poorly for long-running,
multithreaded processes with frequent small allocations. Using an alternative allocator like jemalloc can reduce the
off-heap footprint of the JVM when using libvips.

Note that the jemalloc project is going through [some turbulence](https://jasone.github.io/2025/06/12/jemalloc-postmortem/)
at the moment. Facebook have [forked it](https://github.com/facebook/jemalloc), though its maintenance status is
currently unknown.

An example of using jemalloc on Ubuntu:
1. Install jemalloc
   ```sh
   apt install libjemalloc2
   ```
2. Set the `LD_PRELOAD` environment variable before running your application.
   ```sh
   ln -sT "$(readlink -e /usr/lib/*/libjemalloc.so.2)" /usr/local/lib/libjemalloc.so # symlink jemalloc to a standard location
   export LD_PRELOAD=/usr/local/lib/libjemalloc.so
   java -jar ...
   ```

### Allowing untrusted operations

By default, vips-ffm sets the "block untrusted operations" flag in libvips, in an attempt to be "secure by default".
This includes blocking things like the imagemagick and PDF loaders. If you get an error relating to "operation is
blocked", then the operation you're trying to use is marked as untrusted in libvips.

If you need to work with operations and formats that are marked as "untrusted" in libvips, you can permit them
explicitly:
```java
Vips.allowUntrustedOperations();
```

See the [libvips docs](https://www.libvips.org/API/8.17/func.block_untrusted_set.html) for guidance on figuring out what
loaders and operations are marked as trusted or untrusted.

## Project goals

Ideas and suggestions are welcome, but please make sure they fit in to these goals, or you have a good argument about
why a goal should change!

* Avoid manual work by automating as much as possible. This means upstream changes can be rapidly integrated.
* Use the libvips operations API, as described in the [libvips documentation](https://www.libvips.org/API/current/binding.html)
* Provide access to the raw bindings (`VipsHelper`), so users aren't blocked by helper bugs or API annoyances.
* Incubate in [Photo Fox](https://github.com/lopcode/photo-fox) with some "real world" usage.

## Contributing

Please see the contributing guidelines: [CONTRIBUTING.md](CONTRIBUTING.md).

Some great non-code ways to help the project:

* Use the library and give your feedback in [Discussions](https://github.com/lopcode/vips-ffm/discussions)
  * Or [file an issue](https://github.com/lopcode/vips-ffm/issues) if you have a problem!
* Share the [announcement post](https://www.lopcode.com/posts/2024/10/vips-ffm-1/) in your circles
* Star the repo 🌟

Thank you for being enthusiastic about the project!

## Releasing

* GitHub Releases automatically result in a deployment to GitHub Packages
* Maven Central releases happen manually 
  * This can only be done by @lopcode
  * And only after a GitHub Release is made
  * Run `./publish_release_to_maven_central.sh <version matching github release version, including v prefix>` 

[1]: https://docs.oracle.com/en/java/javase/23/core/memory-segments-and-arenas.html
