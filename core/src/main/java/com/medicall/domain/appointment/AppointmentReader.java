package com.medicall.domain.appointment;

import org.springframework.stereotype.Component;

@Component
public class AppointmentReader {

    private final AppointmentRepository appointmentRepository;

    public AppointmentReader(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment getAppointmentById(Long appointmentId) {
        return appointmentRepository.getAppointmentById(appointmentId).orElse(null);
    }
}
