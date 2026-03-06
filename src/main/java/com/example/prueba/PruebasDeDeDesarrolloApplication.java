package com.example.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.prueba.infrastructure.repository")
public class PruebasDeDeDesarrolloApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebasDeDeDesarrolloApplication.class, args);
	}

}
