package com.yash.ems.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ems.entity.EmployeeFeedback;
import com.yash.ems.entity.User;
import com.yash.ems.repository.EmployeeFeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private EmployeeFeedbackRepository employeeFeedbackRepository;
	
	@Override
	public EmployeeFeedback saveEmployeeFeedback(EmployeeFeedback employeeFeedback) {
		
		if(employeeFeedback != null) {
			
			employeeFeedback.setCreatedOn(LocalDateTime.now());
			
			User createdBy = new User();
			createdBy.setId(1);
			employeeFeedback.setCreatedBy(createdBy);
	
			employeeFeedback = employeeFeedbackRepository.save(employeeFeedback);
		}
		
		return employeeFeedback;
	}
}