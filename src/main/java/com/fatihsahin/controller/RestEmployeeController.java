package com.fatihsahin.controller;

import com.fatihsahin.model.Employee;
import com.fatihsahin.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/api") //ortak uzantı ekler.
public class RestEmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee-list")//uzantısı ile gelindiğinde çalıştırır.
    public List<Employee> getEmployeeList() {
         return employeeService.getAllEmployeeList();
    }
    @GetMapping(path = "/employee-list/{id}")
    public Employee getEmployeeById(@PathVariable(name="id", required = true) String id) {
        return employeeService.getEmployeeById(id);
    }

}
