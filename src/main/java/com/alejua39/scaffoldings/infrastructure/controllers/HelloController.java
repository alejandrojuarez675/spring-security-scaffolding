package com.alejua39.scaffoldings.infrastructure.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /**
     * Protected endpoint
     * @return Hello World!
     */
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
