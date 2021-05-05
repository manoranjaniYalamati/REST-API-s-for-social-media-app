package com.sri.prac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.prac.model.Comment;
import com.sri.prac.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	CommentRepository commentRepository;
	public Comment create(Comment comment) {
		return commentRepository.save(comment);
	}
}
