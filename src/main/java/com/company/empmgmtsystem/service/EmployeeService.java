package com.company.empmgmtsystem.service;

import com.company.empmgmtsystem.model.Employee;
import com.company.empmgmtsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

//    public Employee updateEmployeeById(Long id, Employee employeeDetails){
//        Employee employee = new employeeRepository.getReferenceById(id);
//    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        if (!employeeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found with id " + id);
        }
        updatedEmployee.setId(id);
        return employeeRepository.save(updatedEmployee);
    }
}
