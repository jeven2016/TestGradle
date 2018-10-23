package zjtech.rest.controller;

import java.util.Random;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/users")
public class UserController {

  private int getHash() {
    return this.hashCode();
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> findUserById(@PathVariable String id) {
    User user = new User();
    user.setName("user-" + id);
    user.setAge(new Random().nextInt(100));
    System.out.println(getHash() + " Get a user: " + user);
    return new ResponseEntity<User>(user, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity create(@RequestBody User user) {
    System.out.println(getHash() + " Post a user:" + user);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity update(@RequestBody User user) {
    System.out.println(getHash() + " Put a user:" + user);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<User> update(@PathVariable String id) {
    System.out.println(getHash() + " Delete a user:" + id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
