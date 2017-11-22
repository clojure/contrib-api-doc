(use 'autodoc-collect.collect-info)
(collect-info-to-file 
  ;; Repo directory
  "repo/"

  ;; Relative path in repo to source
  "src/main/clojure"

  ;; Analyze these namespaces 
  "clojure.core.cache"

  ;; Skip loading these namespaces
  ""

  ;; Trim prefix - don't set
  nil
 
  ;; Output analysis data file
  "analysis.edn"

  ;; Branch name
  "master")
