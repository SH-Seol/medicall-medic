package com.medicall.domain.doctor;

import com.medicall.domain.department.Department;

public record Doctor(
        Long id,
        String name,
        String introduction,
        String imageUrl,
        Department department
) {
    public Doctor(String name, String introduction, String imageUrl, Department department){
        this(null, name, introduction, imageUrl, department);
    }
}
