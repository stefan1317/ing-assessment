package com.example.ing.utils;

import com.example.ing.domain.AppUser;
import com.example.ing.dto.AppUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppUserMapper {

    AppUserDto toDto(AppUser appUser);

    AppUser toEntity(AppUserDto appUserDto);
}
