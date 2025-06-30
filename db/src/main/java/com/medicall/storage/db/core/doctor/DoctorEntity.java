package com.medicall.storage.db.core.doctor;

import com.medicall.storage.db.core.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class DoctorEntity extends BaseEntity {
    @Column(nullable = false)
    private String name;
}
