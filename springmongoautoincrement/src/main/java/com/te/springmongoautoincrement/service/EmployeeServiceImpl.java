package com.te.springmongoautoincrement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springmongoautoincrement.dao.EmployeeDAO;
import com.te.springmongoautoincrement.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
	EmployeeDAO dao;

@Autowired
SequenceGeneratedService service;
	
	@Override
	public Employee save(Employee employee) {
		//Setting the id  
	employee.setId(service.getSequenceNumber(Employee.SEQUENCENAME));
		return dao.save(employee);
	}

}
