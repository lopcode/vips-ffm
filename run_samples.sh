#!/usr/bin/env bash
set -eou pipefail

echo "building samples..."
./gradlew sample:clean sample:shadowJar

if [[ "$OSTYPE" == "darwin"* ]]; then
  export DYLD_LIBRARY_PATH=native_libs
fi

echo "running samples..."
java -jar sample/build/libs/sample-all.jar