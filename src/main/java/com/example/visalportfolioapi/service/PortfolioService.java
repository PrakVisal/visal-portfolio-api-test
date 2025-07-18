package com.example.visalportfolioapi.service;

import com.example.visalportfolioapi.dto.ContactFormDto;
import com.example.visalportfolioapi.dto.PortfolioDataDto;
import com.example.visalportfolioapi.dto.SocialLinksDto;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService {

    public PortfolioDataDto getPortfolioData() {
        SocialLinksDto socialLinksDto = new SocialLinksDto();
        socialLinksDto.setYoutube("https://youtube.com/AGVisal");
        socialLinksDto.setInstagram("https://instagram.com/sannnnnnnji");
        socialLinksDto.setFacebook("https://facebook.com/PrakVisal");
        socialLinksDto.setTwitter("");

        return new PortfolioDataDto(
                "https://res.cloudinary.com/dhhs5oosi/image/upload/v1751612642/IMG_4949_20250704140359_file.png",
                "Prak Visal",
                "UI/UX Designer, Backend developer",
                "Hello! I'm a UI/UX designer and Flutter developer. Dive into my portfolio to discover a fusion of elegant design and seamless Backend development. Welcome to a world where creativity meets functionality!",
                "Cambodia",
                socialLinksDto
        );
    }

    public void processContactForm(ContactFormDto contactForm) {
        // Here you can implement various actions:
        // 1. Save to database
        // 2. Send email notification
        // 3. Log the contact request
        // 4. Integrate with CRM systems

        System.out.println("New contact form submission:");
        System.out.println("Name: " + contactForm.getFirstName() + " " + contactForm.getLastName());
        System.out.println("Email: " + contactForm.getEmail());
        System.out.println("Subject: " + contactForm.getSubject());
        System.out.println("Message: " + contactForm.getMessage());

        // TODO: Implement email sending logic
        // TODO: Save to database
        // TODO: Send confirmation email to user
    }

    public Resource getCVResource() {
        // Return CV file from resources folder
        // You should place the actual CV file in src/main/resources/static/
        return new ClassPathResource("static/Aqsam_CV.pdf");
    }
}

