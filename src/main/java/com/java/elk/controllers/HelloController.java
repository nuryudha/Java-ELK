package com.java.elk.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

    @GetMapping("/")
    public String getMethodName() {
        return "Java Spring Boot is running!";
    }

}
