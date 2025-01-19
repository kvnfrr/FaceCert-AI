package com.facecert.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "index"; // Maps to src/main/resources/templates/index.html
    }

    @GetMapping("/signin")
    public String signIn() {
        return "signin"; // Maps to src/main/resources/templates/signin.html
    }

    @GetMapping("/create-face-id")
    public String createFaceId() {
        return "create-face-id"; // Maps to src/main/resources/templates/create-face-id.html
    }
}
