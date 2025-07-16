package com.example.ing.service;

import com.example.ing.repository.ReviewRepository;
import com.example.ing.utils.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final ReviewMapper reviewMapper;
}
