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

vips --version

LIBVIPS_INCLUDES_PATH="/opt/homebrew/include"
LIBVIPS_ENTRY_PATH="$LIBVIPS_INCLUDES_PATH"/vips/vips.h

if [ ! -f "$LIBVIPS_ENTRY_PATH" ]; then
  echo "Failed to find libvips headers at \"$LIBVIPS_ENTRY_PATH\""
fi

echo "Found libvips headers at \"$LIBVIPS_INCLUDES_PATH\"..."
echo "Found libvips entry at \"$LIBVIPS_ENTRY_PATH\"..."

echo "Clearing generated files..."

rm -rf core/src/main/java/app/photofox/vipsffm/generated || true

echo "Dumping all discovered includes..."

"$JEXTRACT_DOWNLOAD_PATH"/bin/jextract \
--include-dir "/opt/homebrew/include/vips/" \
--include-dir "/opt/homebrew/include/" \
--include-dir "/opt/homebrew/include/glib-2.0" \
--include-dir "/opt/homebrew/lib/glib-2.0/include" \
--library "vips" \
--dump-includes includes.txt \
"$LIBVIPS_ENTRY_PATH"

echo "Filtering includes..."

rm includes_filtered.txt || true
touch includes_filtered.txt

{
  grep -iE ' (_)?vips[A-Za-z0-9_]*' includes.txt
  grep -iE ' (_)?(GObject|GObjectClass|GInputStream|GInputStreamClass|GTypeInstance|GTypeClass|GValue)' includes.txt
  grep -iE ' g_object' includes.txt
} >> includes_filtered.txt

echo "Running jextract..."

set -x
"$JEXTRACT_DOWNLOAD_PATH"/bin/jextract \
--include-dir "/opt/homebrew/include/vips/" \
--include-dir "/opt/homebrew/include/" \
--include-dir "/opt/homebrew/include/glib-2.0" \
--include-dir "/opt/homebrew/lib/glib-2.0/include" \
--output core/src/main/java \
--target-package "app.photofox.vipsffm.generated" \
--header-class-name "VipsRaw" \
--library "vips" \
@includes_filtered.txt \
"$LIBVIPS_ENTRY_PATH"
