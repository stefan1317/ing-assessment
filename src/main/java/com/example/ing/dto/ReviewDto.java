package com.example.ing.dto;

import com.example.ing.domain.AppUser;
import com.example.ing.domain.Makeup;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReviewDto(
        int id,
        AppUser appUser,
        Makeup makeup,
        int rating,
        String comment,
        LocalDateTime createdAt) {
}
