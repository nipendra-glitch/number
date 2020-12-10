package com.number;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class NumberApplication {

	public static void main(String[] args) {
		SpringApplication.run(NumberApplication.class, args);
	}

}
