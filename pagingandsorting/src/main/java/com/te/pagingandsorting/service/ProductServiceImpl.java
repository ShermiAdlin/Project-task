package com.te.pagingandsorting.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.te.pagingandsorting.entity.Product;
import com.te.pagingandsorting.repository.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO dao;

	@PostConstruct
	public void initDB() {
		List<Product> products = IntStream.rangeClosed(1, 200)
				.mapToObj(i -> new Product(new Random().nextInt(), "product" + i, new Random().nextDouble(5000.0)))
				.collect(Collectors.toList());
		 dao.saveAll(products);
	}

	@Override
	public List<Product> getProduct() {

		return (List<Product>) dao.findAll();
	}

	@Override
	public List<Product> getProductAndSorting(String field) {
		
		return (List<Product>) dao.findAll(Sort.by(Sort.Direction.DESC,field));
	}

	@Override
	public Page<Product> getProductAndSortingAndPagination(Integer offSet, Integer pageSize) {
	
		 Page<Product> findAll = dao.findAll(PageRequest.of(offSet, pageSize));
		 return findAll;
	}

	@Override
	public Product add(Product product) {
		// TODO Auto-generated method stub
		return dao.save(product);
	}

}
