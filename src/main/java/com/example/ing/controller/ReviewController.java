package com.example.ing.controller;

import com.example.ing.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
}
