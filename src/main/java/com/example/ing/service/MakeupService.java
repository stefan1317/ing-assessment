package com.example.ing.service;

import com.example.ing.domain.AppUser;
import com.example.ing.domain.Makeup;
import com.example.ing.dto.MakeupDto;
import com.example.ing.dto.MakeupSearchDto;
import com.example.ing.exceptions.RecordCannotBeNullException;
import com.example.ing.repository.AppUserRepository;
import com.example.ing.repository.AppointmentRepository;
import com.example.ing.repository.MakeupRepository;
import com.example.ing.utils.MakeupMapper;
import com.example.ing.utils.SpecificationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MakeupService {

    private final MakeupRepository makeupRepository;

    private final MakeupMapper makeupMapper;

    public ResponseEntity<MakeupDto> saveMakeup(MakeupDto makeupDto) {

        if (makeupDto == null) {
            throw new RecordCannotBeNullException("Makeup cannot be null.");
        }

        Makeup makeup = makeupMapper.toEntity(makeupDto);

        Makeup savedMakeup = makeupRepository.save(makeup);

        log.info("Makeup: {} saved.", savedMakeup);
        return new ResponseEntity<>(makeupMapper.toDto(savedMakeup), HttpStatus.OK);
    }

    public ResponseEntity<List<MakeupDto>> searchMakeup(MakeupSearchDto makeupSearchDto) {

        if (makeupSearchDto == null) {
            throw new RecordCannotBeNullException("Search criteria cannot be null.");
        }

        List<Makeup> makeups = makeupRepository.findAll(SpecificationUtils.buildMakeupSpecification(makeupSearchDto));

        return new ResponseEntity<>(makeupMapper.toDtoList(makeups), HttpStatus.OK);
    }

    public ResponseEntity<MakeupDto> updateMakeup(MakeupDto makeupDto) {
        Makeup savedMakeup = new Makeup();

        try {
            Makeup toBeSavedMakeup = makeupMapper.toEntity(makeupDto);
            savedMakeup = makeupRepository.save(toBeSavedMakeup);
        } catch (Exception e) {
            log.error("An error occurred while updating the makeup: {}", e.getMessage());
        }

        return new ResponseEntity<>(makeupMapper.toDto(savedMakeup), HttpStatus.OK);
    }

    public ResponseEntity<String> deleteMakeup(long makeupId) {
        makeupRepository.deleteById(makeupId);

        return ResponseEntity.ok("Makeup with id " + makeupId + " was deleted successfully.");
    }
}
