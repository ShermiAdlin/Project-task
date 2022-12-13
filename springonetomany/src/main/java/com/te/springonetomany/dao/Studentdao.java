package com.te.springonetomany.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.springonetomany.bean.Student;
@Repository
public interface Studentdao extends JpaRepository<Student, Integer> {

}
