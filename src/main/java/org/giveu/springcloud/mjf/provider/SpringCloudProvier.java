package org.giveu.springcloud.mjf.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class SpringCloudProvier {

	private static Logger logger = LoggerFactory.getLogger(SpringCloudProvier.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudProvier.class, args);
		logger.info("SpringCloudProvier start success");
	}
	
}