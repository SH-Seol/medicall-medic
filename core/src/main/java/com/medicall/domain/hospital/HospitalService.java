package com.medicall.domain.hospital;

import org.springframework.stereotype.Service;

@Service
public class HospitalService {

    private final HospitalReader hospitalReader;
    private final HospitalWriter hospitalWriter;

    HospitalService(HospitalReader reader, HospitalWriter writer) {
        this.hospitalReader = reader;
        this.hospitalWriter = writer;
    }

    //생성
    public Long create(NewHospital newHospital) {
        return hospitalWriter.create(newHospital);
    }
}
