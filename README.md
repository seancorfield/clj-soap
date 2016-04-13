# THIS PROJECT IS NO LONGER MAINTAINED!

I forked it purely to get it running on Clojure 1.3 and then found it didn't do what I needed anyway.

If you think it might be useful to you, please fork it and maintain it yourself. If you decide to take over as lead maintainer, let me know and I'll update this readme to point to your new fork.

## Other SOAP-related Clojure projects that might interest you

* [soap-box](https://github.com/slipset/soap-box) -- an example of how to build a simple SOAP web service (server).

# clj-soap

clj-soap is SOAP server and client using Apache Axis2.

This version is updated from Tetsuya Takatsuru's version to use Clojure 1.5.1 (and modern contrib). Note however that I am not actively maintaining this library and would welcome someone taking it over. I updated Tetsuya's code to use a more modern Clojure environment purely to test it for a problem I was working on - it didn't really do what I needed so I took a different approach (using Axis 1.x libraries at a much lower level for one specific web service).

## Usage

### Client

You can call remote SOAP method as following:
```clojure
(require '[clj-soap.core :as soap])

(let [client (soap/client-fn "http://... (URL for WSDL)")]
  (client :someMethod param1 param2 ...))
```
### Server

To make SOAP service:
```clojure
(require '[clj-soap.core :as soap])

;; Defining service class
(soap/defservice my.some.SoapClass
  (someMethod ^String [^Integer x ^String s]
              (str "x is " x "\ts is " s)))

;; Start SOAP Service
(serve "my.some.SoapClass")
```
`defservice` needs to be AOT-compiled.
For example, `lein compile` before running server.

#### Type Hint

SOAP services need typehints.
`String` for arguments and `void` for return value,
if you don't specify typehints.

## License

Copyright (C) 2011 Tetsuya Takatsuru

Distributed under the Eclipse Public License, the same as Clojure.

