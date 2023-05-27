package com.example.homework20.demo.service.impl;

import com.example.homework20.demo.exeptions.EmployeeAlreadyAddedException;
import com.example.homework20.demo.exeptions.EmployeeNotFoundException;
import com.example.homework20.demo.exeptions.EmployeeStorageIsFullException;
import com.example.homework20.demo.model.Employee;
import com.example.homework20.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int EMPLOYEES_STORAGE_SIZE = 10;

    private final List<Employee> employees = new ArrayList<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже сеть!");
        }
        if (employees.size() == EMPLOYEES_STORAGE_SIZE) {
            throw new EmployeeStorageIsFullException("Хранилище заполнено!");
        }
        employees.add(employee);
        return employee;
    }


    @Override
    public void removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет!");
        }
        employees.remove(employee);

    }


    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.contains(employee)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет!");
        }
        for (Employee value : employees) {
            if (value != null && value.equals(employee)) {
                return value;
            }
        }

        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }


}
