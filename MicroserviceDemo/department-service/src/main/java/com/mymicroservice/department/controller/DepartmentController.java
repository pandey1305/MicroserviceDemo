package com.mymicroservice.department.controller;

import com.mymicroservice.department.entity.Department;
import com.mymicroservice.department.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j						// slf4j is used to log infromation
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department)
	{
		log.info("Inside Department saveDepartment Controller");
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable("id") long departmentId)
	{
		log.info("Inside Department findDepartmentById Controller");
		return departmentService.findDepartmentById(departmentId);
	}
}
