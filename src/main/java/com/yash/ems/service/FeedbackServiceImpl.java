package com.yash.ems.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ems.config.LoggerConfiguration;
import com.yash.ems.controller.EmployeeFeedbackController;
import com.yash.ems.entity.EmployeeFeedback;
import com.yash.ems.entity.User;
import com.yash.ems.repository.EmployeeFeedbackRepository;
import com.yash.ems.repository.SkillRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	
	private Logger logger = LoggerConfiguration.getLogger(FeedbackServiceImpl.class);

	@Autowired
	private EmployeeFeedbackRepository employeeFeedbackRepository;
	
	
	
	@Override
	public EmployeeFeedback saveEmployeeFeedback(EmployeeFeedback employeeFeedback) {
		
        String methodName = "savEmployeeFeedback()";
		
		logger.info(methodName+ " called");
		
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