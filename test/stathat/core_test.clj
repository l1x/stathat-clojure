(ns stathat.core-test
  (:require [clj-http.client :as http]
            [clojure.test :refer :all]
            [stathat.core :refer :all]))

;it should check if the ezkey is registered and fail if not
;http://www.stathat.com/docs/api

(deftest returns-200-on-post
  (testing "Testing is 200 is returned"
    (is (= 200 (:status (http/post (str "http://api.stathat.com/" "ez") {:ezkey "your@mail.com", 
                                                                         :stat  "my lucky number", 
                                                                         :count 13}))))))

