package com.facecert.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "index"; // src/main/resources/templates/index.html
    }

    @GetMapping("/create-face-id")
    public String createFaceId() {
        return "create-face-id"; // src/main/resources/templates/create-face-id.html
    }

    @GetMapping("/signin-face-id")
    public String signinFaceId() {
        return "signin-face-id"; // src/main/resources/templates/signin-face-id.html
    }
}