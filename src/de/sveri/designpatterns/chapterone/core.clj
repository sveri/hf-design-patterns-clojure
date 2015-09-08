(ns de.sveri.designpatterns.chapterone.core)

(derive ::rubber-duck ::duck)

(def rubber-duck {:type ::rubber-duck})
(def mallard-duck {:type ::mallard-duck})

(defn swim [duck]
  (println (str (:type duck) " is swimming")))

(swim rubber-duck)
(swim mallard-duck)


;(defmulti fly (fn [duck] (:type duck)))
;
;(defmethod fly ::rubber-duck [duck]
;  (println "R"))

(def fly-with-wings (println "flying with wings"))

(def fly-no-way (println "poor duck cannot fly"))


;
;(defprotocol Fly (fly [_] (println "I am flying")))
;
;(defprotocol Quack (quack [] (println "I am qucking")))
