package com.example.finaryaBasicCrudOperation.Controller;

import com.example.finaryaBasicCrudOperation.Model.Employee;
import com.example.finaryaBasicCrudOperation.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class employeeController {

    @Autowired
    public EmployeeService employeeService;


    @GetMapping("/")
    public String getAllEmployee(Model model)
    {
        model.addAttribute("listEmployees", employeeService.getAllEmployee());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model)
    {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee)
    {
        employeeService.createEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/updateEmployeeForm/{id}")
    public String updateEmployeeForm(@PathVariable int id, Model model)
    {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee") Employee employee)
    {
        employeeService.updateEmployee(employee.getId(), employee);
        return "redirect:/";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }

}
