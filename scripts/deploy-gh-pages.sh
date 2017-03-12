#!/bin/bash
set -e # Exit with nonzero exit code if anything fails

mkdir tmp
cd tmp

SOURCE_BRANCH="master"
TARGET_BRANCH="gh-pages"

# Pull requests and commits to other branches shouldn't try to deploy, just build to verify
if [ "$TRAVIS_PULL_REQUEST" != "false" -o -z "$TRAVIS_TAG" ]; then
    echo "Skipping deploy"
    exit 0
fi

# Save some useful information
REPO=`git config remote.origin.url`
REPO_WITH_TOKEN=${REPO/https:\/\/github.com\//https://${GH_TOKEN}@github.com/}

# Clone the existing gh-pages for this repo into out/
# Create a new empty branch if gh-pages doesn't exist yet (should only happen on first deply)
git clone $REPO src
cd src; git checkout $SOURCE_BRANCH

# Build
./gradlew uploadArchives

cd ..

git clone $REPO tgt
cd tgt; git checkout $TARGET_BRANCH || git checkout --orphan $TARGET_BRANCH

cd ..

# Copy output files
cp -r src/com/pileproject/drivecommand/* tgt/com/pileproject/drivecommand

# Now let's go have some fun with the cloned repo
cd tgt
git config --global user.email "travis@travis-ci.org"
git config --global user.name "Travis"

# If there are no changes (e.g. this is a README update) then just bail.
if [ -z `git diff --exit-code` ]; then
    echo "No changes to the spec on this push; exiting."
    exit 0
fi

# Commit the "changes", i.e. the new version.
# The delta will show diffs between new and old versions.
git add .
git commit -m "Release ${TRAVIS_TAG}"
git push --quiet $REPO_WITH_TOKEN $TARGET_BRANCH
