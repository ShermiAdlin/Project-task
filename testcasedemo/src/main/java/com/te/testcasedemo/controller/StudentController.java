package com.te.testcasedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.testcasedemo.entity.Student;
import com.te.testcasedemo.service.StudentSericeImp;


@RestController
public class StudentController {
	@Autowired
	private StudentSericeImp service;
	@PostMapping("/register")
	public ResponseEntity<?> add(@RequestBody Student student){
		Student student2 = service.addStudent(student);
		return new ResponseEntity<Student>(student2,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> get(@PathVariable Integer id){
		Student byId = service.getById(id);
		return new ResponseEntity<Student>(byId,HttpStatus.ACCEPTED);
	}
}
