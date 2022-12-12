package com.te.pagingandsorting.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "product_generator")
	@SequenceGenerator(
			name = "product_generator",
			sequenceName = "product_sequence_name",
			allocationSize = 2)
	private Integer id;
	
	private String name;
	
	private Double price;
}
