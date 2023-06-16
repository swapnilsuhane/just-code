package web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthAPI {
    @GetMapping("/health")
    public String healthCheck() {
        return "I am doing fine!";
    }
}
