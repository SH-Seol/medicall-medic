package com.medicall.domain.doctor;

import com.medicall.domain.appointment.Appointment;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DoctorReader {

    private final DoctorRepository doctorRepository;

    public DoctorReader(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Appointment> getDoctorAppointments(Doctor doctor) {
        return doctorRepository.getAppointmentsByDoctor(doctor);
    }

    public Doctor getDoctorById(Long doctorId){
        return doctorRepository.getDoctorById(doctorId);
    }
}
