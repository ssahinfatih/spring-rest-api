package com.fatihsahin.services;

import com.fatihsahin.model.Employee;
import com.fatihsahin.model.UpdateEmployeeRequest;
import com.fatihsahin.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployeeList() {//tüm çalışanları getir
        return  employeeRepository.getAllEmployeeList();
    }
    public Employee getEmployeeById(String id) {//id ile çalışanı getir
        return employeeRepository.getEmployeeById(id);
    }
    public List <Employee> getEmployeeWithParams(String firstName, String lastName) {// ad veya soyad ile getir
        return employeeRepository.getEmployeeWithParams(firstName,  lastName);
    }
    public Employee saveEmployee(Employee newEmployee) {// yeni çalışan ekleme
        return employeeRepository.saveEmployee(newEmployee);
    }
    public boolean deleteEmployee(String id) {// id ye göre çalışan verisini sil
        return employeeRepository.deleteEmployee(id);
    }
    public Employee updateEmployee(String id, UpdateEmployeeRequest request) {// id ile çalışan verilerini güncelle
        return employeeRepository.updateEmployee(id, request);
    }
}
