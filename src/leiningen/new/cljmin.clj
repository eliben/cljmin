(ns leiningen.new.cljmin
  (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files]]))

(def render (renderer "cljmin"))

(defn cljmin
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (->files data ["src/{{sanitized}}/core.clj" (render "core.clj" data)]
["project.clj" (render "project.clj" data)]
)))