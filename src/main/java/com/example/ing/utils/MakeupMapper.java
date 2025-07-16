package com.example.ing.utils;

import com.example.ing.domain.Makeup;
import com.example.ing.dto.MakeupDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MakeupMapper {

    MakeupDto toDto(Makeup makeup);

    Makeup toEntity(MakeupDto makeupDto);
}
