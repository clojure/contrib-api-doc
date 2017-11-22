(require '[autodoc.build-html :as h] 
         '[autodoc.params :as p]
         '[autodoc.doc-files :as d]
         '[clojure.edn :as e]) 
(import [java.io PushbackReader FileReader File]) 

(defn edn-read [f]
  (let [EOF (Object.)]
    (with-open [rdr (PushbackReader. (FileReader. (File. f)))]
      (e/read {:eof EOF} rdr))))

(def shared (edn-read "params.clj"))

(def custom
  {"core.cache" {:name "A caching library implementing various cache strategies"}
   "spec.alpha" {:name "Specifying the structure of data and functions."}
  })

(p/merge-params
  (merge shared
    {:project PROJECT
     :project-home (str "https://github.com/clojure/" PROJECT "/")
     :name PROJECT
     :page-title (str PROJECT " API Reference")
     :web-home (str "https://clojure.github.io/" PROJECT "/")
     :web-src-dir (str "https://github.com/clojure/" PROJECT "/blob/")
     :root (str (.getAbsolutePath (File. "repo")) "/")
     :output-path (str (.getAbsolutePath (File. "repo-docs")) "/")
     :branches [{:name "master" :version VERSION :status "in development"}]}
		(get custom PROJECT)))

(let [branch-info {:name "master" :version VERSION :status "in development" :first? true}
      all-branch-info (:branches shared)]
  (h/make-all-pages branch-info all-branch-info (edn-read "analysis.edn")))

(shutdown-agents)
