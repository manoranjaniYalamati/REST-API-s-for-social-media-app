package com.sri.prac.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sri.prac.model.User;

import com.sri.prac.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public List<User> getUsers(){
			return userService.find();
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<Object>  create(){
			return userService.create();
	}
		
}
