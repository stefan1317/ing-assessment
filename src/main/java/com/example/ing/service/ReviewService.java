package com.example.ing.service;

import com.example.ing.domain.AppUser;
import com.example.ing.domain.Makeup;
import com.example.ing.domain.Review;
import com.example.ing.dto.ReviewDto;
import com.example.ing.exceptions.RecordCannotBeNullException;
import com.example.ing.repository.AppUserRepository;
import com.example.ing.repository.MakeupRepository;
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

    private final AppUserRepository appUserRepository;

    private final MakeupRepository makeupRepository;

    private final ReviewMapper reviewMapper;

    public ResponseEntity<ReviewDto> saveReview(ReviewDto reviewDto) {

        if (reviewDto == null) {
            throw new RecordCannotBeNullException("Review cannot be null.");
        }

        AppUser user = appUserRepository
                .findById(reviewDto.userId())
                .orElseThrow(() ->
                        new RecordCannotBeNullException("User with id " + reviewDto.userId() + " cannot be found."));

        Makeup makeup = makeupRepository
                .findById(reviewDto.makeupId())
                .orElseThrow(() ->
                        new RecordCannotBeNullException("Makeup with id " + reviewDto.makeupId() + " cannot be found."));

        Review review = reviewMapper.toEntity(reviewDto);

        review.setAppUser(user);
        review.setMakeup(makeup);

        Review savedReview = reviewRepository.save(review);

        log.info("Review: {} saved.", savedReview);
        return new ResponseEntity<>(reviewMapper.toDto(savedReview), HttpStatus.OK);
    }

    public ResponseEntity<List<ReviewDto>> getReviewsByMakeupId(long makeupId) {

        List<Review> reviews = reviewRepository.findByMakeupId(makeupId);

        return new ResponseEntity<>(reviewMapper.toDtoList(reviews), HttpStatus.OK);
    }

    public ResponseEntity<String> deleteReview(long reviewId) {
        reviewRepository.deleteById(reviewId);

        return ResponseEntity.ok("Review with id " + reviewId + " was deleted successfully.");
    }
}
