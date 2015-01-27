(ns stathat.core-test
  (:require [clojure.test :refer :all]
            [org.httpkit.client :as http]
            [stathat.core :refer :all]))

;; it should check if the ezkey is registered and fail if not
;; http://www.stathat.com/docs/api

(deftest returns-200-on-post
  (testing "Testing is 200 is returned"
    (is (= 200 (:status @(http/post (str "http://api.stathat.com/" "ez")
                                    {:form-params
                                     {:ezkey "your@mail.com"
                                      :stat  "my lucky number" 
                                      :count 13}}))))))
