package com.medicall.storage.db.core.medicine;

import com.medicall.storage.db.core.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class MedicineEntity extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String manufacturer;

    private String unit;

    protected MedicineEntity() {}

    public MedicineEntity(String name, String manufacturer, String unit) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public String getUnit() {
        return unit;
    }
}
