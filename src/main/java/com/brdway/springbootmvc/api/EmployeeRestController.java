package com.brdway.springbootmvc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.brdway.springbootmvc.model.Employee;
import com.brdway.springbootmvc.model.Product;
import com.brdway.springbootmvc.repository.ProductRepository;
import com.brdway.springbootmvc.service.EmployeeService;

@RestController
public class EmployeeRestController {
  

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private ProductRepository prodRepo;
	
	@GetMapping("/api/emp/list")
	public List<Employee> getAll() {
		return empService.getAllEmps();
		
	}
	
	@GetMapping("/api/emp/{id}")
	public Employee getOne(@PathVariable("id") Long id) {
		return empService.getEmpById(id);
	}
	
	@PostMapping("/api/emp/add")
	public String add(@RequestBody Employee emp) {
		return "added successfully";
	}
	
	@DeleteMapping("/api/emp/delete/{id}")
	public String delete(@PathVariable ("id") Long id) {
		empService.deleteEmp(id);
		return "deleted";
	}
	
	@PutMapping("/api/emp/update")
	public String update(@RequestBody Employee emp) {
		
		empService.updateEmp(emp);
		return "";
	}
	
	@GetMapping("/api/emp/j20")
	public String jsonToObject() {
		
		RestTemplate rest = new RestTemplate();
		Employee emp = rest.getForObject("http://localhost:8080/api/emp/2", Employee.class);
		return"FirstName ="+emp.getFname();
	}
	
	@GetMapping("/api/emp/ja2oa")
	public String jsonArrayToObject() {
		RestTemplate temp = new RestTemplate();
		Employee [] emps= temp.getForObject("http://localhost:8080/api/emp/list",Employee[].class);
		return"Name ="+emps[0].getFname()+emps[0].getLname();
	}
	
	@GetMapping("/api/load")
	public String productApi() {
		RestTemplate temp = new RestTemplate();
		Product[] prods= temp.getForObject("https://fakestoreapi.com/products",Product[].class);
		
		prodRepo.saveAll(List.of(prods));
		return "api call success";
	}
}
