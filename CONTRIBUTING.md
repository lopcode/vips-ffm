# Contributing

There are a few things I'm open to help with, but that I'd like to discuss first:
* Investigating how Kotlin Multiplatform might work
  * Perhaps shipped as another module, so that it doesn't interfere with the "simple" Java core module at `vips-ffm-core`
* Investigating whether we could offer a build of libvips in another module, to make integration easier
  * I'd definitely like X86 and ARM64 support for this
  * It should continue to work with cutting-edge versions of Java - not becoming a blocker to users upgrading their JVM
* Refactoring the [generator](https://github.com/lopcode/vips-ffm/tree/main/generator/src/main/kotlin/vipsffm) classes
  to make them a little less scrappy, and easier to reason about, without introducing too many "design patterns"

Any change must be tested, either by using unit tests, or by improving the existing [samples](README.md#samples). The
library is already used by some larger businesses (which is cool!), and I care a lot about release quality.

Please discuss any bigger changes with me **before** submitting a Pull Request - I can help you refine your idea better
that way, and I don't want to waste anybody's time: [Discussions](https://github.com/lopcode/vips-ffm/discussions).

I haven't currently defined a code of conduct for this project specifically, but please refer to the CoC [in libvips](https://github.com/libvips/libvips/blob/master/CODE_OF_CONDUCT.md)
for guidance on expected behaviour.

Thank you for being enthusiastic about the project!

## Code changes

You'll find it easiest to use [IntelliJ IDEA](https://www.jetbrains.com/idea/) to work on the project - there's a free
version. The project is only developed on macOS, but in theory it should be possible to work in other Unix-like environments.

Set up the libvips submodule, and create a build of it, by running `./setup_development.sh`. 

The project uses Gradle, and is split into multiple modules:
* `generator` uses the libvips operations API to generate most of the code in `core`
* `core` includes code from the generator, and other manually created wrappers for libvips
* `sample` uses core to provide examples, and verify behaviour during development

Strongly prefer making changes to the `generator`, so that regeneration is easy to do as new versions of libvips get
released. When you make changes to the `generator` module, you can use it to regenerate bindings using `./generate_ffm_bindings.sh`.
You can also run the samples yourself locally using `./run_samples.sh`.

There are also several run IntelliJ targets included for running the samples, or running a specific generator during
development.

Try to get set up yourself first for a bit, but if you get stuck, feel free to open a [Discussions](https://github.com/lopcode/vips-ffm/discussions)
for help.