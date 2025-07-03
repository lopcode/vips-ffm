#!/usr/bin/env bash
set -eou pipefail

echo "building samples..."
./gradlew sample:shadowJar

echo "running all docker tests..."

docker_tests=("ubuntu-2404-jemalloc" "debian-12" "ubuntu-2404")
for docker_test in "${docker_tests[@]}"; do
  ./run_single_docker_tests.sh "$docker_test" || (echo "test failed" && exit 1)
done