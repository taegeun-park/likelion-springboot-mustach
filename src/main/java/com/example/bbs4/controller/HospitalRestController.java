package com.example.bbs4.controller;

import com.example.bbs4.domain.dto.HospitalResponse;
import com.example.bbs4.domain.entity.Hospital;
import com.example.bbs4.repository.HospitalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {

    private final HospitalRepository hospitalRepository;

    public HospitalRestController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        HospitalResponse hospitalResponse = Hospital.of(hospital.get());
        return ResponseEntity.ok().body(hospitalResponse);
    }
}