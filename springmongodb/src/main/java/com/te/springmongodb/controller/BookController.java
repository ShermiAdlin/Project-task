package com.te.springmongodb.controller;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.te.springmongodb.entity.Book;
import com.te.springmongodb.entity.Publishers;
import com.te.springmongodb.service.BookService;
import com.te.springmongodb.service.BookServiceImpl;

@RestController
@ComponentScan(basePackages = { "com.te.springmongodb.service" })
public class BookController {

	@Autowired
	BookService service;

	@PostMapping("/book")
	public ResponseEntity<?> add(@RequestBody Book book) {
		Book book2 = service.addBook(book);

		return new ResponseEntity<Book>(book2, HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<?> getALL() {
		List<Book> book2 = service.getBook();

		return new ResponseEntity<List<Book>>(book2, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getById(@PathVariable String id) {
		Book id2 = service.getId(id);

		return new ResponseEntity<Book>(id2, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable String id, Book book) {
		Boolean delete1 = service.delete(book, id);

		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}

	@PutMapping("/book")
	public ResponseEntity<?> update(@RequestBody Book book) {
		Book updateBook = service.updateBook(book);

		return new ResponseEntity<Book>(updateBook, HttpStatus.OK);

	}

	@GetMapping("/name")
	public ResponseEntity<?> findByName(@RequestParam(required = false) String name) {
		List<Book> byNameLike = service.findByNameLike("Harry Potter");
		return new ResponseEntity<List<Book>>(byNameLike, HttpStatus.ACCEPTED);

	}

	@GetMapping("/price")
	public ResponseEntity<?> findByPrice(@RequestParam(required = false) Double price) {
		List<Book> byprice = service.findByPrice(3500.0);
		return new ResponseEntity<List<Book>>(byprice, HttpStatus.ACCEPTED);

	}

	@GetMapping("/btwprice")
	public ResponseEntity<?> findByPriceBtwn(@RequestParam(required = false) Double price) {
		List<Book> byprice = service.findByPriceBetween(3000.0, 5000.0);
		return new ResponseEntity<List<Book>>(byprice, HttpStatus.ACCEPTED);

	}

	@GetMapping("/sort")
	public ResponseEntity<?> findByPriceBtwnSort(@RequestParam(required = false) Double price) {
		List<Book> byprice = service.findByPriceBetweenSort(3000.0);
		return new ResponseEntity<List<Book>>(byprice, HttpStatus.ACCEPTED);

	}

	@GetMapping("/start")
	public ResponseEntity<?> findBy(@RequestParam(required = false) String name) {
		List<Book> byprice = service.findByNameLikeStart("^L");
		return new ResponseEntity<List<Book>>(byprice, HttpStatus.ACCEPTED);

	}

	@GetMapping("/onlyname")
	public ResponseEntity<?> findByOnlyName(@RequestParam(required = false) String name) {
		List<Book> byprice = service.getName("Harry Potter");
		return new ResponseEntity<List<Book>>(byprice, HttpStatus.ACCEPTED);

	}

	@GetMapping("/count")
	public ResponseEntity<?> findByOnlyName(@RequestParam(required = false) Double price) {
		List<Book> byprice = service.countPrice(3000.0);
		return new ResponseEntity<List<Book>>(byprice, HttpStatus.ACCEPTED);

	}

	@GetMapping("/bookId/{slNo}")
	public ResponseEntity<?> getByBookNo(@PathVariable String slNo) {
		List<Book> byId = service.getByBookId(slNo);
		return new ResponseEntity<List<Book>>(byId, HttpStatus.ACCEPTED);

	}
// Getting book details based on BOOK id

	@GetMapping("/slNo/{slNo}")
	public ResponseEntity<?> findByBookId(@PathVariable String slNo, Book book) {
		List<Book> byId = service.getDetails(book);
		return new ResponseEntity<List<Book>>(byId, HttpStatus.ACCEPTED);

	}

//getting details between range

	@GetMapping("/pricerange")
	public ResponseEntity<?> bookPrice(@RequestParam(required = false) Double price) {
		List<Book> byId = service.basedOnPrice(3000.0, 5000.0);
		return new ResponseEntity<List<Book>>(byId, HttpStatus.ACCEPTED);

	}

//sorting based on price

	@GetMapping("/sortByPrice")
	public List<Document> sortPrice(Double price) {

		return service.sortByPrice(price);

	}

//Using regular expression

	@GetMapping("/regex")
	public ResponseEntity<?> regexQuery(@RequestParam(required = false) String name) {
		List<Book> byId = service.regexQuery(name);
		return new ResponseEntity<List<Book>>(byId, HttpStatus.ACCEPTED);

	}

//getting based on name

	@GetMapping("/publishers")
	public ResponseEntity<?> publishersName(@RequestParam(required = false) String name) {
		List<Book> byId = service.getPublishersBasedOnName("Money Heist");
		return new ResponseEntity<List<Book>>(byId, HttpStatus.ACCEPTED);

	}

//fetching details by publisher entity

	@GetMapping("/publisher/{publisherName}")
	public ResponseEntity<?> publisherName(@PathVariable String publisherName) {
		List<Book> byId = service.getPublisher(publisherName);
		return new ResponseEntity<List<Book>>(byId, HttpStatus.ACCEPTED);

	}
	
//	
//	@GetMapping("/onlypublisher/{slNo}")
//	public ResponseEntity<?> onlyPublishers(@PathVariable String slNo) {
//		List<Publishers> byId = service.onlyPublishers(slNo);
//		return new ResponseEntity<List<Publishers>>(byId, HttpStatus.ACCEPTED);
//
//	}
	@GetMapping("/id/{slNo}")
	public ResponseEntity<?> getAllPublishers(@PathVariable String slNo){
		List<Publishers> bySlNo = service.getBySlNo(slNo);
		return new ResponseEntity<List<Publishers>>(bySlNo, HttpStatus.ACCEPTED);
	}
	
 
}
