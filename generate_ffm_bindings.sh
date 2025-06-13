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

./libvips/release/bin/vips --version

LIBVIPS_INCLUDES_PATH="$(readlink -f ./libvips/release/include)"
LIBVIPS_ENTRY_PATH="$LIBVIPS_INCLUDES_PATH"/vips/vips.h

if [ ! -f "$LIBVIPS_ENTRY_PATH" ]; then
  echo "Failed to find libvips headers at \"$LIBVIPS_ENTRY_PATH\""
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
--include-dir "/opt/homebrew/include/glib-2.0" \
--include-dir "/opt/homebrew/lib/glib-2.0/include" \
--library "vips" \
--dump-includes includes.txt \
"jextract_entry/entrypoint.h"

echo "Filtering includes..."

rm includes_filtered.txt || true
touch includes_filtered.txt

{
  grep -E ' (vips_area_get|vips_area_copy|vips_area_unref|vips_foreign_find|vips_filename|vips_init|vips_nick|vips_source_(custom_)?new|vips_blob|vips_object_set_from_string|vips_object_unref_outputs|vips_block|vips_type|vips_error|vips_version|vips_leak|vips_shut|vips_value|vips_enum|vips_interpolate)[A-Za-z0-9_]*' includes.txt
  grep -E ' (vips_image_(get|set)_|g_strfreev|vips_image_map|VipsImageMapFn|vips_image_has)[A-Za-z0-9_]*' includes.txt
  grep -E ' (vips_(source|image|target|array_int|array_double|array_image|image)_get_type|vips_image_new[ ]|vips_image_write[ ])[A-Za-z0-9_]*' includes.txt
  grep -E ' (vips_object_get_args|vips_object_get_description|vips_object_get_argument)[A-Za-z0-9_]*' includes.txt
  grep -E ' (vips_source_new|vips_target_(custom_)?new)[A-Za-z0-9_]*' includes.txt
  grep -E ' (vips_cache_set|vips_block_operation|vips_cache_operation_build|vips_operation_new|vips_operation_get_flags)[A-Za-z0-9_]*' includes.txt
  grep -E ' (vips_foreign_find|vips_filename_get)[A-Za-z0-9_]*' includes.txt
  grep -E ' (vips_init|vips_leak|vips_shutdown|vips_version|vips_version_string|vips_block)[A-Za-z0-9_]*' includes.txt
  grep -E ' (vips_interpolate_new)[A-Za-z0-9_]*' includes.txt
  grep -E ' (g_signal_connect_data)[A-Za-z0-9_]*' includes.txt
  grep -E ' g_object_(un)?ref|g_free[ ]|g_type_check_instance_is_a|g_type_from_name|g_type_class_ref|g_type_name|g_param_spec_get_blurb|g_param_spec_types|g_object_(get|set)_property|g_value_(init|unset)[ ]|g_value_(set|get)_(int|long|string|object|boolean|boxed|double)[ ]' includes.txt
  grep -E ' (_)?(VIPS_|VipsTypeMap2Fn)' includes.txt
  grep -E ' (_)?(CustomStream(.*)Callback)' includes.txt
  grep -E ' (_)?(VipsArea[ ]|VipsTarget[ ]|VipsConnection[ ]|VipsObject[ ])' includes.txt
  grep -E ' (_)?(GClass[ ]|GEnum(Class|Value)?[ ]|GObject[ ]|GObjectClass[ ]|GInputStream[ ]|GInputStreamClass[ ]|GTypeInstance[ ]|GTypeClass[ ]|GValue[ ]|GParamSpec[ ]|GMutex[ ]|G_TYPE)' includes.txt
} >> includes_filtered.txt

echo "Running jextract..."

set -x
"$JEXTRACT_DOWNLOAD_PATH"/bin/jextract \
--include-dir "$LIBVIPS_INCLUDES_PATH/vips/" \
--include-dir "$LIBVIPS_INCLUDES_PATH" \
--include-dir "/opt/homebrew/include/glib-2.0" \
--include-dir "/opt/homebrew/lib/glib-2.0/include" \
--include-dir "custom_defs" \
--output core/src/main/java \
--target-package "app.photofox.vipsffm.jextract" \
--header-class-name "VipsRaw" \
--library "vips" \
@includes_filtered.txt \
"jextract_entry/entrypoint.h"

./gradlew clean generator:build generator:shadowJar

DYLD_LIBRARY_PATH=$(readlink -f ./libvips)/release/lib:/opt/homebrew/lib java --enable-native-access=ALL_UNNAMED -jar generator/build/libs/generator-all.jar

./build_docs.sh