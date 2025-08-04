package com.medicall.storage.db.core.hospital;


import com.medicall.domain.doctor.Appointment;
import com.medicall.domain.hospital.Hospital;
import com.medicall.domain.hospital.HospitalRepository;
import com.medicall.domain.hospital.NewHospital;
import com.medicall.storage.db.core.address.AddressEntity;
import com.medicall.storage.db.core.address.AddressJpaRepository;
import com.medicall.storage.db.core.appointment.AppointmentEntity;
import com.medicall.storage.db.core.department.DepartmentEntity;
import com.medicall.storage.db.core.department.DepartmentJpaRepository;
import com.medicall.storage.db.core.department.HospitalDepartmentEntity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HospitalCoreRepository implements HospitalRepository {

    private final HospitalJpaRepository hospitalJpaRepository;
    private final AddressJpaRepository addressJpaRepository;
    private final DepartmentJpaRepository departmentJpaRepository;

    public HospitalCoreRepository(HospitalJpaRepository hospitalJpaRepository,
                                  AddressJpaRepository addressJpaRepository,
                                  DepartmentJpaRepository departmentJpaRepository) {
        this.hospitalJpaRepository = hospitalJpaRepository;
        this.addressJpaRepository = addressJpaRepository;
        this.departmentJpaRepository = departmentJpaRepository;
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
}
