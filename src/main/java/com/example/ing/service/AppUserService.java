package com.example.ing.service;

import com.example.ing.repository.AppUserRepository;
import com.example.ing.utils.AppUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    private final AppUserMapper appUserMapper;
}
