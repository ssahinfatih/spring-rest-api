package com.fatihsahin.repository;

import com.fatihsahin.model.Employee;
import com.fatihsahin.model.UpdateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    private List<Employee> employeeList;
    public List<Employee> getAllEmployeeList() {//tüm çalışanları getir
        return employeeList;
    }

    public Employee getEmployeeById(String id) {//id ile çalışanı getir
        Employee findEmployee= null;
        for (Employee employee : employeeList) {
            if(id.equals(employee.getId())){
                findEmployee = employee;
                break;
            }
        }
        return findEmployee;
    }
    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {// ad veya soyad ile getir
        List<Employee> employeeListWithParams = new ArrayList<>();
        if (firstName == null && lastName == null) {
            return employeeList;
        }
        for (Employee employee : employeeList) {
            if(firstName!=null && lastName!=null){
                if(employee.getFirstName().equalsIgnoreCase(firstName)&&employee.getLastName().equalsIgnoreCase(lastName)){
                  employeeListWithParams.add(employee);
                }
            }
            if(firstName!=null && lastName==null){
                if(employee.getFirstName().equalsIgnoreCase(firstName)){
                    employeeListWithParams.add(employee);
                }
            }
            if(lastName!=null  && firstName==null ){
                if(employee.getLastName().equalsIgnoreCase(lastName)){
                    employeeListWithParams.add(employee);
                }
            }
        }
        return employeeListWithParams;


    }
    public Employee saveEmployee(Employee newEmployee) {// yeni çalışan ekleme
    employeeList.add(newEmployee);
    return newEmployee;
    }

    public  boolean deleteEmployee(String id) {// id ye göre çalışan verisini sil
        Employee deleteEmployee = null;
        for (Employee employee : employeeList) {
            if (id.equals(employee.getId())) {
                deleteEmployee = employee;
                break;
            }
        }
        if (deleteEmployee == null) {
            return false;
        }
        employeeList.remove(deleteEmployee);
        return true;


    }
    private Employee findEmployeeById(String id) {// id ile çalışan verilerini güncelleme için gerekli
        Employee findEmployee = null;
        for (Employee employee : employeeList) {
            if(employee.getId().equals(id)){
              findEmployee = employee;
              break;
            }
        }
        return findEmployee;
    }
    public Employee updateEmployee(String id, UpdateEmployeeRequest request) {// id ile çalışan verilerini güncelle
        Employee findEmployee = findEmployeeById(id);
        if(findEmployee != null){
            deleteEmployee(id);
            Employee updateEmployee = new Employee();
            updateEmployee.setId(id);
            updateEmployee.setFirstName(request.getFirstName());
            updateEmployee.setLastName(request.getLastName());

            employeeList.add(updateEmployee);
            return updateEmployee;
        }
     return null;
    }
}
