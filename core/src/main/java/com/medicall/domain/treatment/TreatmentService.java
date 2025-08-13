package com.medicall.domain.treatment;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TreatmentService {

    private final TreatmentReader treatmentReader;
    private final TreatmentWriter treatmentWriter;

    public TreatmentService(TreatmentReader treatmentReader, TreatmentWriter treatmentWriter) {
        this.treatmentReader = treatmentReader;
        this.treatmentWriter = treatmentWriter;
    }

    //진료 기록 작성
    public Long addTreatment(Treatment treatment) {
        return treatmentWriter.addTreatment(treatment);
    }

    //진단 기록 불러오기
    public List<Treatment> getTreatments(Long patientId, Long doctorId) {
        return treatmentReader.getTreatmentsByPatientId(patientId, doctorId);
    }
}
