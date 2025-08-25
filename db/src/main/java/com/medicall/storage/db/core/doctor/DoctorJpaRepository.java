package com.medicall.storage.db.core.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorJpaRepository extends JpaRepository<DoctorEntity, Long> {
    @Query("SELECT d FROM DoctorEntity d JOIN FETCH d.hospital WHERE d.id = :doctorId")
    DoctorEntity findByIdWithHospital(@Param("doctorId") Long doctorId);
}
