(defproject org.clojars.seancorfield/clj-soap "0.2.0-SNAPSHOT"
  :description "SOAP Client and Server using Apache Axis2."
  :url "https://bitbucket.org/taka2ru/clj-soap"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/core.incubator "0.1.1"]
                 [org.apache.axis2/axis2-adb "1.6.2"]
                 [org.apache.axis2/axis2-transport-http "1.6.2"]
                 [org.apache.axis2/axis2-transport-local "1.6.2"]]
  :source-paths ["src" "test"]
  :aot [clj-soap.test.core])

