package com.example.ing.utils;

import com.example.ing.domain.Appointment;
import com.example.ing.dto.AppointmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(target = "userId", source = "appUser.id")
    @Mapping(target = "makeupId", source = "makeup.id")
    AppointmentDto toDto(Appointment appointment);

    Appointment toEntity(AppointmentDto appointmentDto);

    List<AppointmentDto> toDtoList(List<Appointment> appointments);

    List<Appointment> toEntityList(List<AppointmentDto> dto);
}
