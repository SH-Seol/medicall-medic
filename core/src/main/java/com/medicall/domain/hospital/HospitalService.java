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

    //병원 생성
    public Long create(NewHospital newHospital, List<OperatingTime> operatingTimes) {
        return hospitalWriter.create(newHospital, operatingTimes);
    }

    //예약 조회
    public List<Appointment> getAppointments(Long hospitalId) {
        return hospitalReader.getAppointments(hospitalId);
    }

    //예약 거절
    public void rejectAppointment(Long hospitalId, Long appointmentId) {
        hospitalWriter.rejectAppointment(hospitalId, appointmentId);
    }

    //의사 없는 요청 의사 배정
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

    //병원 업무 시간 등록 주간 일괄 등록
    //병원 업무 시간 수정
    //공휴일 업무 여부 등록
    public void updateOperatingTime(Long hospitalId, List<OperatingTime> operatingTimes) {
        hospitalWriter.updaterOperatingTimes(hospitalId, operatingTimes);
    }
}
