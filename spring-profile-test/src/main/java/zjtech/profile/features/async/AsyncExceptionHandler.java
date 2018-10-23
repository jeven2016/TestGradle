package zjtech.profile.features.async;

import static java.lang.System.out;

import java.lang.reflect.Method;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

  /**
   * We’ll create a custom async exception handler by implementing AsyncUncaughtExceptionHandler
   * interface. The handleUncaughtException() method is invoked when there are any uncaught
   * asynchronous exceptions:
   */
  @Override
  public void handleUncaughtException(Throwable ex, Method method, Object... params) {
    String msg;
    msg = String
        .format("Unexpected error occurred invoking async method '%s'.", method, ex.getMessage());
    out.println(msg);
  }
}
