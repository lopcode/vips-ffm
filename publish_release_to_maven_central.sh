#!/usr/bin/env bash
set -eou pipefail

if [ -z "$1" ]; then
    echo "Usage: ./publish_release_to_maven_central.sh <github release>"
    exit 1
fi

if [ -n "$(git status --porcelain)" ]; then
  echo "there are local changes, not building (check \"git status\")"
  exit 1
fi

export GITHUB_VERSION=$1

(gh release list --json tagName,isDraft,isPrerelease | jq -e ".[] | select(.tagName == \"$GITHUB_VERSION\" and .isDraft == false and .isPrerelease == false)") || (echo "couldn't find release" && exit 1)
git fetch --tags
git checkout tags/"$GITHUB_VERSION"
git describe --exact-match --tags

SIGNING_KEY_ID=$(op read "op://Private/Sonatype GPG/key id") \
SIGNING_KEY_PASSPHRASE=$(op read "op://Private/Sonatype GPG/password") \
./gradlew clean core:compileJava core:packageMavenCentralRelease

MAVEN_CENTRAL_USER=$(op read "op://Private/New Maven Central Portal Publish/username")
MAVEN_CENTRAL_TOKEN=$(op read "op://Private/New Maven Central Portal Publish/password")
BEARER_TOKEN=$(echo "$MAVEN_CENTRAL_USER:$MAVEN_CENTRAL_TOKEN" | base64)

curl --request POST \
  --verbose \
  --header "Authorization: Bearer $BEARER_TOKEN" \
  --form bundle=@core/build/repos/release-"$GITHUB_VERSION".zip \
  https://central.sonatype.com/api/v1/publisher/upload?name="$GITHUB_VERSION"\&publishingType=USER_MANAGED