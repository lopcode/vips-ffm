#!/usr/bin/env bash
set -eou pipefail

# check imagemagick 7 is installed
echo "Checking if ImageMagick 7 is installed..."
magick --version | grep --quiet "ImageMagick 7" || (echo "ImageMagick 7 not installed" && exit 1)

# check at least JDK 22 used
echo "Checking JDK version >= 22..."
java --version | grep --quiet "build 22" || (echo "Not using JDK 22 or above" && exit 1)

# check if jextract is installed
# https://jdk.java.net/jextract/
echo "Checking jextract exists..."
JEXTRACT_DOWNLOAD_URL=https://download.java.net/java/early_access/jextract/22/5/openjdk-22-jextract+5-33_macos-aarch64_bin.tar.gz
JEXTRACT_ZIP_CHECKSUM_SHA256=2a4411c32aedb064c3e432eb8a2791e6e60fea452330c71386f6573dc4c9c850
JEXTRACT_DOWNLOAD_PATH=jextract-22
"$JEXTRACT_DOWNLOAD_PATH"/bin/jextract --version || (echo "Downloading jextract..." \
&& curl --output jextract.tar.gz https://download.java.net/java/early_access/jextract/22/5/openjdk-22-jextract+5-33_macos-aarch64_bin.tar.gz \
&& (echo "$JEXTRACT_ZIP_CHECKSUM_SHA256" jextract.tar.gz | sha256sum --check --status) \
&& tar -xvzf jextract.tar.gz)

# todo: better way of finding these headers not reliant on macos/brew
echo "Finding MagickWand headers..."
IMAGEMAGICK_INCLUDES_PATH=$(find -s /opt/homebrew/Cellar/imagemagick/7*/include/ImageMagick-7 -type d -depth 0 | head -n 1)
MAGICKWAND_INCLUDES_PATH=$(find "$IMAGEMAGICK_INCLUDES_PATH" -name MagickWand -type d -depth 1 | head -n 1)
MAGICKWAND_ENTRY_PATH="$MAGICKWAND_INCLUDES_PATH"/MagickWand.h

if ! test -f "$MAGICKWAND_ENTRY_PATH"; then
  echo "Failed to find MagickWand.h" && exit 1
fi
echo "  Found ImageMagick headers at \"$IMAGEMAGICK_INCLUDES_PATH\"..."
echo "  Found MagickWand headers at \"$MAGICKWAND_INCLUDES_PATH\"..."

echo "Clearing generated files..."

rm -rf lib/src/main/java/app/photofox/imffm/generated || true

echo "Dumping all discovered includes..."

"$JEXTRACT_DOWNLOAD_PATH"/bin/jextract \
--define-macro MAGICKCORE_HDRI_ENABLE \
--include-dir "$IMAGEMAGICK_INCLUDES_PATH" \
--library "MagickWand-7.Q16HDRI" \
--dump-includes includes.txt \
"$MAGICKWAND_ENTRY_PATH"

echo "Filtering includes..."

grep -E ' [A-Za-z0-9_]*Magick[A-Za-z0-9]*' includes.txt > includes_filtered.txt
grep -E ' [A-Za-z0-9_]*Exception[A-Za-z0-9]*' includes.txt >> includes_filtered.txt
grep -E ' [A-Za-z0-9_]*Filter[A-Za-z0-9]*' includes.txt >> includes_filtered.txt
grep -E ' [A-Za-z0-9_]*Mogrify[A-Za-z0-9]*' includes.txt >> includes_filtered.txt
grep -E ' [A-Za-z0-9_]*Montage[A-Za-z0-9]*' includes.txt >> includes_filtered.txt
grep -E ' [A-Za-z0-9_]*(Pixel|Rectangle|Point|Segment|Image)Info' includes.txt >> includes_filtered.txt
grep -E ' [A-Za-z0-9_]*Wand[A-Za-z0-9]*' includes.txt >> includes_filtered.txt
grep -E ' [A-Za-z0-9_]+Command[A-Za-z0-9]*' includes.txt >> includes_filtered.txt
grep -E ' [A-Za-z0-9_]+Iterator[A-Za-z0-9]*' includes.txt >> includes_filtered.txt
grep -E ' [A-Za-z0-9_]+Handler' includes.txt >> includes_filtered.txt
grep -E ' [A-Za-z0-9_]+Type' includes.txt >> includes_filtered.txt

echo "Running jextract..."

"$JEXTRACT_DOWNLOAD_PATH"/bin/jextract \
--define-macro MAGICKCORE_HDRI_ENABLE \
--include-dir "$IMAGEMAGICK_INCLUDES_PATH" \
--output lib/src/main/java \
--target-package "app.photofox.imffm.generated" \
--library "MagickWand-7.Q16HDRI" \
@includes_filtered.txt \
"$MAGICKWAND_ENTRY_PATH"
