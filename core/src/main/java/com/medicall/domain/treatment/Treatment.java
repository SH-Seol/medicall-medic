package com.medicall.domain.treatment;

import com.medicall.domain.Patient.Patient;

public record Treatment(
        Patient patient,
        Long doctorId,
        String symptoms,
        String treatment,
        String detailedTreatment
) {
}
