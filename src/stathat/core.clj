(ns stathat.core
  (:require [clj-http.client :as http])
  (:gen-class))

(defn- stathat-post [path parameters]
  "HTTP post request helper"
  (http/post (str "http://api.stathat.com/" path) {:form-params parameters}))

(defn- stathat-ez-value [ezkey stat value]
  "Sends a value to stathat via the EZ API"
  (stathat-post "ez" {:ezkey  ezkey
                      :stat   stat
                      :value  value}))

(defn- stathat-ez-count [ezkey stat ncount]
  "Sends a count to stathat via the EZ API"
  (stathat-post "ez" {:ezkey  ezkey
                      :stat   stat
                      :count  ncount}))

(defn- stathat-value [userkey statkey value]
  "Sends a value to stathat via the classic API"
  (stathat-post "v" {:ukey  userkey
                     :key   statkey
                     :value value}))

(defn- stathat-count [userkey statkey ncount]
  "Sends a count to stathat via the classic API"
  (stathat-post "c" {:ukey   userkey
                     :key    statkey
                     :count  ncount}))

(defn -main
  "Testing stathat.core"
  [& args]
  (alter-var-root #'*read-eval* (constantly false)))
  ;(stathat-ez-count "your@mail.com" "my lucky number" 13)
  
