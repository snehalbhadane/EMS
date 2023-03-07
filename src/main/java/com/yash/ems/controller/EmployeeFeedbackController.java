package com.yash.ems.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yash.ems.config.LoggerConfiguration;
import com.yash.ems.entity.EmployeeFeedback;
import com.yash.ems.entity.User;
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
	
	
	@ApiOperation(value = "fetch all employee feedback.")
	@GetMapping("/allEmployeeFeedback")
    public List<EmployeeFeedback> getAllEmployeeFedback() {

		return feedbackService.getAllEmployeeFedback();
    }
	
	
	@ApiOperation(value = "upload employee feedback data")
	@PostMapping("/upload-employee-feedback")
	public ResponseEntity<String> uploadEmployeeFeedback(@RequestParam("file") MultipartFile file) {
		
		String methodName = "uploadEmployeeFeedback()";
		logger.info(methodName + " called");
		
		User createdBy = new User();
		createdBy.setId(1);
		
		List<String> errorList = feedbackService.uploadEmployeeFeedback(file, createdBy);
		
		System.out.println("List : "+errorList.size());
		
		errorList.forEach(System.out::print);
	
		return null;
	}
	
	
	
	
	

}