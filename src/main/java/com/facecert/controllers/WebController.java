package com.facecert.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/create-face-id")
    public String createFaceId() {
        return "create-face-id";
    }

    @GetMapping("/signin-face-id")
    public String signinFaceId() {
        return "signin-face-id";
    }

    @GetMapping("/signed-in")
    public String success() {
        return "signed-in";
    }
}