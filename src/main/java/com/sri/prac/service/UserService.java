package com.sri.prac.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public StatusRequest getJson(String request) {
		StatusRequest status= new StatusRequest();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			status = objectMapper.readValue(request, StatusRequest.class);
		}catch(IOException err) {
			System.out.println(err);
		}
		return status;
	}
	
	public User find(String id){
		return userRepository.findById(id).orElseThrow();
	}
}
