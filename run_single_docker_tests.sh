#!/usr/bin/env bash
set -eou pipefail

if [ -z "$1" ]; then
  echo "usage: ./run_single_docker_tests.sh ubuntu-2404"
  exit 1
fi

echo "building samples..."
./gradlew sample:shadowJar

echo "verifying docker test variant \"$1\" exists..."
if [ ! -d "docker_tests/$1" ]; then
  echo "could not find docker test variant - exiting"
  exit 1
fi

echo "running docker tests for variant $1..."
WORKSPACE_DIR="$PWD"

pushd "docker_tests/$1"
cp -r "$WORKSPACE_DIR"/sample .
cp "$WORKSPACE_DIR"/run_samples.sh .
docker build --progress=plain -t "vips-ffm-$1-test" .
docker run "vips-ffm-$1-test"
popd