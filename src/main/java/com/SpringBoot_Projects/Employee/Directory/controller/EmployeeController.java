package com.SpringBoot_Projects.Employee.Directory.controller;

import com.SpringBoot_Projects.Employee.Directory.entity.Employee;
import com.SpringBoot_Projects.Employee.Directory.error.EmployeeNotFoundException;
import com.SpringBoot_Projects.Employee.Directory.service.EmployeeService;
import com.SpringBoot_Projects.Employee.Directory.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;

@RestController
public class EmployeeController {
// rest API endpoint here
    // need to be passed to service layer
    @Autowired // using dependancy injection
    private EmployeeService employeeService;

    //Important!!
    //adding logger for debugging purpost
    private final Logger LOGGER =  LoggerFactory.getLogger(EmployeeController.class);
    @PostMapping("/employee/v1/")
    public Employee saveEmployee(@Valid @RequestBody Employee employee){
        LOGGER.info("incoming into saveEmployee of EmployeeController");
        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/employee/v1/")
    public List<Employee> fetchAllEmployee(){
        return employeeService.fetchAllEmployee();
    }
    @GetMapping("/employee/v1/{id}") //dynamic value
    public Employee fetchById(@PathVariable("id") Long employeeId) throws EmployeeNotFoundException {
        return employeeService.fetchById(employeeId);
    }
    @DeleteMapping("/employee/v1/{id}")
    public String deleteById(@PathVariable("id") Long employeeId){
        employeeService.deleteById(employeeId);
        return "employee deleted successfully!";
    }
    @PutMapping("/employee/v1/{id}")
    public Employee updateById(@PathVariable("id") Long employeeId,@RequestBody  Employee employee){
        return employeeService.updateById(employeeId , employee);
    }
    @GetMapping("/employee/v1/name/{name}")
    public Employee FindByEmployeeName(@PathVariable("name") String name){
        return employeeService.findByEmployeeName(name);
    }
}
