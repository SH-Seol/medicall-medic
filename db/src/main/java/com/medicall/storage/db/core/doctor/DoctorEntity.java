package com.medicall.storage.db.core.doctor;

import com.medicall.storage.db.core.appointment.AppointmentEntity;
import com.medicall.storage.db.core.common.domain.BaseEntity;
import com.medicall.storage.db.core.department.DoctorDepartmentEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class DoctorEntity extends BaseEntity {
    @Column(nullable = false)
    private String name;

    private String imageUrl;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DoctorDepartmentEntity> departments;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AppointmentEntity> appointments;

    protected DoctorEntity() {}

    public DoctorEntity(String name, String imageUrl, List<DoctorDepartmentEntity> departments) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<DoctorDepartmentEntity> getDepartments() {
        return departments;
    }

    public List<AppointmentEntity> getAppointments() {
        return appointments;
    }
}
