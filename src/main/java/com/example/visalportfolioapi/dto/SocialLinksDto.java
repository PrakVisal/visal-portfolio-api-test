package com.example.visalportfolioapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialLinksDto {
    private String instagram;
    private String facebook;
    private String twitter;
    private String youtube;
}