package com.example.ing.service;

import com.example.ing.domain.Review;
import com.example.ing.dto.ReviewDto;
import com.example.ing.exceptions.RecordCannotBeNullException;
import com.example.ing.repository.ReviewRepository;
import com.example.ing.utils.ReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final ReviewMapper reviewMapper;

    public ResponseEntity<ReviewDto> saveReview(ReviewDto reviewDto) {

        if (reviewDto == null) {
            throw new RecordCannotBeNullException("Review cannot be null.");
        }

        Review review = reviewMapper.toEntity(reviewDto);

        Review savedReview = reviewRepository.save(review);

        log.info("Review: {} saved.", savedReview);
        return new ResponseEntity<>(reviewMapper.toDto(savedReview), HttpStatus.OK);
    }

    public ResponseEntity<List<ReviewDto>> getReviewsByMakeupId(int makeupId) {

        List<Review> reviews = reviewRepository.findByMakeupId(makeupId);

        return new ResponseEntity<>(reviewMapper.toDtoList(reviews), HttpStatus.OK);
    }

    public ResponseEntity<String> deleteReview(int reviewId) {
        reviewRepository.deleteById(reviewId);

        return ResponseEntity.ok("Review with id " + reviewId + " was deleted successfully.");
    }
}
