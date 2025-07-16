package com.example.ing.dto;

import com.example.ing.domain.AppUser;
import com.example.ing.domain.Makeup;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record AppointmentDto(
        int id,
        LocalDateTime dateTime,
        double durationInHours,
        AppUser appUser,
        Makeup makeup,
        String status) {
}
