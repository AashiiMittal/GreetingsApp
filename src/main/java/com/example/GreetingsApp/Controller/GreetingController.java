package com.example.GreetingsApp.Controller;

import org.springframework.web.bind.annotation.*;
import com.example.GreetingsApp.Service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/simple")
    public String getGreeting() {
        return "Hello, this is a GET request!";
    }

    @GetMapping("/service")
    public String getGreetingServiceLayer() {
        return greetingService.getGreetingMessageUC2(); // Fixed method call
    }

    @GetMapping("/personalized")
    public String getGreeting(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName) {
        return greetingService.getGreetingMessage(firstName, lastName);
    }
    @GetMapping("ucfour")
    public String greet(@RequestParam(value = "firstName", required = false) String firstName,
                        @RequestParam(value = "lastName", required = false) String lastName) {
        String message = greetingService.getGreetingMessage(firstName, lastName);
        greetingService.saveGreetingMessage(message);
        return "{\"message\": \"" + message + "\"}";
    }
}