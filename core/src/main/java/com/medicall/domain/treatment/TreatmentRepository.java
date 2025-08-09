package com.medicall.domain.treatment;

import java.util.List;

public interface TreatmentRepository {
    List<Treatment> getTreatmentsByPatientId(Long patientId, Long doctorId);
    Long saveTreatment(Treatment treatment);
}
