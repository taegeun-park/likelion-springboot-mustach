package com.example.bbs4.repository;

import com.example.bbs4.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository <Hospital, Integer > {
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);
}

