package com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.model.Search;


public interface SearchRepository extends MongoRepository<Search, Integer> {


	 
}
