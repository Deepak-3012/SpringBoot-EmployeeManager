package com.SpringBoot_Projects.Employee.Directory.repository;

import com.SpringBoot_Projects.Employee.Directory.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
public Employee findByName(String name);



}
