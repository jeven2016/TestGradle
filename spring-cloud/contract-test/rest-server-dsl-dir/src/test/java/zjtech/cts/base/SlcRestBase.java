package zjtech.cts.base;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;
import zjtech.cts.HelloController;

@RunWith(SpringRunner.class)
public abstract class SlcRestBase {

  @InjectMocks
  HelloController helloController;

  @Before
  public void setup() {
    RestAssuredMockMvc.standaloneSetup(helloController);
  }

}
