package com.example.ing.dto;

import lombok.Builder;

@Builder
public record MakeupDto(
        int id,
        String name,
        String description,
        String imageUrl,
        String durationInHours,
        double price) {
}
