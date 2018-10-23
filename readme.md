### build a sub project
```bash
gradle :spring-cloud:feign-client:clean build
or
gradle clean build -p spring-cloud/feign-client
```

### list all projects
```bash
 gradle projects
```

### Port occupation
```bash
* registry-service: 9001, 9002
* rest-service-demo: 9010
* zuul-proxy: 9020
* auth: 9030
* config-server:9040
* sleuth-service:9050
* zipkin-server: 9060
```
