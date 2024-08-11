#!/usr/bin/env bash
set -eou pipefail

IMAGEMAGICK_TAG="7.1.1-36"
IMAGEMAGICK_ZIP_SHA="3fbbb468ad6b08cf77846e439ce0d3e1559d399cf3797f3d985eeb7765a7bbd4"

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

echo "Setting up ImageMagick source..."

IMAGEMAGICK_SOURCE_PATH="ImageMagick-$IMAGEMAGICK_TAG"
IMAGEMAGICK_INCLUDES_PATH="$IMAGEMAGICK_SOURCE_PATH"
MAGICKWAND_INCLUDES_PATH="$IMAGEMAGICK_SOURCE_PATH/MagickWand"
MAGICKWAND_ENTRY_PATH="$MAGICKWAND_INCLUDES_PATH"/MagickWand.h
MAGICKWAND_CONFIG_PATH="$IMAGEMAGICK_INCLUDES_PATH"/MagickCore/magick-baseconfig.h

if [ ! -f "$MAGICKWAND_ENTRY_PATH" ] || [ ! -f "$MAGICKWAND_CONFIG_PATH" ]; then
  echo "  Downloading ImageMagick $IMAGEMAGICK_TAG..."
  gh release download --repo imagemagick/imagemagick "$IMAGEMAGICK_TAG" --archive=zip --skip-existing
  IMAGEMAGICK_ZIP_PATH="ImageMagick-$IMAGEMAGICK_TAG.zip"
  rm -rf "$IMAGEMAGICK_SOURCE_PATH"
  echo "$IMAGEMAGICK_ZIP_SHA" "$IMAGEMAGICK_ZIP_PATH" | sha256sum --check --status
  unzip "$IMAGEMAGICK_ZIP_PATH"
  (cd "ImageMagick-$IMAGEMAGICK_TAG"; ./configure)
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

rm includes_filtered.txt
touch includes_filtered.txt

{
  grep -E ' [A-Za-z0-9_]*Magick[A-Za-z0-9]*' includes.txt
  grep -E ' [A-Za-z0-9_]*Exception[A-Za-z0-9]*' includes.txt
  grep -E ' [A-Za-z0-9_]*Filter[A-Za-z0-9]*' includes.txt
  grep -E ' [A-Za-z0-9_]*Mogrify[A-Za-z0-9]*' includes.txt
  grep -E ' [A-Za-z0-9_]*Montage[A-Za-z0-9]*' includes.txt
  grep -E ' [A-Za-z0-9_]*(Pixel|Rectangle|Point|Segment|Image)Info' includes.txt
  grep -E ' [A-Za-z0-9_]*Wand[A-Za-z0-9]*' includes.txt
  grep -E ' [A-Za-z0-9_]+Command[A-Za-z0-9]*' includes.txt
  grep -E ' [A-Za-z0-9_]+Iterator[A-Za-z0-9]*' includes.txt
  grep -E ' [A-Za-z0-9_]+Handler' includes.txt
  grep -E ' [A-Za-z0-9_]+Type' includes.txt
} >> includes_filtered.txt

echo "Running jextract..."

"$JEXTRACT_DOWNLOAD_PATH"/bin/jextract \
--define-macro MAGICKCORE_HDRI_ENABLE \
--include-dir "$IMAGEMAGICK_INCLUDES_PATH" \
--output lib/src/main/java \
--target-package "app.photofox.imffm.generated" \
--library "MagickWand-7.Q16HDRI" \
@includes_filtered.txt \
"$MAGICKWAND_ENTRY_PATH"
