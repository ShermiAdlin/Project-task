package com.te.implementingcache.service;

import java.util.List;

import com.te.implementingcache.entity.Book;

public interface BookService {
	
	public Book addBook(Book book);
	
	public Book getBook(Integer id);
	
	public Book updateBook(Book book,Integer id);
	
	public String deleteBook(Integer id);

}
