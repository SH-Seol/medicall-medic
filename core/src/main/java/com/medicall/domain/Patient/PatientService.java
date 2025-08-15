package com.medicall.domain.Patient;

import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientReader patientReader;

    public PatientService(PatientReader patientReader) {
        this.patientReader = patientReader;
    }

    public Patient getPatient(Long patientId){
        return patientReader.getPatient(patientId);
    }
}
