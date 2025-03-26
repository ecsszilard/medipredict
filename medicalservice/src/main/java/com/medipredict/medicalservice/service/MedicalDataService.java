package com.medipredict.medicalservice.service;

import com.medipredict.medicalservice.entity.MedicalData;
import com.medipredict.medicalservice.repository.MedicalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MedicalDataService {

    @Autowired
    private MedicalDataRepository repository;

    private static final Random RANDOM = new Random();

    public Page<MedicalData> getMedicalDataByClientId(Long clientId, Pageable pageable) {
        return repository.findByClientId(clientId, pageable);
    }

    public void generateMedicalDataForClient(Long clientId, int count) {
        List<MedicalData> dataList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            MedicalData data = MedicalData.builder()
                    .clientId(clientId)
                    .bloodType(generateRandomBloodType())
                    .bloodPressure("120/80")
                    .height(160 + RANDOM.nextDouble() * 40)
                    .weight(50 + RANDOM.nextDouble() * 50)
                    .diabetes(RANDOM.nextBoolean())
                    .antibioticResistance(RANDOM.nextBoolean())
                    .hypertonicTimeIndex(RANDOM.nextDouble() * 10)
                    .build();
            dataList.add(data);
        }

        repository.saveAll(dataList); // ✅ Gyorsabb batch save
    }

    private String generateRandomBloodType() {
        String[] bloodTypes = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
        return bloodTypes[RANDOM.nextInt(bloodTypes.length)];
    }
}
