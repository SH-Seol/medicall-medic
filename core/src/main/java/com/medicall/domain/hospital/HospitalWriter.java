package com.medicall.domain.hospital;

public class HospitalWriter {

    private final HospitalRepository hospitalRepository;

    public HospitalWriter(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public Long create(NewHospital newHospital) {
        return hospitalRepository.save(newHospital);
    }
}
