package com.medicall.storage.db.core.doctor;

import com.medicall.storage.db.core.appointment.AppointmentEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorJpaRepository extends JpaRepository<DoctorEntity, Long> {
    List<AppointmentEntity> findAppointmentsByDoctorId(Long doctorId);
}
