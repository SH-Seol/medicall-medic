package com.medicall.storage.db.core.hospital;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalJpaRepository extends JpaRepository<HospitalEntity, Long> {
}
