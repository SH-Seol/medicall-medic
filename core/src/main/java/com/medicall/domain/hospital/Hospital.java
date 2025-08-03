package com.medicall.domain.hospital;

import com.medicall.domain.department.Department;
import java.util.List;

public record Hospital(
        String name,
        String telephoneNumber,
        String address,
        String imageUrl,
        List<Department> departments
) {
}
