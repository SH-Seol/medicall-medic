package com.medicall.storage.db.core.department;

import com.medicall.domain.department.Department;
import com.medicall.domain.department.DepartmentRepository;
import java.util.Optional;

public class DepartmentCoreRepository implements DepartmentRepository {

    private final DepartmentJpaRepository departmentJpaRepository;

    public DepartmentCoreRepository(DepartmentJpaRepository jpaRepository) {
        this.departmentJpaRepository = jpaRepository;
    }

    public Optional<Department> findById(Long id){
        Optional<DepartmentEntity> optional = departmentJpaRepository.findById(id);
        return optional.map(this::toDomainModel);
    }

    private Department toDomainModel(DepartmentEntity departmentEntity){
        return new Department(departmentEntity.getId(), departmentEntity.getName());
    }
}
