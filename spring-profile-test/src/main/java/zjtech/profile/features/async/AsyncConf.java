package zjtech.profile.features.async;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class AsyncConf implements AsyncConfigurer {

  /**
   * return a thread pool for executing async tasks
   */
  @Override
  public Executor getAsyncExecutor() {
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    return executorService;
  }

  /**
   * Register a default async exception handler
   */
  @Override
  public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
    return new AsyncExceptionHandler();
  }
}
