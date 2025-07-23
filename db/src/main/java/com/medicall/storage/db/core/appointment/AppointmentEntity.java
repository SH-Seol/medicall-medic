package com.medicall.storage.db.core.appointment;

import com.medicall.storage.db.core.common.domain.BaseEntity;
import com.medicall.storage.db.core.common.enums.AppointmentStatus;
import com.medicall.storage.db.core.doctor.DoctorEntity;
import com.medicall.storage.db.core.patient.PatientEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class AppointmentEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;

    @Column(nullable = false)
    private String symptom;

    @Column(nullable = false)
    private LocalDateTime reservationTime;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private AppointmentStatus status;

    protected AppointmentEntity() {}

    public AppointmentEntity(PatientEntity patient, DoctorEntity doctor, String symptom, LocalDateTime reservationTime) {
        this.patient = patient;
        this.doctor = doctor;
        this.symptom = symptom;
        this.reservationTime = reservationTime;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public String getSymptom() {
        return symptom;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }
}
