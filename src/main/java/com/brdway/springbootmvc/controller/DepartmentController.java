package com.brdway.springbootmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.brdway.springbootmvc.model.Department;
import com.brdway.springbootmvc.service.DepartmentService;
import com.brdway.springbootmvc.utils.DepartmentExcelView;
import com.brdway.springbootmvc.utils.DepartmentPdfView;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService deptservice;
	@GetMapping("/department")
	public String getDepartment() {
		return "DepartmentForm";
	}
	
	@PostMapping("/department")
	public String postDepartment(@ModelAttribute Department dept) {
		deptservice.addDept(dept);
		return "departmentForm";
	}
	
	@GetMapping("/departmentList")
	public String getAll(Model model) {
		
		model.addAttribute("dlist",deptservice.getAllDepts());
		return"DepartmentListForm";
	}
	
	@GetMapping("dept/delete")
	public String delete(@RequestParam("id")  int id) {
		deptservice.deleteDept(id);
		return"redirect:/departmentList";
	}
	
	@GetMapping("dept/edit")
	public String edit(@RequestParam("id") int id, Model model) {
		
		model.addAttribute("dmodel", deptservice.getDeptById(id));
		return"EditDepartmentForm";
	}
	
	@PostMapping("/dept/update")
	public String update(@ModelAttribute Department dept) {
		
		deptservice.updateDept(dept);
		return"redirect:/departmentList";
	}
	
	@GetMapping("/dept/excel")
	public ModelAndView getExcel() {
		ModelAndView mv =new ModelAndView();
		mv.addObject("dList",deptservice.getAllDepts());
		mv.setView(new DepartmentExcelView() );
		return mv;
	}
	
	@GetMapping("/dept/pdf")
	public ModelAndView  getpd() {
		ModelAndView mv =new ModelAndView();
		mv.addObject("dList",deptservice.getAllDepts());
		mv.setView(new DepartmentPdfView());
		return mv;
	}
}
