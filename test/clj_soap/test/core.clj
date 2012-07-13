(ns clj-soap.test.core
  (:use [clj-soap.core])
  (:use [clojure.test]))

(def test-value (ref false))

(defservice jp.myclass.MyApp
  (changeval [^String string] (dosync (ref-set test-value string)))
  (hypotenuse ^Double [^Double x ^Double y] (Math/sqrt (+ (* x x) (* y y))))
  (doubl1 (^String [^String x] (str x x))
          (^Double [^Double x] (+ x x)))
  (doubl2 (^Double [^Double x] (+ x x))
          (^String [^String x] (str x x))))

(deftest test-my-app
  (serve "jp.myclass.MyApp")
  (let [cl (client-fn "http://localhost:6060/axis2/services/MyApp?wsdl")]
    (is (= 5.0 (cl :hypotenuse 3 4)) "SOAP call with return value")
    (cl :changeval "piyopiyo")
    (is (= "piyopiyo" @test-value) "SOAP call without return value")
    ; Axis2 does not support method overloading.
    ;(is (= 10.0 (cl :doubl1 5.0)))
    ;(is (= "abcabc" (cl :doubl1 "abc")))
    ;(is (= 10.0 (cl :doubl2 5.0)))
    ;(is (= "abcabc" (cl :doubl2 "abc")))
    ))

