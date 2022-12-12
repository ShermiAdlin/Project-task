package com.te.excel.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.te.excel.entity.Product;

public interface ProductService {
public void save(MultipartFile file);

public List<Product> getAllProducts();
}
