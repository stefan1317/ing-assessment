package com.example.ing.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record AppUserDto(
        int id,
        String name,
        String email,
        String phone,
        String address,
        List<String> roles) {
}
