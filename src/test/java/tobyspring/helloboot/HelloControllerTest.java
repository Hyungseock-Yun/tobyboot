package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloControllerTest {

  @Test
  void helloController() {
    HelloController helloController = new HelloController(name -> name);    // 생성자 주입해야함.

    String ret = helloController.hello("Test");
    Assertions.assertThat(ret).isEqualTo("Test");
  }

  @Test
  void failsHelloController() {
    HelloController helloController = new HelloController(name -> name);    // 생성자 주입해야함.
    Assertions.assertThatThrownBy(() -> {
      String ret = helloController.hello(null);
    }).isInstanceOf(IllegalArgumentException.class);

    Assertions.assertThatThrownBy(() -> {
      String ret = helloController.hello("");
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void failsHelloApi() {
    // http localhost:8080/hello?name=Spring
    TestRestTemplate rest = new TestRestTemplate();

    ResponseEntity<String> res = rest.getForEntity("http://localhost:8080/hello?name=", String.class);

    // status 200
    assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);

  }
}
