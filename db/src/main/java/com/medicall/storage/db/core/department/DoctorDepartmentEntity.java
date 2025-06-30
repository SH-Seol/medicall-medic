package com.medicall.storage.db.core.department;

import com.medicall.storage.db.core.common.domain.BaseEntity;
import com.medicall.storage.db.core.doctor.DoctorEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DoctorDepartmentEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private DoctorEntity doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private DepartmentEntity department;

    protected DoctorDepartmentEntity() {}

    public DoctorDepartmentEntity(DoctorEntity doctor, DepartmentEntity department) {
        this.doctor = doctor;
        this.department = department;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }
}
