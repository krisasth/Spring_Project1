package com.brdway.springbootmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.brdway.springbootmvc.model.Employee;
import com.brdway.springbootmvc.service.DepartmentService;
import com.brdway.springbootmvc.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private DepartmentService deptservice;

	@Autowired
	private EmployeeService empservice;

	@GetMapping("/employee")
	public String getEmployee(Model model) {
		model.addAttribute("dList", deptservice.getAllDepts());
		return "EmployeeForm";
	}

	@PostMapping("/employee")
	public String postEmployee(@ModelAttribute Employee emp) {
		empservice.addEmp(emp);
		return "redirect:/employee";
	}
}
