package com.brdway.springbootmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brdway.springbootmvc.model.Department;


public interface Departmentrepository extends JpaRepository<Department, Integer> {

}
