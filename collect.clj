(use 'autodoc-collect.collect-info)

(def custom-ns {
  "core.async"       "clojure.core.async:clojure.core.async.flow"
  "core.cache"       "clojure.core.cache"
  "core.specs.alpha" "clojure.core.specs.alpha"
  "java.jdbc"        "clojure.java.jdbc:clojure.java.jdbc.spec"
  "spec.alpha"       "clojure.spec.alpha:clojure.spec.gen.alpha:clojure.spec.test.alpha"
  "spec-alpha2"      "clojure.alpha.spec:clojure.alpha.spec.gen:clojure.alpha.spec.test"
  "tools.analyzer.jvm"  "clojure.tools.analyzer.jvm:clojure.tools.analyzer.jvm.utils:clojure.tools.analyzer.passes.jvm.analyze-host-expr:clojure.tools.analyzer.passes.jvm.annotate-branch:clojure.tools.analyzer.passes.jvm.annotate-host-info:clojure.tools.analyzer.passes.jvm.annotate-loops:clojure.tools.analyzer.passes.jvm.annotate-tags:clojure.tools.analyzer.passes.jvm.box:clojure.tools.analyzer.passes.jvm.classify-invoke:clojure.tools.analyzer.passes.jvm.constant-lifter:clojure.tools.analyzer.passes.jvm.emit-form:clojure.tools.analyzer.passes.jvm.fix-case-test:clojure.tools.analyzer.passes.jvm.infer-tag:clojure.tools.analyzer.passes.jvm.validate:clojure.tools.analyzer.passes.jvm.validate-loop-locals:clojure.tools.analyzer.passes.jvm.validate-recur:clojure.tools.analyzer.passes.jvm.warn-on-reflection"
  "tools.deps.alpha" "clojure.tools.cli.api:clojure.tools.cli.help:clojure.tools.deps.alpha:clojure.tools.deps.alpha.specs"
  "tools.deps" "clojure.tools.deps:clojure.tools.deps.specs"
  "tools.deps.cli" "clojure.tools.deps.cli.api:clojure.tools.deps.cli.help"
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
