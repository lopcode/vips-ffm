#!/usr/bin/env bash
set -eou pipefail

if [ "$#" -ne 1 ]; then
  echo "usage: ./bump_libvips_version.sh 8.18.7"
  exit 1
fi

LIBVIPS_VERSION="${1#v}"
LIBVIPS_TAG="v$LIBVIPS_VERSION"

git submodule update --init libvips

if [ -n "$(git -C libvips status --porcelain)" ]; then
  echo "libvips submodule has local changes - clean it before bumping"
  exit 1
fi

echo "Fetching libvips tags..."
git -C libvips fetch --tags origin

if ! git -C libvips rev-parse --verify --quiet "refs/tags/$LIBVIPS_TAG" > /dev/null; then
  echo "Could not find libvips tag \"$LIBVIPS_TAG\""
  exit 1
fi

echo "Checking out $LIBVIPS_TAG..."
git -C libvips checkout --quiet "$LIBVIPS_TAG"
# git submodule update checks out the commit in the index, so stage the new one
git add libvips

sed -i '' "s/^LIBVIPS_VERSION=.*/LIBVIPS_VERSION=\"$LIBVIPS_VERSION\"/" setup_development.sh
grep -q "^LIBVIPS_VERSION=\"$LIBVIPS_VERSION\"$" setup_development.sh
sed -i '' "s/^generated from libvips \`[^\`]*\`/generated from libvips \`$LIBVIPS_VERSION\`/" README.md
grep -q "^generated from libvips \`$LIBVIPS_VERSION\`" README.md

git submodule status libvips

./setup_development.sh
./generate_ffm_bindings.sh

echo "Bumped libvips to $LIBVIPS_VERSION"
