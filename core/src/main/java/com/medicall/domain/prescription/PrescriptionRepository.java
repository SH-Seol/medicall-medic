package com.medicall.domain.prescription;

import java.util.List;

public interface PrescriptionRepository {
    List<Prescription> getPrescriptionByPatientIdAndDoctorId(Long patientId, Long doctorId);
    Long save(NewPrescription newPrescription);
}
