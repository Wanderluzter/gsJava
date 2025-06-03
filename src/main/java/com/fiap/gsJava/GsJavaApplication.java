package com.fiap.gsJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class GsJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GsJavaApplication.class, args);
	}

}
