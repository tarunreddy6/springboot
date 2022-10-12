package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employee;
import com.example.demo.persistance.EmployeeRepository;

@Service
public class Service_Implementation implements Service_Declaration {
	
	@Autowired
	EmployeeRepository employeerepository;

	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeerepository.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		
		return employeerepository.findById(id).get();
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeerepository.save(employee);
		
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		employeerepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public List<Employee> searchBy(String name) {
		
		List<Employee> results = null;
		if(name != null && (name.trim().length() > 0))
			results = employeerepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(name, name);
		else
			results = findAll();
		return results;
	}

}
