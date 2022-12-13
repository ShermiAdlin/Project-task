package com.te.springmongoautoincrement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springmongoautoincrement.entity.Employee;
import com.te.springmongoautoincrement.service.EmployeeServiceImpl;
import com.te.springmongoautoincrement.service.SequenceGeneratedService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeServiceImpl service;
	
	@GetMapping("/save")
	public ResponseEntity<?> add(@RequestBody Employee employee){
		
	Employee employee2 = service.save(employee);
		
		return new ResponseEntity<Employee>(employee2, HttpStatus.OK);
	}

}

