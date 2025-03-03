package com.example.GreetingsApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.GreetingsApp.Repository")
public class GreetingsAppApplication {

	public static void main(String[] args) {
		System.out.println("Greetings ");
		SpringApplication.run(GreetingsAppApplication.class, args);
	}

}
