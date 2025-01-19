package com.facecert.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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
    public String saveFaceId(@RequestParam("faceImage") MultipartFile faceImage, Model model) {
        if (!faceImage.isEmpty()) {
            try {
                String uploadDir = System.getProperty("user.dir") + "/uploads";
                File directory = new File(uploadDir);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                File destinationFile = new File(uploadDir, faceImage.getOriginalFilename());
                faceImage.transferTo(destinationFile);

                model.addAttribute("message", "File uploaded successfully: " + destinationFile.getAbsolutePath());
            } catch (IOException e) {
                model.addAttribute("message", "Failed to upload file: " + e.getMessage());
            }
        } else {
            model.addAttribute("message", "No file uploaded.");
        }
        return "save-face-id"; // Return the save-face-id template
    }

}
