package com.example.finaryaBasicCrudOperation.Service.ServiceImpl;

import com.example.finaryaBasicCrudOperation.Model.Employee;
import com.example.finaryaBasicCrudOperation.Repository.EmployeeRepository;
import com.example.finaryaBasicCrudOperation.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource do not exist"));
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee searchedEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource do not exist"));

        searchedEmployee.setName(employee.getName());
        searchedEmployee.setLastName(employee.getLastName());

        return employeeRepository.save(searchedEmployee);
    }

    @Override
    public void deleteEmployee(int id) {
        Employee searchedEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource do not exist"));
        employeeRepository.delete(searchedEmployee);
    }
}
