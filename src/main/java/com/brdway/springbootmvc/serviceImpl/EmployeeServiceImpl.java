package com.brdway.springbootmvc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brdway.springbootmvc.model.Employee;
import com.brdway.springbootmvc.repository.EmployeeRepository;
import com.brdway.springbootmvc.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	@Override
	public void addEmp(Employee emp) {
		// TODO Auto-generated method stub
		empRepo.save(emp);
	}

	@Override
	public void deleteEmp(Long id) {
		// TODO Auto-generated method stub
		empRepo.deleteById(id);
	}

	@Override
	public void updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		empRepo.save(emp);
	}

	@Override
	public Employee getEmpById(Long id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id).get();	}

	@Override
	public List<Employee> getAllEmps() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

}
