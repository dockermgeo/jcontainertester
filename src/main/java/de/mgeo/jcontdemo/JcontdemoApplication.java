package de.mgeo.jcontdemo;

import de.mgeo.jcontdemo.models.CurrentLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JcontdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JcontdemoApplication.class, args);
		new CurrentLogger();
	}

}
