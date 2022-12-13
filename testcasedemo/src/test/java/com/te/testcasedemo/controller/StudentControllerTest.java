package com.te.testcasedemo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.testcasedemo.entity.Student;
import com.te.testcasedemo.service.StudentSericeImp;
@WebMvcTest(StudentController.class)
class StudentControllerTest {
@Autowired
private	MockMvc mockMvc;

@MockBean
private StudentSericeImp servise;
@Test
public void addTest() throws JsonProcessingException, Exception {
	Student student = new Student(1, "abc", "def");
	when(servise.addStudent(student)).thenReturn(student);
mockMvc.perform(post("/register")
		.contentType(MediaType.APPLICATION_JSON)
		.content(new ObjectMapper().writeValueAsString(student)))
.andExpect(status().isAccepted());
}
@Test
public void getTest() throws JsonProcessingException, Exception {
	Student student = new Student(1, "abc", "def");
	when(servise.getById(1)).thenReturn(student);
mockMvc.perform(get("/get/{id}", 1)
		.contentType(MediaType.APPLICATION_JSON))
.andExpect(status().isAccepted())
.andExpect(jsonPath("$.name").value("abc"));

}
}
