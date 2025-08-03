package com.medicall.domain.hospital;

import java.util.Optional;

public interface HospitalRepository {
    Long save(NewHospital newHospital);
    Optional<Hospital> findByName(String name);
    Optional<Hospital> findById(Long id);
}
