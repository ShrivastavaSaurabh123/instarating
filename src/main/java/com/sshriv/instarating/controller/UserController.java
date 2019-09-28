package com.sshriv.instarating.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sshriv.instarating.domain.UserInfo;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@GetMapping("/admin")
	public String sayHelloAdmin(){
		return "Hello Admin";
	}
	
	@GetMapping("/user")
	public String sayHelloUser(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			UserDetails userDetails= ((UserDetails)principal);
			 String username = userDetails.getUsername();
		} else {
		  String username = principal.toString();
		}
		
		return "Hello User";
	}
	
	@GetMapping(value="/user/{id}")
	public ResponseEntity<UserInfo> getUser(@PathVariable("id") int id){
		UserInfo userInfo=new UserInfo();
		userInfo.setId(id);
		userInfo.setName("name");
		userInfo.setNumber(98765);
		return new ResponseEntity<UserInfo>(userInfo, HttpStatus.OK);
	}
	@GetMapping("/both")
	public String sayHelloToBoth(){
		return "Hello Admin and User";
	}

}
