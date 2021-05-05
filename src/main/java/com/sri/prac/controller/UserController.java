package com.sri.prac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sri.prac.model.User;
import com.sri.prac.repository.UserRepository;
import com.sri.prac.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	@RequestMapping("/users")
	public List<User> getUsers(){
			//System.out.println("executed");
			//System.out.println(repo.findAll());
			//User ab=new User("sri","yalmati");
	//		repo.save(ab);
	//		User a=new User("sai","kollati");
	//		repo.save(a);
	//		User c=new User("peter","williams");
	//		repo.save(c);
	//		User d=new User("stella","johnson");
	//		repo.save(d);
	//		User e=new User("saleem","mohammad");
	//		repo.save(e);
	//		User f=new User("rukhsana","shaik");
	//		repo.save(f);
	//		User g=new User("john","peterson");
	//		repo.save(g);
			//System.out.println(repo.findAll());
			
			//System.out.println(repo.findById("sai"));
			return userService.find();
			
		
	}
}
