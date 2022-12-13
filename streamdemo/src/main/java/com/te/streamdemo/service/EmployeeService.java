package com.te.streamdemo.service;

import java.util.List;
import java.util.Map;

import com.te.streamdemo.entity.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	
	public List<Employee> getAll();
	
	public List<Employee> findByDepartment(Employee employee);
	
	public List<String> findSalary(Employee employee);
	
	public Employee maxSalary(Employee employee);
	
	public Map<String, List<Employee>> basedOnDesignation(Employee employee);

}
