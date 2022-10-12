package com.example.demo.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findAllByOrderByFirstNameAsc();
	public List<Employee> 
	findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lname);

}
