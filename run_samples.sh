#!/usr/bin/env bash
set -eou pipefail

if [ -f "gradlew" ]; then
  echo "building samples..."
  ./gradlew sample:clean sample:shadowJar
else
  echo "skipping sample build as no gradle present..."
fi

export JAVA_PATH_OPTS=""
if [[ "$OSTYPE" == "darwin"* ]]; then
  export DYLD_LIBRARY_PATH=/opt/homebrew/lib
  # this tests the library path override feature
  export JAVA_PATH_OPTS="-Dvipsffm.libpath.vips.override=/opt/homebrew/lib/libvips.dylib"
fi

if test -f /usr/local/lib/libjemalloc.so; then
  echo "found jemalloc - using it"
  export LD_PRELOAD=/usr/local/lib/libjemalloc.so
fi

echo "running samples..."
java $JAVA_PATH_OPTS -jar sample/build/libs/sample-all.jar 2>&1 | tee sample_output.log

echo "checking for leaks..."
if grep --quiet "objects alive:" sample_output.log; then
  echo "failure - detected a memory leak!"
  exit 1
fi

echo "no leaks detected 🎉"