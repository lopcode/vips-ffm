#!/usr/bin/env bash
set -eou pipefail

echo "building samples..."
./gradlew sample:clean sample:shadowJar

if [[ "$OSTYPE" == "darwin"* ]]; then
  export DYLD_LIBRARY_PATH=native_libs
fi

echo "running samples..."
java -jar sample/build/libs/sample-all.jar 2>&1 | tee sample_output.log

echo "checking for leaks..."
if grep --quiet "objects alive:" sample_output.log; then
  echo "failure - detected a memory leak!"
  exit 1
fi

echo "no leaks detected 🎉"