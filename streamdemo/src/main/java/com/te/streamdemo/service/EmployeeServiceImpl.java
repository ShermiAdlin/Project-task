package com.te.streamdemo.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.streamdemo.dao.EmployeeDAO;
import com.te.streamdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return dao.save(employee); 
	}
	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	@Override
	public List<Employee> findByDepartment(Employee employee) {
		// TODO Auto-generated method stub
		return dao.findAll().stream().filter(f1->f1.getEmpDesignation().equals("vj")).toList();
	}
	@Override
	public List<String> findSalary(Employee employee) {
		// TODO Auto-generated method stub
		return dao.findAll().stream().filter(e->e.getSalary()>50000.0).map(Employee::getEmpName).toList();
	}
	@Override
	public Employee maxSalary(Employee employee) {
		// TODO Auto-generated method stub
		return dao.findAll().stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get();
	}
	@Override
	public Map<String, List<Employee>> basedOnDesignation(Employee employee) {
		// TODO Auto-generated method stub
		return dao.findAll().stream().collect(Collectors.groupingBy(Employee::getEmpDesignation));
	}

}
