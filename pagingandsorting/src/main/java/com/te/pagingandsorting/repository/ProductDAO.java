package com.te.pagingandsorting.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.te.pagingandsorting.entity.Product;

@Repository
public interface ProductDAO extends PagingAndSortingRepository<Product, Integer>{

}
