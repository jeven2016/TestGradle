### 34.2.1 TaskExecutor types
There are a number of pre-built implementations of TaskExecutor included with the Spring distribution. In all likelihood, you shouldn’t ever need to implement your own.

* <b>SimpleAsyncTaskExecutor</b>  
   This implementation does not reuse any threads, rather it starts up a new thread for each invocation. However, it does support a concurrency limit which will block any invocations that are over the limit until a slot has been freed up. If you are looking for true pooling, see the discussions of SimpleThreadPoolTaskExecutor and ThreadPoolTaskExecutor below.
* <b>SyncTaskExecutor</b>  
   This implementation doesn’t execute invocations asynchronously. Instead, each invocation takes place in the calling thread. It is primarily used in situations where multi-threading isn’t necessary such as simple test cases.
* <b>ConcurrentTaskExecutor</b>  
    This implementation is an adapter for a java.util.concurrent.Executor object. There is an alternative, ThreadPoolTaskExecutor, that exposes the Executor configuration parameters as bean properties. It is rare to need to use the ConcurrentTaskExecutor, but if the ThreadPoolTaskExecutor isn’t flexible enough for your needs, the ConcurrentTaskExecutor is an alternative.
* <b>SimpleThreadPoolTaskExecutor</b>  
    This implementation is actually a subclass of Quartz’s SimpleThreadPool which listens to Spring’s lifecycle callbacks. This is typically used when you have a thread pool that may need to be shared by both Quartz and non-Quartz components.
* <b>ThreadPoolTaskExecutor</b>  
    This implementation is the most commonly used one. It exposes bean properties for configuring a java.util.concurrent.ThreadPoolExecutor and wraps it in a TaskExecutor. If you need to adapt to a different kind of java.util.concurrent.Executor, it is recommended that you use a ConcurrentTaskExecutor instead.
* <b>WorkManagerTaskExecutor</b>  
    CommonJ is a set of specifications jointly developed between BEA and IBM. These specifications are not Java EE standards, but are standard across BEA’s and IBM’s Application Server implementations.
    This implementation uses the CommonJ WorkManager as its backing implementation and is the central convenience class for setting up a CommonJ WorkManager reference in a Spring context. Similar to the SimpleThreadPoolTaskExecutor, this class implements the WorkManager interface and therefore can be used directly as a WorkManager as well.