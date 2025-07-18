package com.example.visalportfolioapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioDataDto {
    private String image;
    private String name;
    private String title;
    private String description;
    private String location;
    private SocialLinksDto socialLinks;
}
