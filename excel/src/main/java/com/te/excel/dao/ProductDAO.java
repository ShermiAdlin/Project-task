package com.te.excel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.excel.entity.Product;
@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {

}
