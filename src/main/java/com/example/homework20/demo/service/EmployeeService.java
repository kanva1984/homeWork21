package com.example.homework20.demo.service;

import com.example.homework20.demo.model.Employee;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);

}
