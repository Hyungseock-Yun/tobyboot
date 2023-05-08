package tobyspring.helloboot;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@RequestMapping("/hello")
@Controller
public class HelloController {
  private final HelloService helloService;
  private final ApplicationContext applicationContext;

  public HelloController(HelloService helloService, ApplicationContext applicationContext) {
    this.helloService = helloService;
    this.applicationContext = applicationContext;
    System.out.println("applicationContext = " + applicationContext);
  }

  @GetMapping
  @ResponseBody   // 해당 어노테이션 없이 return형태를 String으로 하면 view를 return하는 것으로 이해한다.
  public String hello(String name) {

    return helloService.sayHello(Objects.requireNonNull(name));
  }

}
