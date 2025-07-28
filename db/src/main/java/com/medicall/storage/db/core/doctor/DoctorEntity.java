package com.medicall.storage.db.core.doctor;

import com.medicall.storage.db.core.appointment.AppointmentEntity;
import com.medicall.storage.db.core.common.domain.BaseEntity;
import com.medicall.storage.db.core.department.DepartmentEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class DoctorEntity extends BaseEntity {
    @Column(nullable = false)
    private String name;

    private String imageUrl;

    private String introduction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private DepartmentEntity department;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AppointmentEntity> appointments;

    protected DoctorEntity() {}

    public DoctorEntity(String name, String imageUrl, String introduction, DepartmentEntity department) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.introduction = introduction;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getIntroduction() {
        return introduction;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public List<AppointmentEntity> getAppointments() {
        return appointments;
    }



}
