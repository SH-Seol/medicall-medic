package com.medicall.domain.doctor;

import java.util.List;

public interface DoctorRepository {
    Long save(Doctor newDoctor);
    List<Appointment> getAppointmentsByDoctor(Doctor doctor);
}
