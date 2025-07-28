package com.medicall.storage.db.core.doctor;

import com.medicall.domain.doctor.Doctor;
import com.medicall.domain.doctor.DoctorRepository;
import com.medicall.storage.db.core.department.DepartmentEntity;
import com.medicall.storage.db.core.department.DepartmentJpaRepository;

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
}
