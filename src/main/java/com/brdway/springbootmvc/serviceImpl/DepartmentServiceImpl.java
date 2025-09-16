package com.brdway.springbootmvc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brdway.springbootmvc.model.Department;
import com.brdway.springbootmvc.repository.Departmentrepository;
import com.brdway.springbootmvc.service.DepartmentService;

@Service
public class DepartmentServiceImpl  implements DepartmentService{

	@Autowired
	public Departmentrepository deptRepo;
	@Override
	public void addDept(Department dept) {
		// TODO Auto-generated method stub
		deptRepo.save(dept);
		
	}

	@Override
	public void deleteDept(int id) {
		// TODO Auto-generated method stub
		deptRepo.deleteById(id);
	}

	@Override
	public void updateDept(Department dept) {
		// TODO Auto-generated method stub
		deptRepo.save(dept);
	}

	@Override
	public Department getDeptById(int id) {
		// TODO Auto-generated method stub
		return deptRepo.findById(id).get();
	}

	@Override
	public List<Department> getAllDepts() {
		// TODO Auto-generated method stub
		return deptRepo.findAll();
	}

}
