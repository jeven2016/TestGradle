package zjtech.cts;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

  @PostMapping("/message")
  public Message say(@RequestBody Request request) {
    Message message = new Message();
    message.setClient(request.getWho());
    message.setMessage("you say " + request.getMessage());
    message.setDesc("some description...");
    message.setStatus("normal");
    return message;
  }

  @Data
  private static class Message {

    private String client;
    private String message;
    private String desc;
    private String status;
  }

  @Data
  private static class Request {

    private String who;
    private String message;
  }
}
