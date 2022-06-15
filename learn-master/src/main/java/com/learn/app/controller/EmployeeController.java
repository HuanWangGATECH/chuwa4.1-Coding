package com.learn.app.controller;

import com.learn.app.data.Employee;
import com.learn.app.exception.EmployeeNotFound;
import com.learn.app.jpa.entity.User;
import com.learn.app.jpa.entity.UserRepositary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepositary userRepositary;

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/addEmployee")
    public String addEmployeeView(Model model) {

        model.addAttribute("employee", new Employee());
        return "addemployee";
    }

    @PostMapping("/addEmployee")
    public RedirectView addEmployee(@ModelAttribute("employee") Employee employee, Model model, HttpServletRequest httpServletRequest, RedirectAttributes attributes) {

       // ResponseEntity<Employee> response = restTemplate.postForEntity("http://localhost:8080/employee",employee,Employee.class);
      //  Employee saved = response.getBody();

        User user = new User();
        user.setLoginName(employee.getEmail());
        user.setFirstName(employee.getFirstName());
        user.setLastName(employee.getLastNme());
        user.setEmail(employee.getEmail());
        user.setPassword(passwordEncoder.encode(employee.getPassword()));
        userRepositary.save(user);

        employee.setId(user.getId());

        model.addAttribute("status", true);

        model.addAttribute("employee", employee);

        logger.info("test variable password"+user.getPassword());
        return new RedirectView("viewemployee/"+employee.getId());
    }

    @GetMapping("/viewemployee/{id}")
    public String addEmployee(@PathVariable("id") String id, Model model) throws Exception {

        Employee[] employees = employeeService.getEmployeeFromDB(Long.valueOf(id));
        model.addAttribute("status", true);
        model.addAttribute("employee", employees[0]);
        return "viewemployee";
    }

    public Employee[] getEmployee(String id) throws EmployeeNotFound {
        return employeeService.getEmployee(id);
    }
}
