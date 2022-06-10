package com.example.Practical_CSW_Webservice.model;

import com.example.Practical_CSW_Webservice.entity.Employee;

import java.util.List;

public interface EmployeeModel {
    List<Employee> getEmployees();
    boolean addEmployees(Employee e);
    boolean updateEmployee(Employee e, int id);
}
