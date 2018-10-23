package zjtech.redis.entities;

import java.io.Serializable;
import lombok.Data;

@Data
public class User implements Serializable {

  private String name;
  private int age;
  private String desc;

}
