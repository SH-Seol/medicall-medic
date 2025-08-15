package com.medicall.storage.db.core.patient;

import com.medicall.domain.Patient.Patient;
import com.medicall.domain.Patient.PatientRepository;

public class PatientCoreRepository implements PatientRepository {

    private final PatientJpaRepository patientJpaRepository;

    public PatientCoreRepository(PatientJpaRepository patientJpaRepository) {
        this.patientJpaRepository = patientJpaRepository;
    }

    public Patient getPatient(Long patientId){
        PatientEntity patientEntity = patientJpaRepository.findById(patientId).orElseThrow();

        return patientEntity.toDomainModel();
    }
}
