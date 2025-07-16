package com.example.ing.controller;

import com.example.ing.service.MakeupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("makeup")
public class MakeupController {

    @Autowired
    private MakeupService makeupService;
}
