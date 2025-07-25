package com.example.ing.dto;

import lombok.Builder;

@Builder
public record AppUserDto(
        long id,
        String name,
        String email,
        String password,
        String phone,
        String address,
        String role) {
}
