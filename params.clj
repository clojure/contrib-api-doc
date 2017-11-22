{ ;; Build parameters shared across all branches
  :name "core.cache"
  :page-title "core.cache API Reference"
  :copyright "Copyright 2007-2017 by Rich Hickey and the various contributors"
  :source-path ["src/main/clojure"]
  ;; :param-dir "."
  ;; :template-dir "templates"
  :web-home "https://clojure.github.io/core.cache/"
  :web-src-dir "https://github.com/clojure/core.cache/blob/"
  :external-doc-tmpdir "tmp"
  :file-prefix ""
  :build-json-index false
  :build-raw-index false
  :scm-tool "git"
  :branches [{:name "master" :version :from-pom :status "stable"}]
}
