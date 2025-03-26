package com.medipredict.medicalservice.controller;

import com.medipredict.medicalservice.entity.MedicalData;
import com.medipredict.medicalservice.service.MedicalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medical-data")
public class MedicalDataController {

    @Autowired
    private MedicalDataService service;

    @GetMapping("/{clientId}")
    public ResponseEntity<Page<MedicalData>> getMedicalData(
            @PathVariable Long clientId, Pageable pageable) {
        return ResponseEntity.ok(service.getMedicalDataByClientId(clientId, pageable));
    }

    @PostMapping("/generate/{clientId}")
    public ResponseEntity<String> generateMedicalData(@PathVariable Long clientId) {
        service.generateMedicalDataForClient(clientId, 5000);
        return ResponseEntity.ok("5000 medical data records generated for client ID: " + clientId);
    }
}
