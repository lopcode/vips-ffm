#!/usr/bin/env bash
# Source this from the repository root to use the libvips build made by ./setup_development.sh

LIBVIPS_PREFIX="$PWD/libvips/release"

if [ ! -x "$LIBVIPS_PREFIX/bin/vips" ]; then
  echo "Could not find libvips build at \"$LIBVIPS_PREFIX\" - run ./setup_development.sh first"
  return 1 2>/dev/null || exit 1
fi

if [[ "$OSTYPE" == darwin* ]]; then
  LIBVIPS_LIB_EXTENSION="dylib"
else
  LIBVIPS_LIB_EXTENSION="so"
  # installed binaries have no rpath, and would otherwise pick up a system libvips
  export LD_LIBRARY_PATH="$LIBVIPS_PREFIX/lib${LD_LIBRARY_PATH:+:$LD_LIBRARY_PATH}"
fi

export PKG_CONFIG_PATH="$LIBVIPS_PREFIX/lib/pkgconfig${PKG_CONFIG_PATH:+:$PKG_CONFIG_PATH}"

LIBVIPS_BIN="$LIBVIPS_PREFIX/bin/vips"
LIBVIPS_INCLUDES_PATH="$(pkg-config --variable=includedir vips)"
LIBVIPS_GIR_PATH="$LIBVIPS_PREFIX/share/gir-1.0/Vips-8.0.gir"
GLIB_LIB_PATH="$(pkg-config --variable=libdir glib-2.0)"

GLIB_INCLUDE_ARGS=()
for flag in $(pkg-config --cflags-only-I glib-2.0); do
  GLIB_INCLUDE_ARGS+=(--include-dir "${flag#-I}")
done

JAVA_PATH_OPTS="-Dvipsffm.libpath.vips.override=$LIBVIPS_PREFIX/lib/libvips.$LIBVIPS_LIB_EXTENSION \
  -Dvipsffm.libpath.glib.override=$GLIB_LIB_PATH/libglib-2.0.$LIBVIPS_LIB_EXTENSION \
  -Dvipsffm.libpath.gobject.override=$GLIB_LIB_PATH/libgobject-2.0.$LIBVIPS_LIB_EXTENSION"
export JAVA_PATH_OPTS
