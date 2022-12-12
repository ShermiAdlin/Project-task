package com.te.springmongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.te.springmongodb.entity.Publishers;
@Repository
public interface PublishersDAO extends MongoRepository<Publishers, Integer>{

}
