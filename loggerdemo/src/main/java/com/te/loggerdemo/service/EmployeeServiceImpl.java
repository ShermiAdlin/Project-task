package com.te.loggerdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.loggerdemo.dao.EmployeeDAO;
import com.te.loggerdemo.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO dao;

	@Override
	public Employee addEmployee(Employee employee) {
		
		return dao.save(employee);
	}

}
