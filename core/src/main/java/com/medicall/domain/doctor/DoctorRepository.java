package com.medicall.domain.doctor;

import com.medicall.domain.appointment.Appointment;
import java.util.List;

public interface DoctorRepository {
    Long save(Doctor newDoctor);
    List<Appointment> getAppointmentsByDoctor(Doctor doctor);
    Doctor getDoctorById(Long id);
}
