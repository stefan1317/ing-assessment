package com.example.ing.utils;

import com.example.ing.domain.Makeup;
import com.example.ing.domain.Review;
import com.example.ing.dto.MakeupDto;
import com.example.ing.dto.ReviewDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewDto toDto(Review review);

    Makeup toEntity(MakeupDto makeupDto);
}
