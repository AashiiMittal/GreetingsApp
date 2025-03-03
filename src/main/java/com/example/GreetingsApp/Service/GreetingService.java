package com.example.GreetingsApp.Service;

import com.example.GreetingsApp.Model.Greeting;
import com.example.GreetingsApp.Repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    @Autowired
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }
    //    This is UC2
    public String getGreetingMessageUC2() {
        return "Hello from GreetingService!";
    }
    //    This is UC3
    public String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
             return "Hello, " + firstName + "!";
        } else if (lastName != null) {
            return "Hello, " + lastName + "!";
        } else {
            return "Hello World!";
        }
    }
    // Method to save the greeting message to the database
    public void saveGreetingMessage(String message) {
        Greeting greeting = new Greeting(message);
        greetingRepository.save(greeting);
    }
    public Optional<Greeting> getGreetingById(Long id) {
        Optional<Greeting> greeting = greetingRepository.findById(id);
        if (greeting.isPresent()) {
            System.out.println("Found Greeting: " + greeting.get().getMessage());
        } else {
            System.out.println("Greeting not found with ID: " + id);
        }
        return greeting;
    }
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
    public Greeting updateGreetingMessage(Long id, String newMessage) {
        Optional<Greeting> existingGreeting = greetingRepository.findById(id);
        if (existingGreeting.isPresent()) {
            Greeting greeting = existingGreeting.get();
            greeting.setMessage(newMessage);  // Update message
            return greetingRepository.save(greeting);  // Save updated greeting
        } else {
            throw new RuntimeException("Greeting with ID " + id + " not found.");
        }
    }

}
