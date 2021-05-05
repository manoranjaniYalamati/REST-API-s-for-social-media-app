package com.sri.prac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sri.prac.model.Comment;
import com.sri.prac.service.CommentService;


@RestController
@RequestMapping(value="/comment")
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public Comment comment(@RequestBody Comment comment){				
		return commentService.create(comment);							
	}
}
