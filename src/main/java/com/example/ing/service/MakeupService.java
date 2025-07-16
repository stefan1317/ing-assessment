package com.example.ing.service;

import com.example.ing.repository.MakeupRepository;
import com.example.ing.utils.MakeupMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MakeupService {

    @Autowired
    private MakeupRepository makeupRepository;

    @Autowired
    private MakeupMapper makeupMapper;
}
