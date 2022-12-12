package com.te.implementingcache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.te.implementingcache.dao.BookDAO;
import com.te.implementingcache.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired 
	private BookDAO dao;
	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return dao.save(book);
	}
	@Override
	@Cacheable(cacheNames = "books",key = "#id")
	public Book getBook(Integer id) {
	System.out.println("before catching");
		return dao.findById(id).get();
	}
	@Override
	@CachePut(cacheNames  = "books",key = "#id")
	public Book updateBook(Book book,Integer id) {
	System.out.println("before cache update");
		Book book1 = dao.findById(id).get();
	book1.setName(book.getName());
	book1.setCategory(book.getCategory());
	book1.setAuthor(book.getAuthor());
	return dao.save(book1);
	}
	@Override
	@CacheEvict(cacheNames = "books", key = "#id")
	public String deleteBook(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("before cache delete");
		dao.deleteById(id);
		return "Book deleted";
	}
	

}
