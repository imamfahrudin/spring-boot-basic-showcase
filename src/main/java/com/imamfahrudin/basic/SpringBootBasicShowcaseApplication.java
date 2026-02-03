package com.imamfahrudin.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Spring Boot Basic Showcase.
 * This is the entry point for the Spring Boot application that demonstrates
 * basic Spring features including REST controllers, services, JPA entities,
 * transactions, AOP, and configuration.
 */
@SpringBootApplication
public class SpringBootBasicShowcaseApplication {

	/**
	 * Main method that starts the Spring Boot application.
	 * @param args command line arguments passed to the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicShowcaseApplication.class, args);
	}

}
