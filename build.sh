#!/bin/bash

set -e

# TODO - remove
PROJECT=core.cache

# Create or refresh repo
if [[ ! -d repo ]]; then
  echo "Creating new repo area"
  git clone "git@github.com:clojure/$PROJECT.git" repo
else
  echo "Refreshing repo area"
  (cd repo && git fetch && git reset --hard)
fi

# Create or clean output directory
if [[ ! -d repo-docs ]]; then
  echo "Creating new gh-pages area"
  git clone "git@github.com:clojure/$PROJECT.git" repo-docs
  (cd repo-docs && git checkout gh-pages)
else
  echo "Refreshing gh-pages area"
  (cd repo-docs && git fetch && git reset --hard)
fi
rm -rf repo-docs/*

# Copy stable site files
echo "Copying static site files"
cp -R site/* repo-docs

# Run autodoc-collect
echo "Analyzing $PROJECT"
rm -f analysis.edn
cat collect.clj | clojure -C:collect -

# Run autodoc
echo "Building $PROJECT"
cat build.clj | clojure -R:build -

# Commit
if [[ ! -z "$COMMIT" ]]; then
  echo "Committing updated gh-pages branch"
  cd repo-docs
  git add -u -v
  git commit -m "Autodoc commit"
  git config --global push.default simple
  git push
fi
