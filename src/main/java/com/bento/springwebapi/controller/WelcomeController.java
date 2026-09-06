package com.bento.springwebapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exposes a simple root endpoint used as a health/welcome check for the API.
 *
 * @author Gustavo Bento
 */
@RestController
public class WelcomeController {

    /**
     * Returns a static welcome message.
     *
     * @return a greeting string confirming the API is reachable
     */
    @GetMapping("/")
    public String welcome(){
        return "Welcome to the Spring Web API!";
    }
}
