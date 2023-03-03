package com.yash.ems.controller;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ems.config.LoggerConfiguration;
import com.yash.ems.entity.EmployeeFeedback;
import com.yash.ems.service.FeedbackService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/feedback/api")
public class EmployeeFeedbackController {
	
	private Logger logger = LoggerConfiguration.getLogger(EmployeeFeedbackController.class);

	@Autowired
	private FeedbackService feedbackService;
    
	@ApiOperation(value="insert employee feedback")
	@PostMapping("/saveEmployeeFeedback")
	public ResponseEntity<EmployeeFeedback> savEmployeeFeedback(@RequestBody EmployeeFeedback employeeFeedback) 
			throws SQLException, Exception {

		String methodName = "savEmployeeFeedback()";
		
		logger.info(methodName+ " called");
		
		EmployeeFeedback EmployeeFeedback = feedbackService.saveEmployeeFeedback(employeeFeedback);

		return ResponseEntity.status(HttpStatus.CREATED).body(EmployeeFeedback);
	}
	
	
	

}