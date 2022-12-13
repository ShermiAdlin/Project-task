package com.te.testcasedemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.testcasedemo.entity.Student;
@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {

}
