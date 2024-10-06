#!/usr/bin/env bash
set -eou pipefail

# Regenerates docs and checks for git changes

./build_docs.sh

if [ -n "$(git status --porcelain)" ]; then
  echo "there are local changes after regenerating docs, failing"
  exit 1
fi

exit 0