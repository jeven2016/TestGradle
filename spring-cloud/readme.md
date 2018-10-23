### Test feign load balance function 
* test the feign client, the service 'rest-service-1' isn't registered on eureka,
but the ribbon is used as load balancer for 'rest-service-1'.

```bash 
 //start on 9010 port
 java -jar rest-service-demo-0.1.jar 
 
 //start on 9020 port
 java -jar rest-service-demo-0.1.jar --server.port=9020
 
 //start feign client on 9111 port
 java -jar feign-clients-1.0.0.jar 
 
 //send GET/POST/PUT/DELETE to users api, like:
 GET http://192.168.3.2:9111/users/111
 DELET http://192.168.3.2:9111/users/111
 PUT http://192.168.3.2:9111/users
 POST http://192.168.3.2:9111/users 
```