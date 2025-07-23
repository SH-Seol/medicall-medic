package com.medicall.storage.db.core.prescription;

import com.medicall.storage.db.core.common.domain.BaseEntity;
import com.medicall.storage.db.core.doctor.DoctorEntity;
import com.medicall.storage.db.core.patient.PatientEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PrescriptionEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private DoctorEntity doctor;

    @OneToMany(mappedBy = "prescription_id", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PrescriptionMedicineEntity> PrescriptionMedicineList = new ArrayList<>();

    @Column(nullable = false)
    private LocalDate prescriptionDate;

    protected PrescriptionEntity() {}

    public PrescriptionEntity(PatientEntity patient, DoctorEntity doctor, LocalDate prescriptionDate) {
        this.patient = patient;
        this.doctor = doctor;
        this.prescriptionDate = prescriptionDate;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public LocalDate getPrescriptionDate() {
        return prescriptionDate;
    }

    public List<PrescriptionMedicineEntity> getPrescriptionMedicineList() {
        return PrescriptionMedicineList;
    }
}
