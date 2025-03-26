package com.medipredict.medicalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MedicalserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalserviceApplication.class, args);
	}

}
