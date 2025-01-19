package com.facecert.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/save-face-id")
    public String saveFaceId(@RequestParam("faceImage") MultipartFile faceImage) {
        // Placeholder logic: Print the file name for now
        System.out.println("Received file: " + faceImage.getOriginalFilename());
        return "redirect:/"; // Redirect back to home
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestParam("username") String username) {
        // Placeholder authentication logic
        if (username.equalsIgnoreCase("testuser")) {
            return "welcome"; // Redirect to a welcome page
        } else {
            return "redirect:/signin?error=true"; // Redirect back with an error
        }
    }

}
