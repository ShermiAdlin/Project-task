package com.te.pdfgeneration.service;

import java.util.List;

import com.te.pdfgeneration.entity.User;

public interface UserService {
	
	public User addUser(User user);
	
	public List<User> findALL();

}
