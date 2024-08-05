# im-ffm

A thin wrapper to let Java/JVM projects use [ImageMagick](https://imagemagick.org/), via the
"Foreign Function & Memory API" ([JEP 454](https://openjdk.org/jeps/454)) released in JDK 22.

Incubating in [Photo Fox](https://github.com/lopcode/photo-fox).

## Project goals

* Publish to GitHub Packages via Gradle, so that using the library is as easy as
`implementation("app.photofox:im-ffm-core:$version")`
* Automate as much as possible, including API generation via `jextract`, so upstream changes can be rapidly integrated
* Core module should only include this automated output, with a minimum of extra things that can break as ImageMagick
changes
* If helpers are required, publish in another artifact
* Target [MagickWand](https://imagemagick.org/script/magick-wand.php) first, build with Photo Fox in mind, generalise
later

## Proof of concept

This project includes a proof of concept that only runs on macOS. To run it:
* `brew install imagemagick`
* `sdk use java 22-open`
* `./setup_lib_symlinks.sh`
* (Optional, to regenerate bindings) `./generate_ffm_bindings.sh`
* Run `ImFfm` in IntelliJ to run an ImageMagick resizing sample
  * If it succeeds, you'll get a `logo_resize.jpg` file in the project directory 🎉
