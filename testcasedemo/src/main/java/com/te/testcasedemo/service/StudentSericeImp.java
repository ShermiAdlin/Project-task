package com.te.testcasedemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.testcasedemo.dao.StudentDAO;
import com.te.testcasedemo.entity.Student;

@Service
public class StudentSericeImp implements StudentService {
	@Autowired
	private StudentDAO dao;

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return dao.save(student);
	}

	@Override
	public Student getById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

}
