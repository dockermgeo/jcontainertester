package de.mgeo.jcontest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class JContTestApplication {

	private static final Logger logger = LogManager.getLogger(JContTestApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(JContTestApplication.class, args);
		new ContentEnv();
	}


}
