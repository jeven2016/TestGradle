package zjtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class SleuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(SleuthApplication.class, args);
  }

  @Bean
  public RestTemplate localRestClient() {
    return new RestTemplate();
  }

  @Bean
  public AlwaysSampler defaultSampler() {
    return new AlwaysSampler();
  }

}
