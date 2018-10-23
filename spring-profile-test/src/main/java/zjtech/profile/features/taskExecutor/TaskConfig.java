package zjtech.profile.features.taskExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableScheduling
public class TaskConfig {

  @Bean("taskExecutor")
  public TaskExecutor executor() {
    ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
    threadPoolTaskExecutor.setMaxPoolSize(4);
    threadPoolTaskExecutor.setBeanName("taskThread");
    threadPoolTaskExecutor.setCorePoolSize(3);
    threadPoolTaskExecutor.setKeepAliveSeconds(10);
    threadPoolTaskExecutor.setQueueCapacity(10);
    return threadPoolTaskExecutor;
  }
}
