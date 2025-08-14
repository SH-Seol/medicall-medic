package com.medicall.domain.hospital;

import com.medicall.domain.appointment.Appointment;
import java.util.List;
import java.util.Optional;

public interface HospitalRepository {
    Long save(NewHospital newHospital, List<OperatingTime> operatingTimes);
    Optional<Hospital> findByName(String name);
    Optional<Hospital> findById(Long id);
    List<Appointment> findAppointmentsByHospitalId(Long id);
    void rejectAppointmentById(Long hospitalId, Long appointmentId);
    Long addDoctorOnAppointment(Long doctorId, Long appointmentId);
    void registerOperatingTimes(Long hospitalId, List<OperatingTime> operatingTimes);
}
