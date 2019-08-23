package com.yk.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yk.web.users.Users;

@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api-user")
@RestController
public class UsersController {
	
	@PostMapping("/login")
	public Users login(@RequestBody Users user) {
		System.out.println(user.getUsername());
		System.out.println("login check");
		return user;
	}
	
	

}
