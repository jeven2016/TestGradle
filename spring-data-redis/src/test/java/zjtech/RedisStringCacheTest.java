package zjtech;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zjtech.redis.RedisApplication;
import zjtech.redis.RedisStringCache;

@SpringBootTest(classes = RedisApplication.class)
@RunWith(value = SpringRunner.class)
public class RedisStringCacheTest {

  @Autowired
  private RedisStringCache redisStringCache;

  @Test()
  public void test_cache_expire() throws InterruptedException {
    redisStringCache.cacheValue("myVal", "hello", 60);
//    redisStringCache.getValue("myVal");

  }
}
