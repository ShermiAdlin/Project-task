package com.te.implementingcache.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.te.implementingcache.entity.Book;
@Repository
public interface BookDAO extends JpaRepository<Book, Integer> {
	
	
}
