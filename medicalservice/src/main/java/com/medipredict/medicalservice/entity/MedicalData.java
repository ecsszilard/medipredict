package com.medipredict.medicalservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clientId;
    private String bloodType;
    private String bloodPressure;
    private double height;
    private double weight;
    private boolean diabetes;
    private boolean antibioticResistance;
    private double hypertonicTimeIndex;
}
