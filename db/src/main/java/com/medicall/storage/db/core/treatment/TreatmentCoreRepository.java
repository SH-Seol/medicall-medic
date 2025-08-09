package com.medicall.storage.db.core.treatment;

import static com.medicall.storage.db.core.treatment.QTreatmentEntity.treatmentEntity;

import com.medicall.domain.treatment.Treatment;
import com.medicall.domain.treatment.TreatmentRepository;
import com.medicall.storage.db.core.doctor.DoctorJpaRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;

public class TreatmentCoreRepository implements TreatmentRepository {

    private final TreatmentJpaRepository treatmentJpaRepository;
    private final DoctorJpaRepository doctorJpaRepository;
    private final JPAQueryFactory queryFactory;

    public TreatmentCoreRepository(TreatmentJpaRepository treatmentJpaRepository,
                                   DoctorJpaRepository doctorJpaRepository,
                                   JPAQueryFactory queryFactory) {
        this.treatmentJpaRepository = treatmentJpaRepository;
        this.doctorJpaRepository = doctorJpaRepository;
        this.queryFactory = queryFactory;
    }

    public List<Treatment> getTreatmentsByPatientId(Long patientId, Long doctorId) {
        List<TreatmentEntity> entities = queryFactory
                .selectFrom(treatmentEntity)
                .where(treatmentEntity.patient.id.eq(patientId),
                        treatmentEntity.doctor.id.eq(doctorId)
                ).fetch();

        return entities.stream().map(TreatmentEntity::toDomainModel).toList();
    }

    public Long saveTreatment(Treatment treatment) {
        return null;
    }
}
