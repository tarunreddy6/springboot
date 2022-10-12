package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface Service_Declaration {
	
	public List<Employee> findAll();
	public Employee findById(int id);
	public void save(Employee employee);
	public void deleteById(int id);
	public List<Employee> searchBy(String name);

}
