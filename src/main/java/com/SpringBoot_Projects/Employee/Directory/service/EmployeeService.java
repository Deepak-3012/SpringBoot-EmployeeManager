package com.SpringBoot_Projects.Employee.Directory.service;

import com.SpringBoot_Projects.Employee.Directory.entity.Employee;
import com.SpringBoot_Projects.Employee.Directory.error.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);
    public List<Employee> fetchAllEmployee();
    public Employee fetchById(Long employeeId) throws EmployeeNotFoundException;
    public void deleteById(Long employeeId);
    public Employee updateById(Long employeeId , Employee employee);
    public Employee findByEmployeeName(String name);
}
