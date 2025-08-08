package com.medicall.domain.hospital;

import com.medicall.domain.appointment.Appointment;
import com.medicall.domain.appointment.AppointmentReader;
import com.medicall.domain.appointment.AppointmentWriter;
import com.medicall.domain.doctor.Doctor;
import com.medicall.domain.doctor.DoctorReader;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalService {

    private final HospitalReader hospitalReader;
    private final HospitalWriter hospitalWriter;
    private final DoctorReader doctorReader;
    private final AppointmentReader appointmentReader;
    private final AppointmentWriter appointmentWriter;

    HospitalService(HospitalReader reader,
                    HospitalWriter writer,
                    DoctorReader doctorReader,
                    AppointmentReader appointmentReader,
                    AppointmentWriter appointmentWriter) {
        this.hospitalReader = reader;
        this.hospitalWriter = writer;
        this.doctorReader = doctorReader;
        this.appointmentReader = appointmentReader;
        this.appointmentWriter = appointmentWriter;
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

    public Long designateDoctorToAppointment(Long hospitalId, Long doctorId, Long appointmentId) {
        Doctor doctor = doctorReader.getDoctorById(doctorId);
        Appointment appointment = appointmentReader.getAppointmentById(appointmentId);
        if(!appointment.hospital().id().equals(hospitalId)){
            throw new IllegalArgumentException("병원의 예약이 아닙니다.");
        }
        if(appointment.doctor() != null){
            throw new IllegalArgumentException("이미 배정된 의사가 존재합니다.");
        }
        appointmentWriter.assignDoctorToAppointment(doctor, appointment);

        return appointment.id();
    }
}
