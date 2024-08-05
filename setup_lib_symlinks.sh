#!/usr/bin/env bash
set -eou pipefail

echo "Finding ImageMagick lib folder..."
IMAGEMAGICK_LIB_PATH=$(find -s /opt/homebrew/Cellar/imagemagick/7*/lib -type d -depth 0 | head -n 1)
echo "  Found at \"$IMAGEMAGICK_LIB_PATH\""

if test -f libs/libMagickWand-7.Q16HDRI.dylib; then
  echo "Symlink already set up" && exit 0
fi

echo "Setting up symlinks..."
ln -s "$IMAGEMAGICK_LIB_PATH"/libMagickWand-7.Q16HDRI.dylib libs/libMagickWand-7.Q16HDRI.dylib
ln -s "$IMAGEMAGICK_LIB_PATH"/libMagickCore-7.Q16HDRI.dylib libs/libMagickCore-7.Q16HDRI.dylib

echo "Done!"