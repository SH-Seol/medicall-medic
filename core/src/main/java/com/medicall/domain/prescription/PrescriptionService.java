package com.medicall.domain.prescription;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PrescriptionService {

    private final PrescriptionReader prescriptionReader;

    public PrescriptionService(PrescriptionReader prescriptionReader) {
        this.prescriptionReader = prescriptionReader;
    }

    public List<Prescription> getPrescriptionsByPatientIdAndDoctorId(Long patientId, Long doctorId) {
        return prescriptionReader.getAllPrescriptionsByPatientIdAndDoctorId(patientId, doctorId);
    }
}
