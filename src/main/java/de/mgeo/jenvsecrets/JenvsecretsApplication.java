package de.mgeo.jenvsecrets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class JenvsecretsApplication {

	private static final Logger logger = LogManager.getLogger(JenvsecretsApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(JenvsecretsApplication.class, args);
		new ContentEnv();
	}


}
