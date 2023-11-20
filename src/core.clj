;; (ns uprootiny.clerkinator
(ns uprootiny.clerkinator
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [nextjournal.clerk :as clerk]))

(defn clerkinator [dir]
  (let [files (->> dir
                   io/file
                   file-seq
                   (remove #(.isDirectory %))
                   (map #(.getName %)))]
    (clerk/show! (clerk/md "## Directory Contents\n\n"
                           (str/join "\n" files)))))
