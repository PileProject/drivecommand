#!/bin/bash
set -eu

# get the remote URL
REPO=`git config remote.origin.url`
REPO_WITH_TOKEN=${REPO/https:\/\/github.com\//https://${GH_TOKEN}@github.com/}

rootdir=`pwd`
tmpdir="${rootdir}/`mktemp -d`"

git clone $REPO $tmpdir
cd $tmpdir

# build a release
./gradlew deploy -Ptag=$TRAVIS_TAG

# commit the changes
git config --global user.email "travis@travis-ci.org"
git config --global user.name "Travis"

git add .
git commit -m "Release ${TRAVIS_TAG}"
git push --quiet $REPO_WITH_TOKEN master

echo "Released ${TRAVIS_TAG}"
