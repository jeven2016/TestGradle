package feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * A service client to call a remote rest microservice that wouldn't register on a specific eureka
 * node
 */
@FeignClient(name = "rest-service-1", configuration = FeignConfiguration.class)
public interface UserRestClient {

  @RequestMapping(method = RequestMethod.GET, value = "/demo/users/{id}")
  User findUserById(@PathVariable("id") String id);

  @RequestMapping(method = RequestMethod.POST, value = "/demo/users")
  ResponseEntity create(User user);

  @RequestMapping(method = RequestMethod.PUT, value = "/demo/users")
  ResponseEntity update(User user);

  @RequestMapping(method = RequestMethod.DELETE, value = "/demo/users/{id}", consumes = "application/json")
  ResponseEntity delete(@PathVariable("id") String id);

}
