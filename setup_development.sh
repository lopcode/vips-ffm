#!/usr/bin/env bash
set -eou pipefail

LIBVIPS_VERSION="8.17.1"

echo "Fetching libvips submodule..."
# Grab correct version of libvips in submodule, if not already fetched
git submodule set-branch --branch "tags/v$LIBVIPS_VERSION" -- libvips
git submodule sync
pushd libvips
git checkout "tags/v$LIBVIPS_VERSION"
popd
git add libvips

# If on macOS, grab latest version available in Homebrew for best-effort dependencies
if [ "$(uname -sr)" == "Darwin*" ]; then
  echo "Installing libvips homebrew formula..."
  brew install libvips
fi

echo "Displaying submodule status..."
git submodule status libvips

# Build libvips
pushd libvips

echo "Building libvips..."
echo "Clearing build cache..."
rm -rf build && mkdir -p build

echo "Setting up Meson build..."
PREFIX_PATH=$(realpath "release")
echo "Prefix path: $PREFIX_PATH"

export CC=clang
export CXX=clang++

meson setup build --prefix $PREFIX_PATH

echo "Compiling..."
meson compile -C build
echo "Installing..."
meson install -C build

(release/bin/vips --version | grep $LIBVIPS_VERSION) || (echo "libvips version not as expected" && exit 1)
popd

echo "libvips $LIBVIPS_VERSION built successfully 🎉"