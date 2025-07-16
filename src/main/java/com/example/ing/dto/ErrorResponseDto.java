package com.example.ing.dto;

public record ErrorResponseDto(
        int status,
        String message) {
}
