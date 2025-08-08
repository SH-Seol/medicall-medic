package com.medicall.storage.db.core.hospital;


import com.medicall.domain.appointment.Appointment;
import com.medicall.domain.hospital.Hospital;
import com.medicall.domain.hospital.HospitalRepository;
import com.medicall.domain.hospital.NewHospital;
import com.medicall.storage.db.core.address.AddressEntity;
import com.medicall.storage.db.core.appointment.AppointmentEntity;
import com.medicall.storage.db.core.appointment.AppointmentJpaRepository;
import com.medicall.storage.db.core.department.DepartmentEntity;
import com.medicall.storage.db.core.department.DepartmentJpaRepository;
import com.medicall.storage.db.core.doctor.DoctorEntity;
import com.medicall.storage.db.core.doctor.DoctorJpaRepository;
import java.util.List;
import java.util.Optional;

public class HospitalCoreRepository implements HospitalRepository {

    private final HospitalJpaRepository hospitalJpaRepository;
    private final DepartmentJpaRepository departmentJpaRepository;
    private final AppointmentJpaRepository appointmentJpaRepository;
    private final DoctorJpaRepository doctorJpaRepository;

    public HospitalCoreRepository(HospitalJpaRepository hospitalJpaRepository,
                                  DepartmentJpaRepository departmentJpaRepository,
                                  AppointmentJpaRepository appointmentJpaRepository,
                                  DoctorJpaRepository doctorJpaRepository) {
        this.hospitalJpaRepository = hospitalJpaRepository;
        this.departmentJpaRepository = departmentJpaRepository;
        this.appointmentJpaRepository = appointmentJpaRepository;
        this.doctorJpaRepository = doctorJpaRepository;
    }
    public Long save(NewHospital newHospital){
        AddressEntity addressEntity = new AddressEntity(newHospital.address().zoneCode(),
                newHospital.address().roadAddress(),
                newHospital.address().jibunAddress(),
                newHospital.address().detailAddress(),
                newHospital.address().buildingName(),
                newHospital.address().longitude(),
                newHospital.address().latitude());

        List<DepartmentEntity> departmentEntities = departmentJpaRepository.findAllById(newHospital.departments());

        HospitalEntity savedHospitalEntity = new HospitalEntity(
                newHospital.name(),
                newHospital.telephoneNumber(),
                addressEntity,
                newHospital.imageUrl());

        savedHospitalEntity.addDepartments(departmentEntities);

        return hospitalJpaRepository.save(savedHospitalEntity).getId();
    }

    public Optional<Hospital> findByName(String name){
        return null;
    }
    public Optional<Hospital> findById(Long id){
        return null;
    }

    public List<Appointment> findAppointmentsByHospitalId(Long hospitalId){
        List<AppointmentEntity> appointmentEntities = hospitalJpaRepository.findById(hospitalId).get().getAppointments();

        if(appointmentEntities == null){
            return List.of();
        }

        return appointmentEntities.stream().map(AppointmentEntity::toDomainModel).toList();
    }

    public void rejectAppointmentById(Long hospitalId, Long appointmentId){
        AppointmentEntity appointmentEntity = appointmentJpaRepository.findById(appointmentId).orElseThrow();
        if(appointmentEntity.getHospital().getId().equals(hospitalId)){
            appointmentEntity.rejectAppointment();
        }
    }

    public Long addDoctorOnAppointment(Long doctorId, Long appointmentId){
        AppointmentEntity appointmentEntity = appointmentJpaRepository.findById(appointmentId).orElseThrow();
        DoctorEntity doctorEntity = doctorJpaRepository.findById(doctorId).orElseThrow();
        appointmentEntity.addDoctor(doctorEntity);

        return appointmentId;
    }
}
