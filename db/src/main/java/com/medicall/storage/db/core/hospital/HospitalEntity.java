package com.medicall.storage.db.core.hospital;

import com.medicall.storage.db.core.address.AddressEntity;
import com.medicall.storage.db.core.common.domain.BaseEntity;
import com.medicall.storage.db.core.department.HospitalDepartmentEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;

@Entity
public class HospitalEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String telephoneNumber;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", nullable = false)
    private AddressEntity address;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HospitalDepartmentEntity> departments;

    protected HospitalEntity() {}

    public HospitalEntity(String name, String telephoneNumber, AddressEntity address) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }
}
