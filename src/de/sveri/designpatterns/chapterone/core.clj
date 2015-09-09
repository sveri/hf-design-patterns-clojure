(ns de.sveri.designpatterns.chapterone.core)


(defn fly-with-wings [] (println "Flying with wings."))
(defn fly-no-way [] (println "Poor duck cannot fly."))

(defn quack-duck [] (println "Duck is Quacking."))
(defn squeak-duck [] (println "Duck is Squeaking."))
(defn mute-duck [] (println "Duck is quiet."))
;
;
(derive ::rubber-duck ::duck)

(def rubber-duck {:type ::rubber-duck :fly-fn fly-no-way :quack-fn quack-duck})
(def mallard-duck {:type ::mallard-duck :fly-fn fly-with-wings :quack-fn squeak-duck})
;
(defn swim [duck]
  (println (str (:type duck) " is swimming.")))

(swim rubber-duck)
(swim mallard-duck)

(defn fly [duck]
  ((:fly-fn duck)))

(fly rubber-duck)
(fly mallard-duck)

(defn quack [duck]
  ((:quack-fn duck)))

(quack rubber-duck)
(quack mallard-duck)

(defmulti display (fn [duck] (:type duck)))

(defmethod display ::rubber-duck [duck]
  (println "Displaying Rubber Duck."))

(defmethod display ::mallard-duck [duck]
  (println "Displaying Mallard Duck."))

(display rubber-duck)
(display mallard-duck)