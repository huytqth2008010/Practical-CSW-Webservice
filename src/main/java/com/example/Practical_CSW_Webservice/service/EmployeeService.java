package com.example.Practical_CSW_Webservice.service;

import com.example.Practical_CSW_Webservice.entity.Employee;
import com.example.Practical_CSW_Webservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
    public Employee addEmployees(Employee employee) {
        return employeeRepository.save(employee);
    }
    public List<Employee> saveAll(List<Employee> employee){return employeeRepository.saveAll(employee);}
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }
}
