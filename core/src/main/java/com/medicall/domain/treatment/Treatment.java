package com.medicall.domain.treatment;

import com.medicall.domain.Patient.Patient;
import com.medicall.domain.doctor.Doctor;

public record Treatment(
        Patient patient,
        Doctor doctor,
        String symptoms,
        String treatment,
        String detailedTreatment
) {
}
