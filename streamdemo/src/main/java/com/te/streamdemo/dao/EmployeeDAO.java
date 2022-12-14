package com.te.streamdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.streamdemo.entity.Employee;
@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
