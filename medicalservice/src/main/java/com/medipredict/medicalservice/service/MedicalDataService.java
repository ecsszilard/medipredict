package com.medipredict.medicalservice.service;

import com.medipredict.medicalservice.entity.MedicalData;
import com.medipredict.medicalservice.repository.MedicalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class MedicalDataService {

    @Autowired
    private MedicalDataRepository repository;

    public Page<MedicalData> getMedicalDataByClientId(Long clientId, Pageable pageable) {
        return repository.findByClientId(clientId, pageable);
    }

    public void generateMedicalDataForClient(Long clientId, int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            MedicalData data = MedicalData.builder()
                    .clientId(clientId)
                    .bloodType(generateRandomBloodType())
                    .bloodPressure("120/80")
                    .height(160 + random.nextDouble() * 40)
                    .weight(50 + random.nextDouble() * 50)
                    .diabetes(random.nextBoolean())
                    .antibioticResistance(random.nextBoolean())
                    .hypertonicTimeIndex(random.nextDouble() * 10)
                    .build();
            repository.save(data);
        }
    }

    private String generateRandomBloodType() {
        String[] bloodTypes = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
        return bloodTypes[new Random().nextInt(bloodTypes.length)];
    }
}
