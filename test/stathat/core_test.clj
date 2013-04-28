(ns stathat.core-test
  (:require [clj-http.client :as http]
            [clojure.test :refer :all]
            [stathat.core :refer :all]))

(deftest returns-200-on-post
  (testing "Testing is 200 is returned"
    (is (= 200 (:status (http/post (str "http://api.stathat.com/" "ez") {:ezkey "leccine@gmail.com", 
                                                                         :stat  "Conus geographus", 
                                                                         :count 13}))))))

