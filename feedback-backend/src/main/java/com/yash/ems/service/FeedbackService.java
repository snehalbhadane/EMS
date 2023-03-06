package com.yash.ems.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.yash.ems.entity.EmployeeFeedback;
import com.yash.ems.entity.User;

public interface FeedbackService {

	public List<EmployeeFeedback> getAllEmployeeFedback();
	
	public EmployeeFeedback saveEmployeeFeedback(EmployeeFeedback employeeFeedback);
	
	public List<String> uploadEmployeeFeedback(MultipartFile file, User createdBy);
}