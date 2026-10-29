package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		
		this.employeeService = employeeService;
	}
	
	@PostMapping
	public Employee saveEmployee(@Valid @RequestBody Employee emp) {
		return employeeService.saveEmployee(emp);
	}
	
	@GetMapping
	public List<Employee> getEmployees(){
		return employeeService.getAllEmployee();
		
	}
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Integer id) {
		return employeeService.getEmployeeById(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable Integer id) {
		employeeService.deleteById(id);
		return "Employee Deleted Successfully";
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Integer id,
	                               @RequestBody Employee employee) {

	    return employeeService.updateEmployee(id, employee);
	}
	

}
