package zjtech.contract;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
public class RestClient {

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping
  public ResponseEntity get() {

    Request request = new Request();
    request.setWho("Me");
    request.setMessage("hello server~~");
    ResponseEntity<Message> responseEntity = restTemplate
        .postForEntity("http://localhost:8095/hello/message", request, Message.class);
    Message message = responseEntity.getBody();
    return new ResponseEntity(message, HttpStatus.OK);
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
