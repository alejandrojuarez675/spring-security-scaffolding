package com.alejua39.scaffoldings.infrastructure.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    /**
     * No protected endpoint
     * @return pong
     */
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

}
