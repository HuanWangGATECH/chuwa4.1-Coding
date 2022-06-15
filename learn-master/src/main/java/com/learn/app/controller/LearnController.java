package com.learn.app.controller;

import com.learn.app.NotImplementedException;
import com.learn.app.data.Employee;
import com.learn.app.data.ErrorInfo;
import com.learn.app.jpa.entity.AddressRepository;
import com.learn.app.jpa.entity.User;
import com.learn.app.jpa.entity.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LearnController {

    @Autowired
    private ApplicationContext context;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserRepositary userRepositary;

    @Autowired
    @Qualifier("addressRepoImpl")
    AddressRepository addressRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String index() {

        return "Greetings from Spring Boot!";
    }

    @GetMapping(path="/employees", produces = "application/json")
    public List<Employee> getEmployees()  {

        List<Employee> employees = new ArrayList<>();
        List<User> users = userRepositary.findAll();
        for (User user : users) {
            Employee employee = context.getBean(Employee.class);
            employee.setFirstName(user.getFirstName());
            employee.setLastNme(user.getLastName());
            employee.setEmail(user.getEmail());
            employees.add(employee);
        }

        return employees;
    }

    @GetMapping(path="/employeesByEmail/{email}", produces = "application/json")
    public List<Employee> getEmployeesByEmail(@PathVariable String email)  {


        List<Employee> employees = new ArrayList<>();
        List<User> users = userRepositary.findByEmail(email);
        for (User user : users) {
            Employee employee = context.getBean(Employee.class);
            employee.setFirstName(user.getFirstName());
            employee.setLastNme(user.getLastName());
            employee.setEmail(user.getEmail());
            employees.add(employee);
        }

        return employees;
    }

    @GetMapping(path="/employee/{id}", produces = "application/json")
    public List<Employee> getEmployee(@PathVariable Long id)  throws Exception {
        List<Employee> employees = new ArrayList<>();
        List<User> users = userRepositary.findAll();
        users = users.stream().filter(user->user.getId()==id).collect(Collectors.toList());
        for (User user : users) {
            Employee employee = context.getBean(Employee.class);
            employee.setFirstName(user.getFirstName());
            employee.setLastNme(user.getLastName());
            employee.setEmail(user.getEmail());
            employee.setId(user.getId());
            employees.add(employee);

        }
        return employees;
    }

    @PutMapping(path="/employee/{id}", produces = "application/json")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee)  throws Exception {
        employee.setId(id);
        int count = namedParameterJdbcTemplate.update(
                "update User set FIRST_NAME =:firstName, LAST_NAME = :lastNme, EMAIL = :email where id = :id",
                new BeanPropertySqlParameterSource(employee));
        if(count>0) {
          return  new ResponseEntity<>(employee, HttpStatus.OK);
        }

        return new ResponseEntity<>(employee, HttpStatus.NOT_FOUND);
    }

    @PutMapping(path="/address/create", produces = "application/json")
    public void createAddressTable()  throws Exception {
        jdbcTemplate.execute("DROP TABLE ADDRESS IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE ADDRESS(" +
                "ID BIGINT, STREET_NAME VARCHAR(255))");
    }

    @PostMapping(path="/employee", produces = "application/json",consumes = "application/json")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)  throws Exception {
        User user = new User();
        user.setLoginName(employee.getEmail());
        user.setFirstName(employee.getFirstName());
        user.setLastName(employee.getLastNme());
        user.setEmail(employee.getEmail());
        //user.setPassword(passwordEncoder.encode(employee.getPassword()));
        try {
            userRepositary.save(user);
        } catch (Exception e) {
            throw new NotImplementedException("not yet implemented");
        }
        employee.setId(user.getId());
      //  addressRepository.save(employee.getAddress(),user);


        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }

    @PostMapping(path="/employee/Naive", produces = "application/json",consumes = "application/json")
    public ResponseEntity<Employee> addEmployeeNaive(@RequestBody Employee employee)  throws Exception {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(null);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        User user = new User();
        user.setLoginName(employee.getFirstName()+"login2");
        user.setFirstName(employee.getFirstName());
        user.setLastName(employee.getLastNme());
        user.setEmail(employee.getFirstName()+"_"+employee.getLastNme()+"@gmail.com");
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }


    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotImplementedException.class)
    @ResponseBody ErrorInfo unhandled() {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setId("not_supported");
        errorInfo.setMessage("operation not yet implemented");
        return errorInfo;
    }

}
