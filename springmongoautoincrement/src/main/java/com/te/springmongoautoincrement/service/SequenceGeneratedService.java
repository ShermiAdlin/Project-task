package com.te.springmongoautoincrement.service;



import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.te.springmongoautoincrement.entity.DbSequence;

@Service
public class SequenceGeneratedService {
	@Autowired
	MongoOperations operations;
	
	public Integer getSequenceNumber(String seqName) {
		
		//getting seuence id:6369f9868ea04213676560f2(eg)
		Query query=new Query(Criteria.where("seqId").is(seqName));
		
		//update the seguence6369f9868ea04213676560f2 to 1
		Update update= new Update().inc("seqNo", 1);
		
		//updating in table(document)
		DbSequence counter=operations.findAndModify(query, update, options().returnNew(true).upsert(true),DbSequence.class);
		return !Objects.isNull(counter)?counter.getSeqNo():1;
		
	}

	

	

}
