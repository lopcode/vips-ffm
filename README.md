# vips-ffm

A thin wrapper to let Java/JVM projects use [libvips](https://github.com/libvips/libvips), via the
"Foreign Function & Memory API" ([JEP 454](https://openjdk.org/jeps/454)) released in JDK 22.

Incubating in [Photo Fox](https://github.com/lopcode/photo-fox). Pronounced "vips (like hips) eff-eff-emm".

## Project goals

* Publish to GitHub Packages via Gradle, so that using the library is as easy as
`implementation("app.photofox:vips-ffm-core:$version")`
* Automate as much as possible, including API generation via `jextract`, so upstream changes can be rapidly integrated
* Core module should only include this automated output, with a minimum of extra things that can break as ImageMagick
changes
* If helpers are required, publish in another artifact
* Incubate in Photo Fox with some "real world" usage

## Proof of concept

This project includes a proof of concept that only runs on macOS. To run it:
* `brew install vips`
* `sdk use java 22-open`
* `./setup_lib_symlinks.sh`
* (Optional, to regenerate bindings) `./generate_ffm_bindings.sh`
* Run `VipsFfm` in IntelliJ to run samples and validations

### Example output

```
[main] INFO vipsffm.VipsFfm - clearing sample run directory at path "sample_run"
[main] INFO vipsffm.VipsFfm - running sample "GetVersionSample"...
[main] INFO vipsffm.GetVersionSample - libvips version: "8.15.2"
[main] INFO vipsffm.VipsFfm - validation succeeded ✅
[main] INFO vipsffm.VipsFfm - all samples ran successfully 🎉
```
