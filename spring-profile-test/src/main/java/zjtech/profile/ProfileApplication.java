package zjtech.profile;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class ProfileApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(ProfileApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

  }
}
