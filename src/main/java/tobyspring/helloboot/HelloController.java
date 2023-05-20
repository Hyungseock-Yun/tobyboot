package tobyspring.helloboot;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@Controller
@RequestMapping("/hello")
public class HelloController {

  private final HelloService helloService;

  public HelloController(HelloService helloService) {
    this.helloService = helloService;
  }

  @GetMapping("/hello")
  @ResponseBody   // 해당 어노테이션 없이 return형태를 String으로 하면 view를 return하는 것으로 이해한다.
  public String hello(String name) {

    if (!StringUtils.hasText(name)) throw new IllegalArgumentException();

    return helloService.sayHello(Objects.requireNonNull(name));
  }

  @GetMapping("/count")
  public String helloCount(String name) {
    return name + ": " + helloService.countOf(name);
  }
}
