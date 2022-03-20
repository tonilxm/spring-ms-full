package com.toni.department.controller;

import com.toni.department.entity.Department;
import com.toni.department.service.DepartmentService;
import com.toni.department.vo.DepartmentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public DepartmentVO saveDepartment(@RequestBody Department department) {
        log.info("Inside DepartmentController.saveDepartment");
        Department entity = this.departmentService.saveDepartment(department);
        return DepartmentVO.builder().id(entity.getId()).name(entity.getName()).build();
    }

    @GetMapping("/{id}")
    public DepartmentVO findDepartment(@PathVariable Long id) {
        log.info("Inside DepartmentController.findDepartment");
        Department entity = this.departmentService.findDepartment(id);

        return DepartmentVO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
