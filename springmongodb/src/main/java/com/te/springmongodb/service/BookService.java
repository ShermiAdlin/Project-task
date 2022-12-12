package com.te.springmongodb.service;

import java.util.List;

import org.bson.Document;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;


import com.te.springmongodb.entity.Book;
import com.te.springmongodb.entity.Publishers;

public interface BookService {
          Book addBook(Book book);
          
          List<Book> getBook();
          
          Book getId(String id);
          
         Boolean delete(Book book, String id);
         
         Book updateBook(Book book);
         
         List<Book>	findByNameLike(String name);
         
         List<Book> findByPrice(Double price);
         
         List<Book> findByPriceBetween(Double minPrice,Double maxPrice);
         
         List<Book> findByPriceBetweenSort(Double price);
         
         List<Book> findByNameLikeStart(String name);
         
         List<Book> getName(String name);
         
         List<Book> countPrice(Double price);
         
         List<Book> getByBookId(String slNo);
         
         List<Book> getDetails(Book book);
         
         List<Book> basedOnPrice(Double minPrice, Double maxPrice);
         
         List<Document> sortByPrice(Double price);
         
         List<Book> regexQuery(String name);
         
       List<Book> getPublishersBasedOnName(String name);
       
       List<Book> getPublisher(String publisherName);

    // List<Book>	onlyPublishers(String slNo);
       
       //<Publishers> onlyPublishers(String slNo);
       
       List<Publishers> getBySlNo(String slNo);
       
      
     	
         

}
