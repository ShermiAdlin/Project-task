package com.te.streamdemo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.streamdemo.entity.Employee;
import com.te.streamdemo.service.EmployeeServiceImpl;

@RestController
public class EmployeecController {
	@Autowired
	private EmployeeServiceImpl service;
	@PostMapping("/addemployee")
	public ResponseEntity<?> register(@RequestBody Employee employee){
		Employee employee2 = service.addEmployee(employee);
		return new ResponseEntity<Employee>(employee2, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> get(@RequestBody Employee employee){
		List<Employee> employee2 = service.getAll();
		return new ResponseEntity<List<Employee>>(employee2, HttpStatus.ACCEPTED);
	}
	@GetMapping("/department")
	public ResponseEntity<?> getByDesignation(Employee employee){
		List<Employee> department = service.findByDepartment(employee);
		return new ResponseEntity<List<Employee>>(department,HttpStatus.ACCEPTED);
	}
	@GetMapping("/salary")
	public ResponseEntity<?> getBySalary(Employee employee){
		List<String> department = service.findSalary(employee);
		return new ResponseEntity<List<String>>(department,HttpStatus.ACCEPTED);
	}
	@GetMapping("/maxSalary")
	public ResponseEntity<?> maxSalary(Employee employee){
		Employee salary = service.maxSalary(employee);
		return new ResponseEntity<Employee>(salary,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/group")
	public ResponseEntity<?> groupByDept(Employee employee){
		Map<String, List<Employee>> map = service.basedOnDesignation(employee);
		return new ResponseEntity<Map<String, List<Employee>>>(map,HttpStatus.ACCEPTED);
	}

}
