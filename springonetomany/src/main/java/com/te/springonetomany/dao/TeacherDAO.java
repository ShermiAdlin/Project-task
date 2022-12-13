package com.te.springonetomany.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.springonetomany.bean.Student;
import com.te.springonetomany.bean.Teacher;
@Repository
public interface TeacherDAO extends JpaRepository<Teacher, Integer> {

}
