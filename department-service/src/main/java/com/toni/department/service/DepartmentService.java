package com.toni.department.service;

import com.toni.department.entity.Department;
import com.toni.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department saveDepartment(Department department) {
        return this.departmentRepository.save(department);
    }

    public Department findDepartment(Long id) {
        return this.departmentRepository.getById(id);
    }
}
