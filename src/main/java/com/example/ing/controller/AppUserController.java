package com.example.ing.controller;

import com.example.ing.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;
}
