#!/usr/bin/env bash
set -eou pipefail

# must match the commit the libvips submodule is pinned to
LIBVIPS_VERSION="8.18.7"

echo "Fetching libvips submodule..."
git submodule update --init libvips

if [ -n "$(git -C libvips status --porcelain)" ]; then
  echo "libvips submodule has local changes - clean it before building"
  exit 1
fi

SUBMODULE_TAG="$(git -C libvips describe --tags --exact-match 2>/dev/null || true)"
if [ "$SUBMODULE_TAG" != "v$LIBVIPS_VERSION" ]; then
  echo "libvips submodule is at \"${SUBMODULE_TAG:-$(git -C libvips rev-parse HEAD)}\", expected \"v$LIBVIPS_VERSION\""
  exit 1
fi

echo "Displaying submodule status..."
git submodule status libvips

if [[ "$OSTYPE" == darwin* ]]; then
  echo "Installing libvips build dependencies with Homebrew..."
  brew install meson ninja pkgconf gobject-introspection
  brew install --only-dependencies vips
  # libarchive is keg-only, so pkg-config can't find it by default
  export PKG_CONFIG_PATH="$(brew --prefix libarchive)/lib/pkgconfig${PKG_CONFIG_PATH:+:$PKG_CONFIG_PATH}"
elif command -v apt-get > /dev/null; then
  echo "Installing libvips build dependencies with apt..."
  apt-get update
  apt-get install --no-install-recommends --yes meson build-essential gobject-introspection libvips-dev
else
  echo "Not installing libvips build dependencies - no Homebrew or apt found"
fi

pushd libvips

echo "Building libvips..."
echo "Clearing build cache..."
rm -rf build release

PREFIX_PATH="$PWD/release"
echo "Prefix path: $PREFIX_PATH"

# the generator reads Vips-8.0.gir, so introspection must not be silently skipped
# modules are built in: with loadable modules, libvips can pick up another install's vips-modules (eg Homebrew's),
# which loads a second libvips and deadlocks the introspection step
meson setup build \
  --prefix "$PREFIX_PATH" \
  --libdir lib \
  --buildtype release \
  -Dintrospection=enabled \
  -Dmodules=disabled \
  -Darchive=enabled \
  -Dcplusplus=false \
  -Dexamples=false \
  "$@"

echo "Compiling..."
meson compile -C build -v
echo "Installing..."
meson install -C build

# on Linux the installed binary has no rpath, and would otherwise pick up a system libvips
(LD_LIBRARY_PATH="$PREFIX_PATH/lib${LD_LIBRARY_PATH:+:$LD_LIBRARY_PATH}" release/bin/vips --version | grep "vips-$LIBVIPS_VERSION") || (echo "libvips version not as expected" && exit 1)
popd

echo "libvips $LIBVIPS_VERSION built successfully 🎉"
