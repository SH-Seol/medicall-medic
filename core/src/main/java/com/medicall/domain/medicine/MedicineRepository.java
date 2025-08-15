package com.medicall.domain.medicine;

import java.util.List;

public interface MedicineRepository {
    List<Medicine> searchMedicines(String keyword);
}
