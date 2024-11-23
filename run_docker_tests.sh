#!/usr/bin/env bash
set -eou pipefail

echo "building samples..."
./gradlew sample:clean sample:shadowJar

echo "running docker tests..."
WORKSPACE_DIR="$PWD"

pushd docker_tests/debian-12
cp -r "$WORKSPACE_DIR"/sample .
cp "$WORKSPACE_DIR"/run_samples.sh .
docker build -t vips-ffm-debian-test .
docker run vips-ffm-debian-test
popd