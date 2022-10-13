package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface Employee_service_declarations {
	
	public List<Employee> findAll();
	public Employee findById(int id);
	public void insertOrUpdate(Employee employee);
	public void deleteById(int id);
	
}
