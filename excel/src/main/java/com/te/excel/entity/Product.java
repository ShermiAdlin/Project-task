 package com.te.excel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	private Integer productId;
	
	private String productName;
	
	private String prroductDesc;
	
	private Double productPrice;

}
