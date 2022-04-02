package com.mymicroservice.user.controller;

import com.mymicroservice.user.ValueObject.ResponseTemplateVO;
import com.mymicroservice.user.entity.User;
import com.mymicroservice.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController 
{
	@Autowired
	private UserService userService;

	@PostMapping("/")
	public User saveUser(@RequestBody  User user)
	{
		log.info("Inside saveUser of usercontroller");
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") long userId)
	{
		log.info("Inside getUserWithDepartment of usercontroller");
		return userService.getUserWithDepartment(userId);
	}
}
