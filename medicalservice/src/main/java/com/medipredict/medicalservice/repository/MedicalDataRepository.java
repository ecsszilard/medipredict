package com.medipredict.medicalservice.repository;

import com.medipredict.medicalservice.entity.MedicalData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalDataRepository extends JpaRepository<MedicalData, Long> {
    Page<MedicalData> findByClientId(Long clientId, Pageable pageable);
}

