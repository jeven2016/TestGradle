package zjtech.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class DbStatusService {

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  public void printDbStatus() {
    stringRedisTemplate.execute(new RedisCallback<Object>() {
      @Override
      public Object doInRedis(RedisConnection connection) throws DataAccessException {
        long dbsize = connection.dbSize();
        System.out.println(dbsize);
        return null;
      }
    });
  }


}
