#!/usr/bin/env bash
set -eou pipefail

echo "building samples..."
./gradlew sample:clean sample:shadowJar

echo "running docker tests..."
WORKSPACE_DIR="$PWD"

docker_tests=("debian-12" "ubuntu-2404" "liberica-22")
for docker_test in "${docker_tests[@]}"; do
  echo "testing \"$docker_test\""
  pushd "docker_tests/$docker_test"
  cp -r "$WORKSPACE_DIR"/sample .
  cp "$WORKSPACE_DIR"/run_samples.sh .
  docker build -t "vips-ffm-$docker_test-test" .
  docker run "vips-ffm-$docker_test-test"
  popd
done