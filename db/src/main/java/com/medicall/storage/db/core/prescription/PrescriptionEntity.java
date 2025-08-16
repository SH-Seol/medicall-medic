package com.medicall.storage.db.core.prescription;

import com.medicall.domain.prescription.Prescription;
import com.medicall.storage.db.core.common.domain.BaseEntity;
import com.medicall.storage.db.core.doctor.DoctorEntity;
import com.medicall.storage.db.core.hospital.HospitalEntity;
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

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private HospitalEntity hospital;

    @OneToMany(mappedBy = "prescription_id", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PrescriptionMedicineEntity> PrescriptionMedicineList = new ArrayList<>();

    @Column(nullable = false)
    private LocalDate prescriptionDate;

    protected PrescriptionEntity() {}

    public PrescriptionEntity(PatientEntity patient, DoctorEntity doctor, HospitalEntity hospital, LocalDate prescriptionDate) {
        this.patient = patient;
        this.doctor = doctor;
        this.hospital = hospital;
        this.prescriptionDate = prescriptionDate;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public HospitalEntity getHospital() {
        return hospital;
    }

    public LocalDate getPrescriptionDate() {
        return prescriptionDate;
    }

    public List<PrescriptionMedicineEntity> getPrescriptionMedicineList() {
        return PrescriptionMedicineList;
    }

    public Prescription toDomainModel(){
        return new Prescription(
                this.id,
                this.patient.toDomainModel(),
                this.PrescriptionMedicineList.stream().map(PrescriptionMedicineEntity::toDomainModel).toList(),
                this.hospital.toDomainModel(),
                this.doctor.toDomainModel(),
                this.prescriptionDate
        );
    }
}
