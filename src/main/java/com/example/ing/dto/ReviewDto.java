package com.example.ing.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReviewDto(
        long id,
        long userId,
        long makeupId,
        int rating,
        String comment,
        LocalDateTime createdAt) {
}
