package com.te.excel.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.te.excel.entity.Product;
import com.te.excel.helpers.Helpers;
import com.te.excel.service.ProductService;

@RestController
@CrossOrigin("*")

public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file){
		if(Helpers.checkExcelFormat(file)) {
			service.save(file);
			return ResponseEntity.ok(Map.of("message","file is uploaded and data is saved"));
		}
		return new ResponseEntity<String>("PLEASE UPLOAD EXCEL FILE", HttpStatus.BAD_REQUEST);
		
	}
	@GetMapping("/product")
	public List<Product> get(){
		return service.getAllProducts();
		
	}

}
