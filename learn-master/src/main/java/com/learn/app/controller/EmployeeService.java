package com.learn.app.controller;

import com.learn.app.aop.PayloadLogger;
import com.learn.app.data.Employee;
import com.learn.app.exception.EmployeeNotFound;
import com.learn.app.jpa.entity.User;
import com.learn.app.jpa.entity.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    UserRepositary userRepositary;


    @PayloadLogger
    public Employee[] getEmployee(String id) throws EmployeeNotFound {
        ResponseEntity<Employee[]> response = restTemplate.getForEntity("http://localhost:8080/employee/"+ id, Employee[].class);

        if(response.getStatusCode()== HttpStatus.NOT_FOUND) {
            throw new EmployeeNotFound("employee with id not found"+ id);
        }

        Employee[] employees = response.getBody();
        return employees;
    }

    public Employee[]  getEmployeeFromDB(Long id) throws EmployeeNotFound {
        List<User> users = userRepositary.findAll();

        if(users== null || users.isEmpty()) {
            throw new EmployeeNotFound("employee with id not found"+ id);
        }

        Optional<User> opt = users.stream().filter(u->u.getId()==id).findFirst();
        User user = opt.get();

        Employee employee = new Employee();
        employee.setId(user.getId());
        employee.setEmail(user.getEmail());
        employee.setFirstName(user.getFirstName());
        employee.setLastNme(user.getLastName());
        Employee[] employees = new Employee[1];
        employees[0] =employee;
        return employees;
    }
}
