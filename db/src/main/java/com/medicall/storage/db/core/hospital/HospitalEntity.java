package com.medicall.storage.db.core.hospital;

import com.medicall.storage.db.core.common.domain.BaseEntity;
import com.medicall.storage.db.core.department.HospitalDepartmentEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class HospitalEntity extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HospitalDepartmentEntity> departments;
}
