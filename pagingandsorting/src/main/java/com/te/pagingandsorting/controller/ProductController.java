package com.te.pagingandsorting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.pagingandsorting.entity.Product;
import com.te.pagingandsorting.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping("/get")
	public ResponseEntity<?> register(){
		
		List<Product> product2 = service.getProduct();
		return new ResponseEntity<List <Product>>(product2,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/get/{field}")
	public ResponseEntity<?> getBySorting(@PathVariable String field){
		
		List<Product> sorting = service.getProductAndSorting(field);
		return new ResponseEntity<List <Product>>(sorting,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/pagination/{offSet}/{pageSize}")
	public ResponseEntity<?> getBySortingAndPagination(@PathVariable Integer offSet,@PathVariable Integer pageSize){
		
		Page<Product> pagination = service.getProductAndSortingAndPagination(offSet, pageSize);
		return new ResponseEntity<Page<Product>>(pagination,HttpStatus.ACCEPTED);
		
	}
	@PostMapping("/save")
	public ResponseEntity<?> addRegister(@RequestBody Product product){
		Product add = service.add(product);
		return new ResponseEntity<Product>(add,HttpStatus.ACCEPTED);
		
	}
		

}
