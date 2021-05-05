package com.sri.prac.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sri.prac.model.Status;
import com.sri.prac.model.StatusRequest;
import com.sri.prac.service.StatusService;
import com.sri.prac.service.UserService;

@RestController
public class StatusController {
	@Autowired
	StatusService statusService;
	@Autowired
	UserService userService;
	@RequestMapping(value="status/{userId}", method=RequestMethod.GET)
	public Page<Status> getStatusByUserId(@PathVariable("userId") String userId){
		return statusService.findByUserId(userId);
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> uploadFile(@RequestPart("statusRequest") String  request,@RequestPart("file") MultipartFile file) throws IOException {
		File convertFile = new File(System.getProperty("user.dir")+file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		System.out.println(request);
		fout.write(file.getBytes());
		fout.close();
		String uri=System.getProperty("user.dir")+file.getOriginalFilename();
		StatusRequest statusRequest = userService.getJson(request);
		Status obj=new Status(statusRequest.getUserId(), statusRequest.getTitle(), statusRequest.getDescription(), uri);
//		repos.save(obj);
		statusService.create(obj);
		return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
	}
}
