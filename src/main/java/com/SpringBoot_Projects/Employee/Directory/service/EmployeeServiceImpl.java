package com.SpringBoot_Projects.Employee.Directory.service;

import com.SpringBoot_Projects.Employee.Directory.entity.Employee;
import com.SpringBoot_Projects.Employee.Directory.error.EmployeeNotFoundException;
import com.SpringBoot_Projects.Employee.Directory.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    @Override
    public List<Employee> fetchAllEmployee(){
        return employeeRepository.findAll();
    }
    @Override
    public Employee fetchById(Long employeeId) throws EmployeeNotFoundException {
        Optional<Employee> employee =  employeeRepository.findById(employeeId);
        if(!employee.isPresent()){
            throw new EmployeeNotFoundException("Employee Not Found!");
        }
        return employee.get();
    }
    @Override
    public void deleteById(Long employeeId){
        employeeRepository.deleteById(employeeId);
    }
    @Override
    public Employee updateById(Long employeeId, Employee employee) {
        Employee old_data = employeeRepository.findById(employeeId).get();
        if (Objects.nonNull(employee.getName()) && !"".equalsIgnoreCase(employee.getName())) {
            old_data.setName(employee.getName());
        }
        if (Objects.nonNull(employee.getDepartment()) && !"".equalsIgnoreCase(employee.getDepartment())) {
            old_data.setDepartment(employee.getDepartment());
        }
        if (Objects.nonNull(employee.getEmail()) && !"".equalsIgnoreCase(employee.getEmail())) {
            old_data.setEmail(employee.getEmail());
        }
        if (Objects.nonNull(employee.getPh_no()) && !"".equalsIgnoreCase(employee.getPh_no())) {
            old_data.setPh_no(employee.getPh_no());
        }
    return employeeRepository.save(employee);

    }
    @Override
    public Employee findByEmployeeName(String name){
        return employeeRepository.findByName(name);
    }
}
