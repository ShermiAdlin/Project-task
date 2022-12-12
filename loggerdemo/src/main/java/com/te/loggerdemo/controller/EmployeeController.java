package com.te.loggerdemo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.loggerdemo.entity.Employee;
import com.te.loggerdemo.service.EmployeeServiceImpl;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl service;
	
	Logger logger=LoggerFactory.getLogger(EmployeeController.class);
	
	@PostMapping(value="/register")
	public ResponseEntity<?> register( @RequestBody Employee employee){
		logger.info("hi");
		Employee employee1= service.addEmployee(employee);
		if(employee1!=null) {
		
	return new ResponseEntity<String>("data saved",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("data not saved", HttpStatus.BAD_REQUEST);
		}
		
	}
}
