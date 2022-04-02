package com.mymicroservice.department.service;

import com.mymicroservice.department.entity.Department;
import com.mymicroservice.department.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService 
{
	@Autowired
	DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) 
	{
		return departmentRepository.save(department);
	}

	public Department findDepartmentById(long departmentId) 
	{
		return departmentRepository.findByDepartmentId(departmentId);
	}
	
}
