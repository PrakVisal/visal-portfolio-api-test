package com.example.visalportfolioapi.controller;

import com.example.visalportfolioapi.dto.ApiResponse;
import com.example.visalportfolioapi.dto.ContactFormDto;
import com.example.visalportfolioapi.dto.PortfolioDataDto;
import com.example.visalportfolioapi.service.PortfolioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequiredArgsConstructor
public class PortfolioController {

    final PortfolioService portfolioService;

    @GetMapping("/portfolio")
    public ResponseEntity<PortfolioDataDto> getPortfolioData() {
        PortfolioDataDto portfolioData = portfolioService.getPortfolioData();
        return ResponseEntity.ok(portfolioData);
    }

    @PostMapping("/contact")
    public ResponseEntity<ApiResponse<String>> submitContactForm(@Valid @RequestBody ContactFormDto contactForm) {
        try {
            portfolioService.processContactForm(contactForm);
            return ResponseEntity.ok(ApiResponse.success("Message sent successfully! I'll get back to you soon."));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error("Failed to send message: " + e.getMessage()));
        }
    }

    @GetMapping("/download-cv")
    public ResponseEntity<Resource> downloadCV() {
        try {
            Resource resource = portfolioService.getCVResource();
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"Aqsam_CV.pdf\"")
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/health")
    public ResponseEntity<ApiResponse<String>> healthCheck() {
        return ResponseEntity.ok(ApiResponse.success("Portfolio API is running successfully!"));
    }
}
