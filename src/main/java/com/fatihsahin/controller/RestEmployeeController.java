package com.fatihsahin.controller;

import com.fatihsahin.model.Employee;
import com.fatihsahin.model.UpdateEmployeeRequest;
import com.fatihsahin.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employee") //ortak uzantı ekler.
public class RestEmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")//uzantısı ile gelindiğinde çalıştırır.
    public List<Employee> getEmployeeList() {
         return employeeService.getAllEmployeeList();
    }
    @GetMapping(path = "/list/{id}") // id ile çalışan getirme
    public Employee getEmployeeById(@PathVariable(name="id", required = true) String id) {
        return employeeService.getEmployeeById(id);
    }
    @GetMapping(path = "/with-params")// ad veya soyad ile çalışan getirme
    public List<Employee> getEmployeeWithParams(@RequestParam(name = "firstName",required = false)String firstName,
                                                @RequestParam(name = "lastName", required = false) String lastName) {
        return employeeService.getEmployeeWithParams(firstName, lastName);
    }
    @PostMapping(path = "/save-employee")// yeni çalışan ekleme
    public Employee saveEmployee(@RequestBody Employee newEmployee) {
        return employeeService.saveEmployee(newEmployee);
    }
    @DeleteMapping(path = "/delete-employee/{id}")// id ye göre çalışan verisini sil
    public boolean deleteEmployee(@PathVariable(name="id", required = true) String id) {
        return employeeService.deleteEmployee(id);
    }
    @PutMapping(path = "/update-employee/{id}")// id ile çalışan verilerini güncelle
    public Employee updateEmployee(@PathVariable(name="id") String id,@RequestBody UpdateEmployeeRequest request) {
        return employeeService.updateEmployee(id, request);
    }


}

