package com.te.springmongoautoincrement.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.te.springmongoautoincrement.entity.Employee;
@Repository
public interface EmployeeDAO extends MongoRepository<Employee, Integer>{

}
