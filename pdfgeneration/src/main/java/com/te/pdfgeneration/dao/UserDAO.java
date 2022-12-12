package com.te.pdfgeneration.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pdfgeneration.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

}
