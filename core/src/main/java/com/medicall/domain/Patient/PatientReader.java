package com.medicall.domain.Patient;

import org.springframework.stereotype.Component;

@Component
public class PatientReader {

    private final PatientRepository patientRepository;

    public PatientReader(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient getPatient(Long patientId){
        return patientRepository.getPatient(patientId);
    }
}
