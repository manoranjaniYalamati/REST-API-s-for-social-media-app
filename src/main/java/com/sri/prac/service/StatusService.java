package com.sri.prac.service;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sri.prac.model.Status;
import com.sri.prac.model.StatusRequest;
import com.sri.prac.repository.StatusRepository;

@Service
public class StatusService {
	@Autowired
	StatusRepository statusRepository;

	
	public ResponseEntity<Object>  create(String request,MultipartFile file) throws IOException {
		File convertFile = new File(System.getProperty("user.dir")+file.getOriginalFilename());																	
		convertFile.createNewFile();																															
		FileOutputStream fout = new FileOutputStream(convertFile);																								
		fout.write(file.getBytes());																													
		fout.close();
		String uri=System.getProperty("user.dir")+file.getOriginalFilename();
		StatusRequest statusRequest = getJson(request);
		Status status=new Status(statusRequest.getUserId(), statusRequest.getTitle(), statusRequest.getDescription(), uri);
		statusRepository.save(status);
		return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
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
	
	public Page<Status> findByUserId(String userId,int index,int offset){
		Pageable pageableRequest = (Pageable) PageRequest.of(index, offset);
		Page<Status> page = statusRepository.findByUserId(userId, pageableRequest);

		System.out.println(page.getContent());

		return page;
	}
	
	public Status find(String id){
		return statusRepository.findById(id).orElseThrow();
	}
}
