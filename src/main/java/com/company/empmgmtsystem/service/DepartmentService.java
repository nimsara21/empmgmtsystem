package com.company.empmgmtsystem.service;

import com.company.empmgmtsystem.model.Department;
import com.company.empmgmtsystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments(){return departmentRepository.findAll();}

    public Optional<Department> findDepartmentById(Long id){return departmentRepository.findById(id);}

    public Department saveDepartment(Department department){return departmentRepository.save(department);}

    public void deleteDepartment(Long id){departmentRepository.deleteById(id);}

    public Department updateDepartment(Long id, Department updatedDepartment) {
        if (!departmentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found with id " + id);
        }
        updatedDepartment.setId(id);
        return departmentRepository.save(updatedDepartment);
    }




}
