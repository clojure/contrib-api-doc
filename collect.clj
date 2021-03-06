(use 'autodoc-collect.collect-info)

(def custom-ns {
  "core.async"       "clojure.core.async"
  "core.cache"       "clojure.core.cache"
  "java.jdbc"        "clojure.java.jdbc:clojure.java.jdbc.spec"
  "spec.alpha"       "clojure.spec.alpha:clojure.spec.gen.alpha:clojure.spec.test.alpha"
  "spec-alpha2"      "clojure.spec-alpha2:clojure.spec-alpha2.gen:clojure.spec-alpha2.test"
  "tools.analyzer.jvm"  "clojure.tools.analyzer.jvm:clojure.tools.analyzer.jvm.utils:clojure.tools.analyzer.passes.jvm.analyze-host-expr:clojure.tools.analyzer.passes.jvm.annotate-branch:clojure.tools.analyzer.passes.jvm.annotate-host-info:clojure.tools.analyzer.passes.jvm.annotate-loops:clojure.tools.analyzer.passes.jvm.annotate-tags:clojure.tools.analyzer.passes.jvm.box:clojure.tools.analyzer.passes.jvm.classify-invoke:clojure.tools.analyzer.passes.jvm.constant-lifter:clojure.tools.analyzer.passes.jvm.emit-form:clojure.tools.analyzer.passes.jvm.fix-case-test:clojure.tools.analyzer.passes.jvm.infer-tag:clojure.tools.analyzer.passes.jvm.validate:clojure.tools.analyzer.passes.jvm.validate-loop-locals:clojure.tools.analyzer.passes.jvm.validate-recur:clojure.tools.analyzer.passes.jvm.warn-on-reflection"
  "tools.deps.alpha" "clojure.tools.cli.api:clojure.tools.deps.alpha:clojure.tools.deps.alpha.reader:clojure.tools.deps.alpha.extensions:clojure.tools.deps.alpha.specs:clojure.tools.deps.alpha.util.coll:clojure.tools.deps.alpha.util.dir:clojure.tools.deps.alpha.util.io:clojure.tools.deps.alpha.util.maven:clojure.tools.deps.alpha.util.session"
  "tools.deps.graph" "clojure.tools.deps.graph"
  "tools.gitlibs" "clojure.tools.gitlibs"
  "data.int-map" "clojure.data.int-map"
  })

(def custom-trim {
  "tools.analyzer.jvm" "clojure.tools.analyzer."
  "tools.deps.graph" "clojure.tools.deps."
  "tools.gitlibs" "clojure.tools.gitlibs."
  "data.int-map" "clojure.data.int-map."
  })

(collect-info-to-file 
  ;; Repo directory
  "repo/"

  ;; Relative path in repo to source
  "src/main/clojure"

  ;; Analyze these namespaces
  (or (get custom-ns PROJECT) (str "clojure." PROJECT))

  ;; Skip loading these namespaces
  ""

  ;; Trim prefix
  (get custom-trim PROJECT) ;; usually nil
 
  ;; Output analysis data file
  "analysis.edn"

  ;; Branch name
  "master")
