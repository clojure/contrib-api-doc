(use 'autodoc-collect.collect-info)

(def custom {
  "spec.alpha"       "clojure.spec.alpha:clojure.spec.gen.alpha:clojure.spec.test.alpha"
  })

(collect-info-to-file 
  ;; Repo directory
  "repo/"

  ;; Relative path in repo to source
  "src/main/clojure"

  ;; Analyze these namespaces
  (or (get custom PROJECT) (str "clojure." PROJECT))

  ;; Skip loading these namespaces
  ""

  ;; Trim prefix - don't set
  nil
 
  ;; Output analysis data file
  "analysis.edn"

  ;; Branch name
  "master")
