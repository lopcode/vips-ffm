#!/usr/bin/env bash
set -eou pipefail

# check if jextract is installed
# https://jdk.java.net/jextract/
echo "Checking jextract exists..."
JEXTRACT_DOWNLOAD_URL=https://download.java.net/java/early_access/jextract/22/5/openjdk-22-jextract+5-33_macos-aarch64_bin.tar.gz
JEXTRACT_ZIP_CHECKSUM_SHA256=2a4411c32aedb064c3e432eb8a2791e6e60fea452330c71386f6573dc4c9c850
JEXTRACT_DOWNLOAD_PATH=jextract-22
"$JEXTRACT_DOWNLOAD_PATH"/bin/jextract --version || (echo "Downloading jextract..." \
&& curl --output jextract.tar.gz "$JEXTRACT_DOWNLOAD_URL" \
&& (echo "$JEXTRACT_ZIP_CHECKSUM_SHA256" jextract.tar.gz | sha256sum --check --status) \
&& tar -xvzf jextract.tar.gz)

echo "Setting up libvips..."

source scripts/libvips_env.sh

"$LIBVIPS_BIN" --version

LIBVIPS_ENTRY_PATH="$LIBVIPS_INCLUDES_PATH"/vips/vips.h

if [ ! -f "$LIBVIPS_ENTRY_PATH" ]; then
  echo "Failed to find libvips headers at \"$LIBVIPS_ENTRY_PATH\""
  exit 1
fi

echo "Found libvips headers at \"$LIBVIPS_INCLUDES_PATH\"..."
echo "Found libvips entry at \"$LIBVIPS_ENTRY_PATH\"..."

echo "Clearing generated files..."

cp core/src/main/java/app/photofox/vipsffm/jextract/package-info.java /tmp/jextract-package-info.java
rm -r core/src/main/java/app/photofox/vipsffm/jextract/* || true
mv /tmp/jextract-package-info.java core/src/main/java/app/photofox/vipsffm/jextract/package-info.java

echo "Dumping all discovered includes..."

"$JEXTRACT_DOWNLOAD_PATH"/bin/jextract \
--include-dir "$LIBVIPS_INCLUDES_PATH/vips/" \
--include-dir "$LIBVIPS_INCLUDES_PATH" \
"${GLIB_INCLUDE_ARGS[@]}" \
--library "vips" \
--dump-includes includes.txt \
"jextract_entry/entrypoint.h"

echo "Filtering includes..."

# each entry is a regex matched against a whole symbol name
INCLUDED_SYMBOLS=(
  # libvips functions
  'vips_(area_get|area_copy|area_unref|blob|block|enum|error|filename|foreign_find|init|interpolate|leak|nick|shut|type|value|version)[A-Za-z0-9_]*'
  'vips_(source_(custom_)?new|target_(custom_)?new|object_set_from_string|object_unref_outputs)[A-Za-z0-9_]*'
  'vips_object_get_(args|description|argument)[A-Za-z0-9_]*'
  'vips_(cache_set|cache_operation_build|operation_new|operation_get_flags)[A-Za-z0-9_]*'
  'vips_(source|image|target|array_int|array_double|array_image)_get_type[A-Za-z0-9_]*'
  'vips_image_((get|set)_|map|has|remove|new_from_memory|write_to_memory|copy_memory)[A-Za-z0-9_]*'
  'vips_image_(new|write|new_matrix|new_matrix_from_array)'
  # glib functions
  'g_(strfreev|signal_connect_data)[A-Za-z0-9_]*'
  'g_(free|object_(un)?ref|object_(get|set)_property|param_spec_get_blurb|param_spec_types)'
  'g_type_(check_instance_is_a|from_name|class_ref|name)'
  'g_value_(init|unset|(set|get)_(int|long|string|object|boolean|boxed|double))'
  # callbacks
  'VipsImageMapFn[A-Za-z0-9_]*'
  'VipsTypeMap2Fn[A-Za-z0-9_]*'
  '_?CustomStream[A-Za-z0-9_]*Callback[A-Za-z0-9_]*'
  # constants
  '_?VIPS_[A-Za-z0-9_]*'
  '_?G_TYPE[A-Za-z0-9_]*'
  # structs and typedefs
  '_?(VipsArea|VipsConnection|VipsObject|VipsTarget)'
  '_?(GClass|GEnum|GEnumClass|GEnumValue|GInputStream|GInputStreamClass|GMutex|GObject|GObjectClass|GParamSpec|GTypeClass|GTypeInstance|GValue)'
)

EXCLUDED_SYMBOLS=(
  # describe the libvips used for generation, not the one loaded at runtime
  'VIPS_(CONFIG|EXEEXT|PATH_MAX|ENABLE_DEPRECATED)'
  'VIPS_(VERSION|VERSION_STRING|MAJOR_VERSION|MINOR_VERSION|MICRO_VERSION|LIBRARY_CURRENT|LIBRARY_REVISION|LIBRARY_AGE)'
  # libvips and glib internals
  'VIPS__[A-Z_]+'
  'VIPS_(MAGIC_[A-Z]+|SIZEOF_HEADER|SBUF_BUFFER_SIZE|TARGET_(CUSTOM_)?BUFFER_SIZE|VECTOR_SOURCE_MAX|SPARE|INTERPOLATE_(SCALE|SHIFT))'
  'VIPS_IMAGE_(ERROR|NONE|SETBUF|SETBUF_FOREIGN|OPENIN|MMAPIN|MMAPINRW|OPENOUT|PARTIAL)'
  'VIPS_REGION_(NONE|BUFFER|OTHER_REGION|OTHER_IMAGE|WINDOW)'
  'VIPS_TOKEN_[A-Z]+'
  'G_TYPE_(DEBUG|RESERVED|FLAG)_[A-Z_]+'
  'G_TYPE_FUNDAMENTAL_(MAX|SHIFT)'
  # enum sentinels, which change between libvips versions
  '[A-Z0-9_]+_LAST'
)

symbols_pattern() {
  local IFS='|'
  echo "^--include-[a-z]+ ($*)( |$)"
}

grep -E "$(symbols_pattern "${INCLUDED_SYMBOLS[@]}")" includes.txt \
  | grep -vE "$(symbols_pattern "${EXCLUDED_SYMBOLS[@]}")" \
  > includes_filtered.txt

echo "Running jextract..."

set -x
"$JEXTRACT_DOWNLOAD_PATH"/bin/jextract \
--include-dir "$LIBVIPS_INCLUDES_PATH/vips/" \
--include-dir "$LIBVIPS_INCLUDES_PATH" \
"${GLIB_INCLUDE_ARGS[@]}" \
--include-dir "custom_defs" \
--output core/src/main/java \
--target-package "app.photofox.vipsffm.jextract" \
--header-class-name "VipsRaw" \
--library "vips" \
@includes_filtered.txt \
"jextract_entry/entrypoint.h"

./gradlew clean generator:run --args="bootstrap"
./gradlew clean generator:build generator:shadowJar

java $JAVA_PATH_OPTS -Dvipsffm.gir.path="$LIBVIPS_GIR_PATH" --enable-native-access=ALL_UNNAMED -jar generator/build/libs/generator-all.jar

./build_docs.sh