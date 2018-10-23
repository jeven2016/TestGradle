package zjtech.profile.features.taskExecutor;

import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class TaskExecutorSample {

  @Autowired
  @Qualifier(value = "taskExecutor")
  private TaskExecutor taskExecutor;

  public void runTask() {
    IntStream.range(0, 10).forEach(val -> taskExecutor.execute(new Task(val)));
  }

  public static class Task implements Runnable {

    int val;

    public Task(int val) {
      this.val = val;
    }

    @Override
    public void run() {
      System.out.println("runing task :" + val);
    }
  }

}
