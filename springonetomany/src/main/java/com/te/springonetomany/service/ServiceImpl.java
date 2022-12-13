package com.te.springonetomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springonetomany.bean.Teacher;
import com.te.springonetomany.dao.TeacherDAO;
@Service
public class ServiceImpl implements StudentService {
	@Autowired
	private TeacherDAO dao;

	@Override
	public Teacher addStudent(Teacher teacher) {
		// TODO Auto-generated method stub
		return dao.save(teacher);
	
	}

	@Override
	public List<Teacher> getAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
