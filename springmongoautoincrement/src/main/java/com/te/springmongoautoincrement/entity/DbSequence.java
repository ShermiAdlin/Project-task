package com.te.springmongoautoincrement.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Db_Sequence")
public class DbSequence {
	@Id
	private String seqId;
	
	private Integer seqNo;  

}
