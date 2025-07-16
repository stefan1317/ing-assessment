package com.example.ing.controller;

import com.example.ing.dto.MakeupDto;
import com.example.ing.dto.MakeupSearchDto;
import com.example.ing.service.MakeupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("makeup")
public class MakeupController {

    private final MakeupService makeupService;

    @PostMapping("/save")
    public ResponseEntity<MakeupDto> saveMakeup(@RequestBody MakeupDto makeupDto) {
        return makeupService.saveMakeup(makeupDto);
    }

    @GetMapping("/search")
    public ResponseEntity<List<MakeupDto>> searchMakeup(@RequestBody MakeupSearchDto makeupSearchDto) {
        return makeupService.searchMakeup(makeupSearchDto);
    }

    @PutMapping("/update")
    public ResponseEntity<MakeupDto> updateMakeup(@RequestBody MakeupDto makeupDto) {
        return makeupService.updateMakeup(makeupDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMakeup(@RequestParam long makeupId) {
        return makeupService.deleteMakeup(makeupId);
    }
}
