package tobyspring.helloboot;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
//import tobyspring.config.MySpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
//import tobyspring.config.MySpringBootApplication;
import jakarta.annotation.PostConstruct;

//@MySpringBootApplication
@SpringBootApplication
public class HellobootApplication {

	private final JdbcTemplate jdbcTemplate;

	public HellobootApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@PostConstruct
	void init() {
		jdbcTemplate.execute("create table if not exists hello(name varchar2(50) primary key, count int)");
	}
//	@Bean
//	ApplicationRunner applicationRunner(Environment env) {
//		return args -> {
//			String name = env.getProperty("my.name");
//			System.out.println("my.name : " + name);
//		};
//	}



	public static void main(String[] args) {
		SpringApplication.run(HellobootApplication.class, args);
//		MySpringApplication.run(HellobootApplication.class, args);
	}

}
