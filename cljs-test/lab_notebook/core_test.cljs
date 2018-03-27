(ns lab-notebook.core-test
  (:require [cljs.test :refer-macros [async deftest is testing]]
            [lab-notebook.core :refer [delete ajax-get]]
            [clojure.string :as str]))

(def dummy-src "{'hello': 'world'} ")

(defn src->edn
  "Parse a JSON string into canonical Clojure EDN format."
  [src]
  (js->clj (.parse js/JSON
                   (str/replace src \' \"))
           :keywordize-keys true))

(deftest t-roger
  (is (= 0 0))
  (js/console.log :dummy-edn (src->edn dummy-src))
  (is (= {:hello "world"} (src->edn dummy-src))))

; not working
#_(deftest ajax-get-test
    (async done
      (ajax-get "http://www.lispcast.com/"
                (fn [response]
                  (is (= 200 (:status response)))
                  (done)))))


