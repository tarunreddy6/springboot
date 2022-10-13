package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Dao.EmployeeRepository;
import com.example.demo.entity.Employee;

@Service
public class Employee_service_implementations implements Employee_service_declarations {
	
	@Autowired
	private EmployeeRepository employeerepository;
	
	public Employee_service_implementations(EmployeeRepository employeerepository) {
	
		this.employeerepository = employeerepository;
	}

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
	public void insertOrUpdate(Employee employee) {
		
		employeerepository.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		
		employeerepository.deleteById(id);
	}

}
