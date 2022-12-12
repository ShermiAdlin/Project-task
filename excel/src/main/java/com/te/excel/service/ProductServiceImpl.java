package com.te.excel.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.te.excel.dao.ProductDAO;
import com.te.excel.entity.Product;
import com.te.excel.helpers.Helpers;
@Service
public class ProductServiceImpl implements ProductService {
   @Autowired
	private ProductDAO dao;

@Override
public void save(MultipartFile file) {
	// TODO Auto-generated method stub
	try {
		List<Product> products = Helpers.convertExcelToList(file.getInputStream());
	dao.saveAll(products);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

@Override
public List<Product> getAllProducts() {
	// TODO Auto-generated method stub
	return dao.findAll();
}
}
