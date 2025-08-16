package com.medicall.domain.prescription;

import com.medicall.domain.Patient.Patient;
import com.medicall.domain.doctor.Doctor;
import com.medicall.domain.hospital.Hospital;
import java.time.LocalDate;
import java.util.List;

public record Prescription(
        Long id,
        Patient patient,
        List<PrescriptionMedicine> medicines,
        Hospital hospital,
        Doctor doctor,
        LocalDate date
) {
}
