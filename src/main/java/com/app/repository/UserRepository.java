package com.app.repository;

import com.app.model.User;


public interface UserRepository extends org.springframework.data.mongodb.repository.MongoRepository<User, String> {

	  boolean existsByUsername(String username);

	  User findByUsername(String username);

	  @org.springframework.transaction.annotation.Transactional
	  void deleteByUsername(String username);
}




