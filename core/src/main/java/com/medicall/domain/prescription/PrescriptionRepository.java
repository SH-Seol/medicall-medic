package com.medicall.domain.prescription;

import java.util.List;
import java.util.Optional;

public interface PrescriptionRepository {
    List<Prescription> getPrescriptionByPatientIdAndDoctorId(Long patientId, Long doctorId);
}
