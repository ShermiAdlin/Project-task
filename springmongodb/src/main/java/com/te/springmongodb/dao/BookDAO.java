 package com.te.springmongodb.dao;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.te.springmongodb.entity.Book;

@Repository
public interface BookDAO extends MongoRepository<Book, String> {

	@Query("{'name':?0}")
    List<Book> findByNameLike(String name);
	
	@Query("{'price':{ $gte: ?0 }}")
	List<Book> findByPrice(Double price);
	
	@Query("{'price':{$gt:?0,$lt:?1}}")
	List<Book> findByPriceBetween(Double minPrice,Double maxPrice);
	
	@Query( value="{'name':?0}", sort= "{'price':1}")
	List<Book> findByPriceBetweenSort(Double price);
	
	@Query("{ name : { $regex : ?0 } }")
	List<Book> findByNameLikeStart(String name);
	
	  @Query(value= "{'name': ?0}", fields="{'price':0,'slNo':0}")  
	List<Book> getName(String name);
	
	  @Query(value ="{'price': ?0}", count=true)
	  List<Book> countPrice(Double price);

	  @Query(value= "{slNo: ?0}", fields="{'price':0,'slNo':0,'name':0}")
	  List<Book> getByBookId(String slNo);
	  
	  //List<Book> getDetails(Book book);

}