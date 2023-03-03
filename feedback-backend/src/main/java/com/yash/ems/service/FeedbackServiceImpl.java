package com.yash.ems.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ems.config.LoggerConfiguration;
import com.yash.ems.entity.EmployeeFeedback;
import com.yash.ems.entity.User;
import com.yash.ems.repository.EmployeeFeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	Logger logger = LoggerConfiguration.getLogger(FeedbackServiceImpl.class);
	
	@Autowired
	private EmployeeFeedbackRepository employeeFeedbackRepository;

	@Override
	public List<EmployeeFeedback> getAllEmployeeFedback() {
		
		String methodName = "getAllEmployeeFedback()";
		logger.info(methodName + " called"); 
		
		return employeeFeedbackRepository.findAll();
	}
	
	@Override
	public EmployeeFeedback saveEmployeeFeedback(EmployeeFeedback employeeFeedback) {
		
		String methodName = "savEmployeeFeedback()";
		logger.info(methodName + " called"); 
		
		if(employeeFeedback != null) {
			
			employeeFeedback.setCreatedOn(LocalDateTime.now());
			
			User createdBy = new User();
			createdBy.setId(1);
		//	employeeFeedback.setCreatedBy(createdBy);
	
			employeeFeedback = employeeFeedbackRepository.save(employeeFeedback);
		}
		
		return employeeFeedback;
	}
}