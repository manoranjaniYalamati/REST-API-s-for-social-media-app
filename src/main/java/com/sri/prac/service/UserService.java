package com.sri.prac.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sri.prac.model.StatusRequest;
import com.sri.prac.model.User;
import com.sri.prac.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	public List<User> find(){
		return userRepository.findAll();
	}
	
	public  ResponseEntity<Object> create(){
		List<User> users = new ArrayList<>(); 
		users.add(new User("sri","yalmati"));
		users.add(new User("sai","kollati"));
		users.add(new User("peter","williams"));
		userRepository.saveAll(users);
		return new ResponseEntity<>("Users Created Scuccesfully", HttpStatus.CREATED);
	}
	
	
	public User find(String id){
		return userRepository.findById(id).orElseThrow();
	}
}
