(ns de.sveri.designpatterns.chapterone.core)

; Two different fly behaviors
(defn fly-with-wings [] (println "Flying with wings."))
(defn fly-no-way [] (println "Poor duck cannot fly."))

; Three different Quack behaviors
(defn quack-duck [] (println "Duck is Quacking."))
(defn squeak-duck [] (println "Duck is Squeaking."))
(defn mute-duck [] (println "Duck is quiet."))

; Define a relationship, this means that rubber-duck `is-a` duck
(derive ::rubber-duck ::duck)

; Define two Duck entities with different flay and quack behaviors
(def rubber-duck {:type ::rubber-duck :fly-fn fly-no-way :quack-fn quack-duck})
(def mallard-duck {:type ::mallard-duck :fly-fn fly-with-wings :quack-fn squeak-duck})

; Swim function, does the same for all ducks
(defn swim [duck]
  (println (str (:type duck) " is swimming.")))

; Fly function, accepting a duck entity and calling the defined fly behavior
(defn fly [duck]
  ((:fly-fn duck)))

; Quack function, accepting a duck entity and calling the defined fly behavior
(defn quack [duck]
  ((:quack-fn duck)))

; Display function, dispatching on the type of the duck and executing different actions
(defmulti display (fn [duck] (:type duck)))

(defmethod display ::rubber-duck [duck]
  (println "Displaying Rubber Duck."))

(defmethod display ::mallard-duck [duck]
  (println "Displaying Mallard Duck."))

(swim rubber-duck)
(swim mallard-duck)

(fly rubber-duck)
(fly mallard-duck)

(quack rubber-duck)
(quack mallard-duck)

(display rubber-duck)
(display mallard-duck)

; Output
;
;:de.sveri.designpatterns.chapterone.core/rubber-duck is swimming.
;:de.sveri.designpatterns.chapterone.core/mallard-duck is swimming.
;Poor duck cannot fly.
;Flying with wings.
;Duck is Quacking.
;Duck is Squeaking.
;Displaying Rubber Duck.
;Displaying Mallard Duck.