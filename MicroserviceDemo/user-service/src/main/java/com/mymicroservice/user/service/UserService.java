package com.mymicroservice.user.service;

import com.mymicroservice.user.ValueObject.Department;
import com.mymicroservice.user.ValueObject.ResponseTemplateVO;
import com.mymicroservice.user.entity.User;
import com.mymicroservice.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService 
{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) 
	{
		log.info("Inside saveUser of userrepository");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(long userId) 
	{
		log.info("Inside getUserWithDepartment of userrepository");
		ResponseTemplateVO responseTemplateVO=new ResponseTemplateVO();
		User user=userRepository.findByUserId(userId);

		// Department department=restTemplate.getForObject(
		// 	"http://localhost:9002/departments/"+user.getDepartmentId(),
		// 	 Department.class);

		Department department=restTemplate.getForObject(
			"http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),
			 Department.class);

		
		responseTemplateVO.setDepartment(department);
		responseTemplateVO.setUser(user);
		return responseTemplateVO;
		
	}

}
