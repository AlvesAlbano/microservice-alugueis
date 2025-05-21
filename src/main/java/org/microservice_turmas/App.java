package org.microservice_turmas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("http://localhost:8080/h2-console");
		System.out.println("http://localhost:8080/swagger-ui.html");
	}

}
