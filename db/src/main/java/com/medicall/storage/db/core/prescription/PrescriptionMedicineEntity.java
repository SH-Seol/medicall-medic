package com.medicall.storage.db.core.prescription;

import com.medicall.storage.db.core.common.domain.BaseEntity;
import com.medicall.storage.db.core.medicine.MedicineEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

@Entity
public class PrescriptionMedicineEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private MedicineEntity medicine;

    @ManyToOne(fetch = FetchType.LAZY)
    private PrescriptionEntity prescription;

    //처방된 용량
    @Column(nullable = false)
    private double dosage;
    //용량 단위
    private String dosageUnit;

    //1회 복용량
    @Column(nullable = false)
    private int quantity;

    //복용 주기 ex. 1일 2회
    @Column(nullable = false)
    private String frequency;

    //복용 지시 ex. 식 후 30분
    @Column(nullable = false)
    private String instruction;

    protected PrescriptionMedicineEntity() {}

    public MedicineEntity getMedicine() {
        return medicine;
    }

    public PrescriptionEntity getPrescription() {
        return prescription;
    }

    public double getDosage() {
        return dosage;
    }

    public String getDosageUnit() {
        return dosageUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getInstruction() {
        return instruction;
    }
}
