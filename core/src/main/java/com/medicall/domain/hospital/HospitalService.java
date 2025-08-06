package com.medicall.domain.hospital;

import com.medicall.domain.doctor.Appointment;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalService {

    private final HospitalReader hospitalReader;
    private final HospitalWriter hospitalWriter;

    HospitalService(HospitalReader reader, HospitalWriter writer) {
        this.hospitalReader = reader;
        this.hospitalWriter = writer;
    }

    //생성
    public Long create(NewHospital newHospital) {
        return hospitalWriter.create(newHospital);
    }
    //예약 조회
    public List<Appointment> getAppointments(Long hospitalId) {
        return hospitalReader.getAppointments(hospitalId);
    }

    public void rejectAppointment(Long hospitalId, Long appointmentId) {
        hospitalWriter.rejectAppointment(hospitalId, appointmentId);
    }
}
