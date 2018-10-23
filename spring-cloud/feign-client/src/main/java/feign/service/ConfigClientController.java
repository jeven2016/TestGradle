package feign.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@RefreshScope
public class ConfigClientController {

  // modify this field and submit into gitlab and it should be refreshed then
  @Value("${config.param.appName}")
  private String appName;

  @GetMapping
  public String getMessage() {
    return appName;
  }
}


