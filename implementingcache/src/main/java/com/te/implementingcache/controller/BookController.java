package com.te.implementingcache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.implementingcache.entity.Book;
import com.te.implementingcache.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService service;
	
	@PostMapping("/save")
	public ResponseEntity<?> add(@RequestBody Book book){
		Book book2 = service.addBook(book);
		return new ResponseEntity<Book>(book2, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> get(@PathVariable Integer id){
		Book book2 = service.getBook(id);
		return new ResponseEntity<Book>(book2, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Book book,@PathVariable Integer id){
		Book book2 = service.updateBook(book,id);
		return new ResponseEntity<Book>(book2, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		String book = service.deleteBook(id);
		return new ResponseEntity<String>(book, HttpStatus.ACCEPTED);
	}

}
