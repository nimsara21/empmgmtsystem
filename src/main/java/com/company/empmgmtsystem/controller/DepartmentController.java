package com.company.empmgmtsystem.controller;

import com.company.empmgmtsystem.model.Department;
import com.company.empmgmtsystem.model.Employee;
import com.company.empmgmtsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
        return departmentService.findDepartmentById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());


    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department){return departmentService.saveDepartment(department);}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department updatedDepartment) {
        try {
            Department department = departmentService.updateDepartment(id, updatedDepartment);
            return ResponseEntity.ok(department);
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
