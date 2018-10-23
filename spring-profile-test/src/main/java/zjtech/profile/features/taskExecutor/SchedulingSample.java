package zjtech.profile.features.taskExecutor;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Notice that the methods to be scheduled must have void returns and must not expect any arguments.
 * If the method needs to interact with other objects from the Application Context, then those would
 * typically have been provided through dependency injection.
 */
@Component
public class SchedulingSample {

  @Scheduled(fixedDelay = 5000)
  public void sayHello() {
    System.out.println("fixedDelay = 5000");
  }

  @Scheduled(fixedRate = 3000)
  public void fixedRate() {
    System.out.println("fixedRate = 3000");
  }

  @Scheduled(initialDelay = 1000, fixedRate = 5000)
  public void doSomething3() {
    // something that should execute periodically
  }

  @Scheduled(cron = "*/5 * * * * MON-FRI")
  public void cron() {
    // something that should execute on weekdays only
  }
}
