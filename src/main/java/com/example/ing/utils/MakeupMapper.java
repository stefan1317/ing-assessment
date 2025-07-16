package com.example.ing.utils;

import com.example.ing.domain.Makeup;
import com.example.ing.dto.MakeupDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MakeupMapper {

    MakeupDto toDto(Makeup makeup);

    @Mapping(target = "reviews", ignore = true)
    Makeup toEntity(MakeupDto makeupDto);

    List<MakeupDto> toDtoList(List<Makeup> makeups);

    @Mapping(target = "reviews", ignore = true)
    List<Makeup> toEntityList(List<MakeupDto> dto);
}
