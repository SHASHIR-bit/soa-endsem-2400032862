package com.klef.soa.exam.controller;

import java.util.Map;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final Environment environment;

    public RestaurantController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Restaurant Service!";
    }

    @GetMapping("/instance")
    public Map<String, String> instance() {
        return Map.of(
            "service", environment.getProperty("spring.application.name", "RESTAURENT-SERVICE"),
            "port", environment.getProperty("local.server.port", "not available"),
            "message", "Restaurant service is running"
        );
    }

    @GetMapping("/menu")
    public String menu() {
        return "Menu: Pizza, Burger, Biryani";
    }
}
