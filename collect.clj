(use 'autodoc-collect.collect-info)
(collect-info-to-file 
  ;; Clojure repo directory
  "repo/"

  ;; Relative path in repo to Clojure source
  "src/main/clojure"

  ;; Analyze these namespaces 
  "clojure.core.cache"

  ;; Skip these namespaces
  "clojure/core.clj:clojure/parallel.clj" 

  ;; Trim prefix - don't set
  nil
 
  ;; Output analysis data file 
  "analysis.edn"

  ;; Branch name
  "master")
