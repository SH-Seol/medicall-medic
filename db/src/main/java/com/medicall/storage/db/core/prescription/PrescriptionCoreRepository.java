package com.medicall.storage.db.core.prescription;

import com.medicall.domain.prescription.Prescription;
import com.medicall.domain.prescription.PrescriptionRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;

public class PrescriptionCoreRepository implements PrescriptionRepository {

    private final PrescriptionJpaRepository prescriptionJpaRepository;
    private final JPAQueryFactory jpaQueryFactory;

    public PrescriptionCoreRepository(PrescriptionJpaRepository prescriptionJpaRepository,
                                      JPAQueryFactory jpaQueryFactory) {
        this.prescriptionJpaRepository = prescriptionJpaRepository;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Prescription> getPrescriptionByPatientIdAndDoctorId(Long patientId, Long doctorId){
        QPrescriptionEntity prescriptionEntity = QPrescriptionEntity.prescriptionEntity;
        QPrescriptionMedicineEntity prescriptionMedicineEntity = QPrescriptionMedicineEntity.prescriptionMedicineEntity;

        List<PrescriptionEntity> prescriptionEntityList = jpaQueryFactory
                .selectFrom(prescriptionEntity)
                .leftJoin(prescriptionEntity.patient).fetchJoin()
                .leftJoin(prescriptionEntity.doctor).fetchJoin()
                .leftJoin(prescriptionEntity.hospital).fetchJoin()
                .leftJoin(prescriptionEntity.PrescriptionMedicineList, prescriptionMedicineEntity).fetchJoin()
                // MedicineEntity도 즉시 로딩 (N+1 문제의 근원)
                .leftJoin(prescriptionMedicineEntity.medicine).fetchJoin()
                .where(
                        prescriptionEntity.patient.id.eq(patientId),
                        prescriptionEntity.doctor.id.eq(doctorId)
                )
                .distinct() // fetch join으로 인한 중복 결과 방지
                .fetch();

        return prescriptionEntityList.stream().map(PrescriptionEntity::toDomainModel).toList();
    }
}
