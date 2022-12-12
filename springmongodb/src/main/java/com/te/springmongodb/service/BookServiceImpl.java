package com.te.springmongodb.service;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Field;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.te.springmongodb.dao.BookDAO;
import com.te.springmongodb.entity.Book;
import com.te.springmongodb.entity.Publishers;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookDAO dao;
	
	@Autowired
	MongoTemplate mongoTemplate;



	private Query query2;

	@Override
	public Book addBook(Book book) {
	
		return dao.insert(book);
	}

	@Override
	public List<Book> getBook() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}



	@Override
	public Book getId(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}


	@Override
	public Boolean delete(Book book, String id) {
		// TODO Auto-generated method stub
	dao.delete(book);
		return true;
	}



	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		return dao.save(book);
	}



	@Override
	public List<Book> findByNameLike(String name) {
		// TODO Auto-generated method stub
		return dao.findByNameLike(name);
	}



	@Override
	public List<Book> findByPrice(Double price) {
		// TODO Auto-generated method stub
		return dao.findByPrice(price);
	}



	@Override
	public List<Book> findByPriceBetween(Double minPrice, Double maxPrice) {
		// TODO Auto-generated method stub
		return dao.findByPriceBetween(minPrice, maxPrice);
	}



	@Override
	public List<Book> findByPriceBetweenSort(Double price) {
		// TODO Auto-generated method stub
		return dao.findByPriceBetweenSort(price);
	}



	@Override
	public List<Book> findByNameLikeStart(String name) {
		// TODO Auto-generated method stub
		return dao.findByNameLikeStart(name);
	}



	@Override
	public List<Book> getName(String name) {
		// TODO Auto-generated method stub
		return dao.getName(name);
	}



	@Override
	public List<Book> countPrice(Double price) {
		// TODO Auto-generated method stub
		return dao.countPrice(price);
	}



	@Override
	public List<Book> getByBookId(String slNo) {
	
		return dao.getByBookId(slNo);
	}
//Based on book id
	@Override
	public List<Book> getDetails(Book book) {
        
		Query query= new Query();
		
		Criteria criteria=new Criteria();
		
	 query2= query.addCriteria(criteria.where("slNo").exists(true));
         
		return mongoTemplate.find(query2,Book.class);
	}

	
	//Range between price
	@Override
	public List<Book> basedOnPrice(Double minPrice, Double maxPrice) {
		
		Query query = new Query()
          .addCriteria(Criteria.where("price").gte(minPrice).lte(maxPrice));
		return mongoTemplate.find(query, Book.class);
	}

	
	//Sorting based on price
	@Override
	public List<Document> sortByPrice(Double price) {
		SortOperation sortOperation=Aggregation.sort(Sort.Direction.ASC,"price");
		Aggregation aggregation=Aggregation.newAggregation(sortOperation);
		List<Document> books= mongoTemplate.aggregate(aggregation, Book.class,Document.class).getMappedResults();
		return books;
	}

	
	//Based on regex expression
	@Override
	public List<Book> regexQuery(String name) {
	     Query query=new Query().addCriteria(Criteria.where("name").regex("^P"));
		return mongoTemplate.find(query,Book.class);
	}

	//getting based on name
	@Override
	public List<Book> getPublishersBasedOnName(String name) {
		Query query= new Query().addCriteria(Criteria.where("name"));
		return mongoTemplate.find(query, Book.class);
	}

	
	//fetching details by publisher entity
	@Override
	public List<Book> getPublisher(String publisherName) {
		Query query= new Query().addCriteria(Criteria.where("publishers.publisherName").is(publisherName));
		return mongoTemplate.find(query, Book.class);
	}

	@Override
	public List<Publishers> getBySlNo(String slNo) {
		// TODO Auto-generated method stub
		return dao.findById(slNo).get().getPublishers();
	}
	
	

//	@Override
//	public List<Publishers> onlyPublishers(String slNo) {
//		//Query query = new Query().addCriteria(Criteria.where("slNo").is(slNo));
//				//return mongoTemplate.find(query, Publishers.class);
//		
//		//UnwindOperation operation= Aggregation.unwind("publishers");
		
			

	//}

	
	
	 

}
