package com.yash.ems.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.yash.ems.config.LoggerConfiguration;
import com.yash.ems.entity.Employee;
import com.yash.ems.entity.EmployeeFeedback;
import com.yash.ems.entity.Skill;
import com.yash.ems.entity.User;
import com.yash.ems.service.FeedbackService;

import io.swagger.annotations.ApiOperation;

//@Api(tags = "EmployeeFeedbackController", description = "For Testing")
@RestController
@RequestMapping("/feedback/api")
public class EmployeeFeedbackController {
	
	private Logger logger = LoggerConfiguration.getLogger(EmployeeFeedbackController.class);

	@Autowired
	private FeedbackService feedbackService;
	
	@ApiOperation(value = "fetch all employee.")
	@GetMapping("/allEmployee")
	public List<Employee> getAllEmployee() {
			
			String methodName = "getAllEmployee()";
			logger.info(methodName + " called"); 

			return feedbackService.getEmployees();
	    }
		
		@ApiOperation(value = "fetch all skill.")
		@GetMapping("/allSkill")
	    public List<Skill> getAllSkill() {
			
			String methodName = "getAllSkill()";
			logger.info(methodName + " called"); 

			return feedbackService.getSkills();
	    }
	
	@ApiOperation(value = "fetch all employee feedback.")
	@GetMapping("/allEmployeeFeedback")
    public List<EmployeeFeedback> getAllEmployeeFedback() {

		return feedbackService.getAllEmployeeFedback();
    }
	
	@ApiOperation(value = "Insert employee feedback.")
	@PostMapping("/saveEmployeeFeedback")
	public ResponseEntity<EmployeeFeedback> savEmployeeFeedback(@RequestBody EmployeeFeedback employeeFeedback) 
			throws SQLException, Exception {
		
		String methodName = "savEmployeeFeedback()";
		logger.info(methodName + " called");  
		
		EmployeeFeedback EmployeeFeedback = feedbackService.saveEmployeeFeedback(employeeFeedback);

		return ResponseEntity.status(HttpStatus.CREATED).body(EmployeeFeedback);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "upload employee feedback data")
	@PostMapping("/upload-employee-feedback")
/*	public ResponseEntity<String> uploadEmployeeFeedback(@RequestParam("file") MultipartFile file)throws SQLException, IOException {
		
		String methodName = "uploadEmployeeFeedback()";
		logger.info(methodName + " called");
		
		User createdBy = new User();
		createdBy.setId(1);
		
		return (ResponseEntity<String>) feedbackService.uploadEmployeeFeedback(file, createdBy);
	} */
	
	public List<String> uploadEmployeeFeedback(@RequestParam("file") MultipartFile file)
			throws JsonParseException, JsonMappingException, IOException,
			SQLException  {

		String methodName = "uploadEmployeeFeedback()";
		logger.info(methodName + " called");
		
		User createdBy = new User();
		createdBy.setId(1);
		
		return feedbackService.uploadEmployeeFeedback(file, createdBy);
    }
	
	@GetMapping(value = "/download-employee-feedback-template")
	public ResponseEntity<ByteArrayResource> downloadEmployeeFeedbackTemplate() throws Exception {
		
		String methodName = "downloadEmployeeFeedbackTemplate()";
		logger.info(methodName + " called");
		
		try {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			
			XSSFWorkbook workbook = feedbackService.downloadEmployeeFeedbackTemplate();
			
			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("application", "force-download"));
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename = employeeFeedbackTemplate.xlsx");
			workbook.write(stream);
			stream.close();
			
			return new ResponseEntity<>(new ByteArrayResource(stream.toByteArray()),
					header, HttpStatus.CREATED);
			
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}