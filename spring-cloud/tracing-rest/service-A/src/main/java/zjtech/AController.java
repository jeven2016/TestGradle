package zjtech;

import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/first")
public class AController {

  @Autowired
  private Tracer tracer;

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping
  public String sayHello() {
    Span span = tracer.getCurrentSpan();
    for (Entry<String, String> stringStringEntry : span.baggageItems()) {
      log.info("key={}, value={}", stringStringEntry.getKey(), stringStringEntry.getValue());
    }

    try {
      TimeUnit.MICROSECONDS.sleep(20);
    } catch (InterruptedException e) {
      log.warn("exception encountered.", e);
    }
    String msg = restTemplate.getForObject("http://localhost:9052/first", String.class);
    return "9052 response: " + msg;
  }

  @GetMapping("/error")
  public String errorTest() {
    return restTemplate.getForObject("http://localhost:9052/first/error", String.class);
  }
}
