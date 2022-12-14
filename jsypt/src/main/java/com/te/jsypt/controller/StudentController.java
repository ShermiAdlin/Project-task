package com.te.jsypt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.jsypt.entity.Student;
import com.te.jsypt.service.StudentServiceImpl;

@RestController
public class StudentController {
	@Autowired
	private StudentServiceImpl service;
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Student student){
		Student student2 = service.addStudent(student);
		return new ResponseEntity<Student>(student2, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/find")
	public ResponseEntity<?> find(){
		List<Student> list = service.getAll();
		return new ResponseEntity<List<Student>>(list,HttpStatus.ACCEPTED);
	}

}
