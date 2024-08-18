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
[main] INFO vipsffm.VipsFfm - clearing sample run directory at path "sample_run"
[main] INFO vipsffm.VipsFfm - running sample "GetVersionSample"...
[main] INFO vipsffm.GetVersionSample - libvips version: "8.15.2"
[main] INFO vipsffm.VipsFfm - validation succeeded ✅
[main] INFO vipsffm.VipsFfm - running sample "RawCreateThumbnailSample"...
[main] INFO vipsffm.GetVersionSample - source image size: 2490 x 3084
[main] INFO vipsffm.GetVersionSample - output image size: 323 x 400
[main] INFO vipsffm.VipsFfm - validation succeeded ✅
[main] INFO vipsffm.VipsFfm - running sample "HelperCreateThumbnailSample"...
[main] INFO vipsffm.GetVersionSample - source image size: 2490 x 3084
[main] INFO vipsffm.VipsFfm - validation succeeded ✅
[main] INFO vipsffm.VipsFfm - all samples ran successfully 🎉
```
