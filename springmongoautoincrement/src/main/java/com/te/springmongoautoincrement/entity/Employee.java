package com.te.springmongoautoincrement.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "EMPLOYEE")
public class Employee {
	//name of the sequence number
	@Transient
	public static final String SEQUENCENAME = "userSequence";
	@Id
	private Integer id;
	
	private String name;
	
	private String destination;

}
