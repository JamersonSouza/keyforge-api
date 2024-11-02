package tech.jamersondev.keyforge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableSpringDataWebSupport
public class KeyforgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeyforgeApplication.class, args);
	}

}
