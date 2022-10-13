package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.Employee_service_implementations;

@RestController
public class Employee_Controller {
	
	@Autowired
	private Employee_service_implementations employeeservice;
	
	public Employee_Controller(Employee_service_implementations employeeservice) {
		this.employeeservice = employeeservice;
	}
	
	@GetMapping("/employees")
	public List<Employee> displayAll(){
		return employeeservice.findAll();
	}
	
	@GetMapping("employees/{employeeId}")
	public Employee displayById(@PathVariable int employeeId) throws Exception {
		
		Employee employee = employeeservice.findById(employeeId);
		if(employee == null)
			throw new Exception("details not found "+employeeId);
		else
			return employee;		
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		employee.setId(0);
		employeeservice.insertOrUpdate(employee);
		return employee;
	}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		employeeservice.insertOrUpdate(employee);
		return employee;
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) throws Exception {
		
		Employee employee = employeeservice.findById(employeeId);
		if(employee == null)
			throw new Exception("details not not found"+employeeId);
			else {
				employeeservice.deleteById(employeeId);
				return "Deleted employee id: "+employeeId;	
			}		
	}
}
