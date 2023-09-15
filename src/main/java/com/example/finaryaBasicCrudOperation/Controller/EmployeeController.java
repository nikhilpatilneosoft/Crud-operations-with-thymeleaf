package com.example.finaryaBasicCrudOperation.Controller;

import com.example.finaryaBasicCrudOperation.Model.Employee;
import com.example.finaryaBasicCrudOperation.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<Employee> createEmployee(@ModelAttribute Employee employee)
    {
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)
    {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping()
    public String getAllEmployee(Model model)
    {
        List<Employee> ListEmployee = employeeService.getAllEmployee();
        System.out.println(ListEmployee);
        model.addAttribute("ListEmployee", ListEmployee);
        return "index";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee)
    {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        employeeService.deleteEmployee(id);
        return "employee deleted.";
    }
}
