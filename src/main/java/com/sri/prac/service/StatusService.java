package com.sri.prac.service;

import org.springframework.data.domain.Pageable;
import java.util.List;

import javax.print.attribute.standard.PagesPerMinute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.sri.prac.model.Status;
import com.sri.prac.model.User;
import com.sri.prac.repository.StatusRepository;

@Service
public class StatusService {
	@Autowired
	StatusRepository statusRepository;

	
	public Status create(Status status) {
		return statusRepository.save(status);
	}
	
	
	public Page<Status> findByUserId(String userId){
		Pageable pageableRequest = (Pageable) PageRequest.of(1, 1);
		Page<Status> page = statusRepository.findByUserId(userId, pageableRequest);
//		List<User> users = PagesPerMinute.getContent();
		System.out.println(page.getContent());
//		System.out.println(statusRepository.findByUserId(userId));
		return page;
	}
	
	public Status find(String id){
		return statusRepository.findById(id).orElseThrow();
	}
}
