package com.example.GreetingsApp.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.GreetingsApp.Service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @GetMapping("/simple")
    public String getGreeting() {
        return "Hello, this is a GET request!";
    }

    private final GreetingService greetingService;
    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/service")
    public String getGreetingServiceLayer() {
        return GreetingService.getGreetingMessage();
    }
}

