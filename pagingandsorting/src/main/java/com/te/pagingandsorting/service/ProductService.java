package com.te.pagingandsorting.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.te.pagingandsorting.entity.Product;

public interface ProductService {

	//public void initDB();
	public Product add(Product product);
	public List<Product> getProduct();
	public List<Product> getProductAndSorting(String field);
	public Page<Product> getProductAndSortingAndPagination(Integer offSet, Integer pageSize);
}
