package com.medicall.storage.db.core.medicine;

import com.medicall.domain.medicine.Medicine;
import com.medicall.domain.medicine.MedicineRepository;
import java.util.List;

public class MedicineCoreRepository implements MedicineRepository {

    private final MedicineJpaRepository medicineJpaRepository;

    public MedicineCoreRepository(MedicineJpaRepository medicineJpaRepository) {
        this.medicineJpaRepository = medicineJpaRepository;
    }

    public List<Medicine> searchMedicines(String keyword) {
        List<MedicineEntity> medicineEntities = medicineJpaRepository.findTop5ByNameContaining(keyword);

        return medicineEntities.stream().map(MedicineEntity::toDomainModel).toList();
    }
}
