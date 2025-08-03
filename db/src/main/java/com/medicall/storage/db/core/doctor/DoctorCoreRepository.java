package com.medicall.storage.db.core.doctor;

import com.medicall.domain.doctor.Appointment;
import com.medicall.domain.doctor.Doctor;
import com.medicall.domain.doctor.DoctorRepository;
import com.medicall.storage.db.core.appointment.AppointmentEntity;
import com.medicall.storage.db.core.department.DepartmentEntity;
import com.medicall.storage.db.core.department.DepartmentJpaRepository;
import java.util.List;
import java.util.Optional;

public class DoctorCoreRepository implements DoctorRepository {

    private final DoctorJpaRepository doctorJpaRepository;
    private final DepartmentJpaRepository departmentJpaRepository;

    public DoctorCoreRepository(DoctorJpaRepository doctorJpaRepository, DepartmentJpaRepository departmentJpaRepository) {
        this.doctorJpaRepository = doctorJpaRepository;
        this.departmentJpaRepository = departmentJpaRepository;
    }

    public Long save(Doctor newDoctor) {
        DepartmentEntity department = departmentJpaRepository.findById(newDoctor.department()
                .id()).orElse(null);
        DoctorEntity savedDoctor = doctorJpaRepository.save(new DoctorEntity(newDoctor.name(), newDoctor.imageUrl(),
                newDoctor.introduction(), department));

        return savedDoctor.getId();
    }

    public List<Appointment> getAppointmentsByDoctor(Doctor doctor) {
        Optional<DoctorEntity> doctorEntity = doctorJpaRepository.findById(doctor.id());

        if(doctorEntity.isEmpty()){
            return List.of();
        }

        return doctorEntity.get().getAppointments().stream()
                .map(AppointmentEntity::toDomainModel)
                .toList();
    }
}
