package com.medicall.domain.hospital;

import com.medicall.domain.doctor.Appointment;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class HospitalReader {

    private final HospitalRepository hospitalRepository;

    public HospitalReader(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public List<Appointment> getAppointments(Long hospitalId) {
        return hospitalRepository.findAppointmentsByHospitalId(hospitalId);
    }
}
