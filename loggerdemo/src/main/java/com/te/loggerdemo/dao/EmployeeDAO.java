package com.te.loggerdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.loggerdemo.entity.Employee;
@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
