package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.EmployeeNotFoundException;
import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		
		this.employeeRepository = employeeRepository;
	}
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeById(Integer id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	public void deleteById(Integer id) {
		employeeRepository.deleteById(id);
	}
	public Employee updateEmployee(Integer id, Employee employee) {

	    Employee existingEmployee = employeeRepository.findById(id)
	            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));

	    existingEmployee.setName(employee.getName());
	    existingEmployee.setEmail(employee.getEmail());
	    existingEmployee.setSalary(employee.getSalary());
	    existingEmployee.setDepartment(employee.getDepartment());

	    return employeeRepository.save(existingEmployee);
	}
	

}
