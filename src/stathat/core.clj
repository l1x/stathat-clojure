(ns stathat.core
  (:gen-class))


(defun stathat-post [path parameters]
  "HTTP post request helper"
  (http-request (format "http://api.stathat.com/~A" path)
                :method :post
                :parameters parameters))

(defun stathat-ez-value (ezkey stat value)
  "Sends a value to stathat via the EZ API"
  (stathat-post "ez" '(("ezkey" . ezkey)
                       ("stat" . stat)
                       ("value" . value))))

(defun stathat-ez-count (ezkey stat ncount)
  "Sends a count to stathat via the EZ API"
  (stathat-post "ez" '(("ezkey" . ezkey)
                       ("stat" . stat)
                       ("count" . ncount))))

(defun stathat-value (userkey statkey value)
  "Sends a value to stathat via the classic API"
  (stathat-post "v" '(("ukey" . userkey)
                       ("key" . statkey)
                       ("value" . value))))

(defun stathat-count (userkey statkey ncount)
  "Sends a count to stathat via the classic API"
  (stathat-post "c" '(("ukey" . userkey)
                       ("key" . statkey)
                       ("count" . ncount))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println "Hello, World!"))
