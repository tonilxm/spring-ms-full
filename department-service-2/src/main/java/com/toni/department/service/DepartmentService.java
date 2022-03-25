package com.toni.department.service;

import com.toni.department.config.DepartmentServiceConfig;
import com.toni.department.entity.Department;
import com.toni.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentServiceConfig config;


    public Department saveDepartment(Department department) {
        return this.departmentRepository.save(department);
    }

    public Department findDepartment(Long id) {
        try {
            Thread.sleep(config.getDelay());
            return this.departmentRepository.getById(id);
        } catch (InterruptedException ex) {

        }

        return null;
    }
}
