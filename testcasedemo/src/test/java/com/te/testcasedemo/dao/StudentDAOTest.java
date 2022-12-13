package com.te.testcasedemo.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.te.testcasedemo.entity.Student;
import com.te.testcasedemo.entity.Student.StudentBuilder;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentDAOTest {
	@Autowired
	private StudentDAO dao;
	//@Autowired
		//TestEntityManager manager;

	@Test
public	void addStudentTest(){
	//Student student = new Student(17, "pqr", "lmn");
	//entityManager.persist(student);
	Student student2= new Student().builder().name("abcd").department("pqrs").build();
dao.save(student2);

Assertions.assertThat(student2.getId()).isGreaterThan(0);

	}
@Test
public void testGetById() {
	Student student = dao.findById(1).get();
Assertions.assertThat(student.getId()).isEqualTo(1);
}
}
