package zjtech.profile.features.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service
public class AsyncService {

  /**
   * if no thread pool configured, this method will be called in a new created thread
   */
  @Async
  public Future<String> asyncMethod() throws InterruptedException {
    TimeUnit.SECONDS.sleep(3);
    String msg = "service: " + Thread.currentThread().getName();
    return new AsyncResult<>(msg);
  }

  @Async
  public void asyncDefMethod(DeferredResult<String> deferredResult) throws InterruptedException {
    TimeUnit.SECONDS.sleep(5);
    String msg = "service: " + Thread.currentThread().getName();
    deferredResult.setResult(msg);
  }

  @Async
  public MyAsyncResult<Object> asyncExceptionMethod() {
    /* throw new RuntimeException("a exception"); */
    return new MyAsyncResult<Object>(null);
  }

  @Async
  public void asyncExceptionMethodWithoutReturnType() {
    throw new RuntimeException("a exception");
  }


  class MyAsyncResult<V> extends AsyncResult<V> {

    MyAsyncResult(V value) {
      super(value);
    }

    @Override
    public V get() throws ExecutionException {
      throw new RuntimeException("a exception");
    }
  }

}
