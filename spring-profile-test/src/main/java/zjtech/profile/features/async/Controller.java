package zjtech.profile.features.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * 在service方法中业务逻辑如果碰到io操作时间比较长的操作，这样这个service方法就会长时间占用tomcat容器线程池中的线程，
 * 这样是不利于其他请求的处理的，当线程池中的线程处理任务时，任务由于长时间io操作，肯定会阻塞线程处理其他任务，
 * 引入异步servlet的目的就是将容器线程池和业务线程池分离开。在处理大io的业务操作的时候，把这个操作移动到业务线程池中进行，
 * 释放容器线程，使得容器线程处理其他任务，在业务逻辑执行完毕之后，然后在通知tomcat容器线程池来继续后面的操作，
 * 这个操作应该是把处理结果commit到客户端或者是dispatch到其他servlet上。
 *
 * servlet3 async 的基本原理就是：网络连接依旧在，提前释放tomcat处理线程用于提高吞吐量，响应流不关闭，由业务方法自己处理。
 * 从这个角度来看基于servlet3的异步化完全有可能实现真正的服务端push。
 */
@RestController
@RequestMapping("/async")
public class Controller {

  @Autowired
  private AsyncService service;

  @GetMapping
  public String testAsync() throws ExecutionException, InterruptedException {
    String threadName = "controller: " + Thread.currentThread().getName();
    notInvokeByNewThread(); // same thread
    Future<String> future = service.asyncMethod();
    return threadName + ", " + future.get();
  }


  /**
   * When a method return type is a Future, exception handling is easy – Future.get() method will
   * throw the exception
   */
  @GetMapping("/exception")
  public String testExcptionAsync() throws ExecutionException, InterruptedException {
    String threadName = "controller: " + Thread.currentThread().getName();
    try {
      service.asyncExceptionMethod();
    } catch (RuntimeException e) {
      threadName += ", got exception";
    }
    return threadName;
  }

  /**
   * But, if the return type is void, exceptions will not be propagated to the calling thread. Hence
   * we need to add extra configurations to handle exceptions.
   *
   * The exception will be handled by AsyncExceptionHandler
   */
  @GetMapping("/exception2")
  public String testExcptionAsync2() throws ExecutionException, InterruptedException {
    String threadName = "controller: " + Thread.currentThread().getName();
    try {
      //no exception wille be captured
      service.asyncExceptionMethodWithoutReturnType();
    } catch (RuntimeException e) {
      threadName += ", got exception";
    }
    return threadName;
  }


  @Async
  public void notInvokeByNewThread() {
    System.out.println("this method invoked by other methods of same class with share same thread");
  }


  /**
   * return response to client by DeferredResult
   */
  @GetMapping("/defer")
  public DeferredResult<String> defer() throws InterruptedException {
    DeferredResult<String> deferredResult = new DeferredResult<>();
    String threadName = "controller: " + Thread.currentThread().getName();
    service.asyncDefMethod(deferredResult);
    return deferredResult;
  }


}
