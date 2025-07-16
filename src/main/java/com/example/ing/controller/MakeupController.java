package com.example.ing.controller;

import com.example.ing.service.MakeupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("makeup")
public class MakeupController {

    private final MakeupService makeupService;
}
