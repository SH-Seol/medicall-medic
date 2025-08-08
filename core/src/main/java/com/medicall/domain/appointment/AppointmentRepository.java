package com.medicall.domain.appointment;

import java.util.Optional;

public interface AppointmentRepository {
    Optional<Appointment> getAppointmentById(Long appointmentId);
    void assignDoctorToAppointment(Appointment appointmentWithDoctor);
}
