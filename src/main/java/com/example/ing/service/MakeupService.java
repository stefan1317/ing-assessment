package com.example.ing.service;

import com.example.ing.repository.MakeupRepository;
import com.example.ing.utils.MakeupMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MakeupService {

    private final MakeupRepository makeupRepository;

    private final MakeupMapper makeupMapper;
}
