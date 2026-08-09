package com.fatihsahin.config;

import com.fatihsahin.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public List<Employee> employeeList() {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1","Fatih","Şahin"));
        employeeList.add(new Employee("2","Kadir","Doğan"));
        employeeList.add(new Employee("3","Ali","Kara"));
        employeeList.add(new Employee("4","Fatma","Yıldız"));
        return employeeList;


    }
}
