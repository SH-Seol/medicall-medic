package com.medicall.domain.hospital;

import com.medicall.domain.doctor.Appointment;
import java.util.List;
import java.util.Optional;

public interface HospitalRepository {
    Long save(NewHospital newHospital);
    Optional<Hospital> findByName(String name);
    Optional<Hospital> findById(Long id);
    List<Appointment> findAppointmentsByHospitalId(Long id);
    void rejectAppointmentById(Long hospitalId, Long appointmentId);
}
