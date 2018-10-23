package zjtech;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zjtech.redis.DbStatusService;
import zjtech.redis.RedisApplication;

@SpringBootTest(classes = RedisApplication.class)
@RunWith(value = SpringRunner.class)
public class DbStatusTest {

  @Autowired
  private DbStatusService dbStatusService;


  @Test
  public void testDbSize() {
    dbStatusService.printDbStatus();
  }

}
