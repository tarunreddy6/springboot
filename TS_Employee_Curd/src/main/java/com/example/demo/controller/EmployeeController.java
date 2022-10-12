package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Employee;
import com.example.demo.service.Service_Implementation;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	Service_Implementation service_imp;
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		List<Employee> employee = service_imp.findAll();
		model.addAttribute("EMPLOYEES", employee);
		return "Employee/listEmployees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("EMPLOYEE", employee);
		return "employee/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("EMPLOYEE") Employee employee) {
		
		service_imp.save(employee);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
		
		Employee employee = service_imp.findById(id);
		model.addAttribute("EMPLOYEE", employee);
		return "employee/employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {
		
		service_imp.deleteById(id);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("employeeName") String name, Model model) {
		
		List<Employee> employees = service_imp.searchBy(name);
		model.addAttribute("EMPLOYEES", employees);
		return "/employee/listEmployees";
	}
}