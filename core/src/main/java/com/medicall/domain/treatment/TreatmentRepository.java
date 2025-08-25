package com.medicall.domain.treatment;

import java.util.List;
import java.util.Optional;

public interface TreatmentRepository {
    List<Treatment> getTreatmentsByPatientId(Long patientId, Long doctorId);
    Long saveTreatment(Treatment treatment);
    Optional<Treatment> findById(Long treatmentId);
}
