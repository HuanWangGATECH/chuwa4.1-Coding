package com.learn.app.controller;

import com.learn.app.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestClientController {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestTemplate restTemplateHttpConnection;




    @GetMapping(path="/employees/{name}", produces = "application/json")
    public List<Employee> getEmployeeByName(@PathVariable String name)  {
        ResponseEntity<Employee[]> employees = restTemplate.getForEntity("http://localhost:8080/employees", Employee[].class);
        List<Employee> employeeList = Arrays.asList(employees.getBody());
        List<Employee>  filteredList = employeeList.stream().filter(employee -> employee.getFirstName().equals(name)).collect(Collectors.toList());
        return filteredList;
    }

    @GetMapping(path="/employeesByNaive/{name}", produces = "application/json")
    public List<Employee> getEmployeeByNameNaive(@PathVariable String name)  {

        List<Employee> wrapper = restTemplate.getForObject("http://localhost:8080/employees", List.class);
        return wrapper;
    }

    @GetMapping(path="/employeesByActual/{name}", produces = "application/json")
    public List<Employee> getEmployeeByNameActual(@PathVariable String name)  {

        ResponseEntity<Employee[]> employees = restTemplateHttpConnection.getForEntity("http://localhost:8080/employees", Employee[].class);
        List<Employee> employeeList = Arrays.asList(employees.getBody());
        List<Employee>  filteredList = employeeList.stream().filter(employee -> employee.getFirstName().equals(name)).collect(Collectors.toList());
        return filteredList;
    }

}
