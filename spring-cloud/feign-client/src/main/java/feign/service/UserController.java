package feign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserRestClient client;

  @GetMapping("/{id}")
  User findUserById(@PathVariable("id") String id) {
    return client.findUserById(id);
  }

  @PostMapping
  ResponseEntity create() {
    User user = new User();
    user.setAge(22);
    user.setName("sdklsd");
    return client.create(user);
  }

  @PutMapping
  ResponseEntity update() {
    User user = new User();
    user.setAge(22);
    user.setName("sdklsd");
    return client.update(user);
  }

  @DeleteMapping("/{id}")
  ResponseEntity delete(@PathVariable("id") String id) {
    return client.delete(id);
  }
}
