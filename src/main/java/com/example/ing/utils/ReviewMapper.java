package com.example.ing.utils;

import com.example.ing.domain.Review;
import com.example.ing.dto.ReviewDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewDto toDto(Review review);

    Review toEntity(ReviewDto reviewDto);

    List<ReviewDto> toDtoList(List<Review> reviews);

    List<Review> toEntityList(List<ReviewDto> dto);
}
