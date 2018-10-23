package zjtech.cts.base;

import javax.inject.Inject;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.MessageVerifier;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;
import zjtech.cts.ServerApp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerApp.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureMessageVerifier
public abstract class SlcMessagingBase {

  //remove::start[]
  @Inject
  MessageVerifier messaging;

  @Before
  public void setup() {

  }
}
