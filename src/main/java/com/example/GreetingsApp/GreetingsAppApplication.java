package com.example.GreetingsApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingsAppApplication {

	public static void main(String[] args) {
		System.out.println("Greetings ");
		SpringApplication.run(GreetingsAppApplication.class, args);
	}

}
