package com.facecert.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
        if (faceImage.isEmpty()) {
            model.addAttribute("message", "No file uploaded.");
            return "save-face-id";
        }

        String contentType = faceImage.getContentType();
        if (!("image/png".equals(contentType) || "image/jpeg".equals(contentType))) {
            model.addAttribute("message", "Invalid file type. Please upload a PNG or JPEG image.");
            return "save-face-id";
        }

        try {
            // Simulate facial feature extraction
            String extractedFeatures = mockFeatureExtraction(faceImage);

            // Return processed data to the client
            Map<String, String> responseData = new HashMap<>();
            responseData.put("status", "success");
            responseData.put("features", extractedFeatures);
            model.addAttribute("response", responseData);

        } catch (Exception e) {
            model.addAttribute("message", "An error occurred while processing the file.");
            e.printStackTrace();
            return "save-face-id";
        }

        return "save-face-id";
    }

    private String mockFeatureExtraction(MultipartFile file) {
        // Mock AI feature extraction logic
        return "mock_feature_vector_" + file.getOriginalFilename().hashCode();
    }

}
