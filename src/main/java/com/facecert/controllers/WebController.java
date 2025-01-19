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
        return "index"; // src/main/resources/templates/index.html
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // src/main/resources/templates/login.html
    }

    @GetMapping("/create-face-id")
    public String createFaceId() {
        return "create-face-id"; // src/main/resources/templates/create-face-id.html
    }

    @PostMapping("/save-face-id")
    public String saveFaceId(@RequestParam("faceImage") MultipartFile faceImage) {
        if (!faceImage.isEmpty()) {
            // Placeholder logic: Print the file name for now
            System.out.println("Received file: " + faceImage.getOriginalFilename());
        } else {
            System.out.println("No file uploaded.");
        }
        return "save-face-id"; // Return the save-face-id template
    }

}
