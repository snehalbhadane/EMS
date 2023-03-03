package com.yash.ems.service;

import java.util.List;

import com.yash.ems.entity.EmployeeFeedback;

public interface FeedbackService {

	public List<EmployeeFeedback> getAllEmployeeFedback();
	
	public EmployeeFeedback saveEmployeeFeedback(EmployeeFeedback employeeFeedback);
}