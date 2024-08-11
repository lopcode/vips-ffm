#!/usr/bin/env bash
set -eou pipefail

if test -f native_libs/libvips.dylib; then
  echo "Symlink already set up" && exit 0
fi

echo "Setting up symlinks..."
ln -s "/opt/homebrew/lib/libvips.dylib" native_libs/libvips.dylib

echo "Done!"