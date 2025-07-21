package com.medicall.storage.db.core.prescription;

import com.medicall.storage.db.core.common.domain.BaseEntity;
import com.medicall.storage.db.core.doctor.DoctorEntity;
import com.medicall.storage.db.core.patient.PatientEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class PrescriptionEntity extends BaseEntity {
    // 환자 정보 (예: Patient 엔티티와 ManyToOne 관계)
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    // 의사 정보 (예: Doctor 엔티티와 ManyToOne 관계)
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;

    @OneToMany(mappedBy = "prescription_id", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PrescriptionMedicineEntity> PrescriptionMedicineList;

    protected PrescriptionEntity() {}

    public PatientEntity getPatient() {
        return patient;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }
}
