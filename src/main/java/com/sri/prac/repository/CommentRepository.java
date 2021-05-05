package com.sri.prac.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sri.prac.model.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment,String>{

	Comment save(Comment comment);

}
