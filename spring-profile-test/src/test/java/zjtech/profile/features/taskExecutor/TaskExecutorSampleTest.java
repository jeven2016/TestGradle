package zjtech.profile.features.taskExecutor;


import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskExecutorSampleTest {

  @Autowired
  TaskExecutorSample taskExecutorSample;

  @Autowired
  SchedulingSample schedulingSample;

  @Test
  public void testTask() {
    taskExecutorSample.runTask();
  }

  @Test
  public void scheduleFixDelay() {
    schedulingSample.sayHello();
  }

  @Test
  public void fixedRate() throws InterruptedException {
    schedulingSample.fixedRate();

    TimeUnit.SECONDS.sleep(10);
  }

}
