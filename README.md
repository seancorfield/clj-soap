# clj-soap

clj-soap is SOAP server and client using Apache Axis2.

This version is updated from Tetsuya Takatsuru's version to use Clojure 1.4.0 (and modern contrib).

## Usage

### Client

You can call remote SOAP method as following:

  (require '[clj-soap.core :as soap])
  (let [client (soap/client-fn "http://... (URL for WSDL)")]
    (client :someMethod param1 param2 ...))

### Server

To make SOAP service:

  (require '[clj-soap.core :as soap])

  ;; Defining service class
  (soap/defservice my.some.SoapClass
    (someMethod ^String [^Integer x ^String s]
              (str "x is " x "\ts is " s)))

  ;; Start SOAP Service
  (serve "my.some.SoapClass")

`defservice` needs to be AOT-compiled.
For example, `lein compile` before running server.

#### Type Hint

SOAP services need typehints.
`String` for arguments nad `void` for return value,
if you don't specify typehints.

## License

Copyright (C) 2011 Tetsuya Takatsuru

Distributed under the Eclipse Public License, the same as Clojure.

