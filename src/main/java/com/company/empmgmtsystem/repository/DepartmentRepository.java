package com.company.empmgmtsystem.repository;

import com.company.empmgmtsystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findDepartmentById(Long id);
}
