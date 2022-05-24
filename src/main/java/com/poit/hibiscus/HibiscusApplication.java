package com.poit.hibiscus;

import com.poit.hibiscus.config.ClientProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ClientProperties.class)
public class HibiscusApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibiscusApplication.class, args);
	}

}
