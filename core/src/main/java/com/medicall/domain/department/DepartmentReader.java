package com.medicall.domain.department;

import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class DepartmentReader {

    private final DepartmentRepository departmentRepository;

    public DepartmentReader(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }
}
