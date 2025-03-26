package com.medipredict.medicalservice.controller;

import com.medipredict.medicalservice.entity.MedicalData;
import com.medipredict.medicalservice.service.MedicalDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medical-data")
@Tag(name = "Medical Data", description = "Endpoints for managing medical data")
public class MedicalDataController {

    @Autowired
    private MedicalDataService service;

    @Operation(summary = "Get paginated medical data for a client",
            description = "Retrieves medical data records for a given client, with pagination support.")
    @GetMapping("/{clientId}")
    public ResponseEntity<Page<MedicalData>> getMedicalData(
            @PathVariable Long clientId,
            @PageableDefault(size = 100, page = 0) Pageable pageable) {
        return ResponseEntity.ok(service.getMedicalDataByClientId(clientId, pageable));
    }

    @Operation(summary = "Generate 5000 medical records for a client",
            description = "Creates a batch of 5000 medical records for a given client.")
    @PostMapping("/generate/{clientId}")
    public ResponseEntity<String> generateMedicalData(@PathVariable Long clientId) {
        service.generateMedicalDataForClient(clientId, 5000);
        return ResponseEntity.ok("✅ 5000 medical data records generated for client ID: " + clientId);
    }
}

