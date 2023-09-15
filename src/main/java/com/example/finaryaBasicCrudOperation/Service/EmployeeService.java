package com.example.finaryaBasicCrudOperation.Service;

import com.example.finaryaBasicCrudOperation.Model.Employee;

import java.util.List;

public interface EmployeeService {
    
    Employee createEmployee(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployee();

    Employee updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);
    
}
