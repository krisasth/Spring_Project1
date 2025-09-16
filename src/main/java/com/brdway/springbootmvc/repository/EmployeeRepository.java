package com.brdway.springbootmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brdway.springbootmvc.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
