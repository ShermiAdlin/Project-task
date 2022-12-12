package com.te.pdfgeneration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.te.pdfgeneration.dao.UserDAO;
import com.te.pdfgeneration.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO dao;

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return dao.save(user);
	}

	@Override
	public List<User> findALL() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by("userName").ascending());
	}

}
