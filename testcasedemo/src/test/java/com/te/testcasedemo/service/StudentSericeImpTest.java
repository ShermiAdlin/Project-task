package com.te.testcasedemo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.te.testcasedemo.controller.StudentController;
import com.te.testcasedemo.dao.StudentDAO;
import com.te.testcasedemo.entity.Student;

@SpringBootTest
class StudentSericeImpTest {

	@Autowired
	private StudentSericeImp service;
	
	@MockBean
	private StudentDAO dao;
	
	@BeforeEach
	void setUp() {
		Optional<Student> optional = Optional.of(new Student(1, "abc", "def"));
		Mockito.when(dao.findById(1)).thenReturn(optional);
	}
	@Test
	public void testGetById() {
		String name="abc";
		//String name="abc1";
		
		Student id = service.getById(1);
		assertEquals(name, id.getName());
	}

}
