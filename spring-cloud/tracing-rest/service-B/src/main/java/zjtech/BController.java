package zjtech;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/first")
public class BController {

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping
  public String sayHello() {
    try {
      TimeUnit.MICROSECONDS.sleep(50);
    } catch (InterruptedException e) {
      log.warn("exception encountered.", e);
    }
    return "OK";
  }

  @GetMapping("/error")
  public String errorTest() {
    throw new RuntimeException("A error encountered in service-B");
  }
}
