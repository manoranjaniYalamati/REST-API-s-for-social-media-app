package com.sri.prac.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sri.prac.model.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
	public List<User>findAll();
}
