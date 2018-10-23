### tracing each rest request and sending reports to zipin-server service

case 1:
  * send request to http://localhost:9050/first (sleuth-service)
  * the request is forwarded as this:  
    sleuth-service(http://ip:9050/first) -----> service-A (port:9051) -----> service-B (port:9052)
  * check the zipkin GUI , there you could see more details about the tracing workflow

case 2:
  * the service-B will throw a runtime exception to verify if the zipkin can reflect this case
  * the request is forwarded as this:  
      sleuth-service(http://ip:9050/first/error) -----> service-A (port:9051) -----> service-B (a exception thrown)
   
case 3:
  * the zipkin-stream-server is used for tracing spring cloud stream with kafka, and the zipkin can reflect the kafka message flow.
  * the service-A/B and sleuth-service doesn't support stream.
     