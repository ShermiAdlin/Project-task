 package com.te.springonetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springonetomany.bean.Teacher;
import com.te.springonetomany.service.StudentService;
@RestController
public class StdController {
	@Autowired
	private StudentService service;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Teacher teacher){
	Teacher teacher2=	service.addStudent(teacher);
		return new ResponseEntity<String>("data saved",HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> findAll(){
		List<Teacher> list = service.getAll();
		return new ResponseEntity<List<Teacher>>(list, HttpStatus.ACCEPTED);
	}

}
