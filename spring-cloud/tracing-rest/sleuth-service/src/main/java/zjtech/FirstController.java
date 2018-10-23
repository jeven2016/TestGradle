package zjtech;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/first")
public class FirstController {


  @Autowired
  private RestTemplate restTemplate;

  @GetMapping
  public String sayHello(@Value("${server.port}") int port) {
    log.info("invoking second service");
    String msg = restTemplate.getForObject("http://localhost:9051/first", String.class);
    return "9051 response: " + msg;
  }

  @GetMapping("/error")
  public String errorTest() {
    return restTemplate.getForObject("http://localhost:9051/first/error", String.class);
  }

 /* @Scheduled(fixedRate = 10000)
  @GetMapping("/test")
  public String test() {
    IntStream.range(1, 20).forEach(val -> {
      long time = System.currentTimeMillis();
      log.info("info log :" + val + " " + time);
      log.info("warn log :" + val + " " + time);
      log.debug("debug log: " + val + " " + time);
    });
    return "ok";
  }*/

}
