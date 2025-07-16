package com.example.ing.controller;

import com.example.ing.dto.ReviewDto;
import com.example.ing.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/save")
    public ResponseEntity<ReviewDto> saveReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.saveReview(reviewDto);
    }

    @GetMapping("/get")
    public ResponseEntity<List<ReviewDto>> getReviewsByMakeupId(@PathVariable int makeupId) {
        return reviewService.getReviewsByMakeupId(makeupId);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteReview(@PathVariable int reviewId) {
        return reviewService.deleteReview(reviewId);
    }
}
