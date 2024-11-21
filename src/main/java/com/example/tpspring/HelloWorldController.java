package com.example.tpspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/bonjour")
    public String hello() {
        return "Hello World !";
    }
}