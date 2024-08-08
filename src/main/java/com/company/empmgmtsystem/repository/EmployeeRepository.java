package com.company.empmgmtsystem.repository;

import com.company.empmgmtsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Long>{
    Employee findEmployeeById(Long id);
}
