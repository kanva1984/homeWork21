package com.example.homework20.demo.controller;

import com.example.homework20.demo.model.Employee;
import com.example.homework20.demo.service.EmployeeService;
import com.example.homework20.demo.verification.EmployeeVerification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public ResponseEntity<Employee> addEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        if (EmployeeVerification.verification(firstName, lastName)) {
            return ResponseEntity.ok(employeeService.addEmployee(firstName, lastName));
        } else {
            return ResponseEntity.badRequest().build();
        }
}

    @GetMapping("/remove")
    public void removeEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
         employeeService.removeEmployee(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee findEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping()
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }
}
