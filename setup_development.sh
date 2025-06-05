#!/usr/bin/env bash
set -eou pipefail

LIBVIPS_VERSION="8.17.0"

echo "Fetching libvips submodule..."
# Grab correct version of libvips in submodule, if not already fetched
git submodule foreach git reset --hard
git submodule set-branch --branch "tags/v$LIBVIPS_VERSION" -- libvips
git submodule update --init --recursive

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
mkdir -p release
meson setup build --reconfigure --prefix "$(pwd)/release"

pushd build
meson compile
meson install
popd

(release/bin/vips --version | grep $LIBVIPS_VERSION) || (echo "libvips version not as expected" && exit 1)
popd

echo "libvips $LIBVIPS_VERSION built successfully 🎉"