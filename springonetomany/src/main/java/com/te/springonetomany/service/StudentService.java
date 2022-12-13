package com.te.springonetomany.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.te.springonetomany.bean.Teacher;


public interface StudentService {
	
public Teacher addStudent(Teacher teacher);


public List<Teacher> getAll();
}
