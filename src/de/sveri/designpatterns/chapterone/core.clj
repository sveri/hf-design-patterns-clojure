(ns de.sveri.designpatterns.chapterone.core)


(def fly-with-wings (println "flying with wings"))
(def fly-no-way (println "poor duck cannot fly"))

(def quack-duck (println "Duck is Quacking"))
(def squeak-duck (println "Duck is Squeaking"))
(def mute-duck (println "Duck is quiet"))


(derive ::rubber-duck ::duck)

(def rubber-duck {:type ::rubber-duck :fly-fn fly-no-way :quack-fn quack-duck})
(def mallard-duck {:type ::mallard-duck :fly-fn fly-with-wings :quack-fn squeak-duck})

(defn swim [duck]
  (println (str (:type duck) " is swimming")))

(swim rubber-duck)
(swim mallard-duck)

;(defn fly [duck]
;  (:fly-fn duck))
;
;(fly rubber-duck)
;(fly mallard-duck)
;
;(defn quack [duck]
;  (:quack-fn duck))
;
;(quack rubber-duck)
;(quack mallard-duck)