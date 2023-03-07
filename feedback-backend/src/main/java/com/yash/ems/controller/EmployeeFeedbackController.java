package com.yash.ems.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

//@Api(tags = "EmployeeFeedbackController", description = "For Testing")
@RestController
@RequestMapping("/feedback/api")
public class EmployeeFeedbackController {
	
	private Logger logger = LoggerConfiguration.getLogger(EmployeeFeedbackController.class);

	@Autowired
	private FeedbackService feedbackService;
	
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
	public ResponseEntity<String> uploadEmployeeFeedback(@RequestParam("file") MultipartFile file)throws SQLException, IOException {
		
		String methodName = "uploadEmployeeFeedback()";
		logger.info(methodName + " called");
		
		User createdBy = new User();
		createdBy.setId(1);
		
		return (ResponseEntity<String>) feedbackService.uploadEmployeeFeedback(file, createdBy);
	}
	
	@GetMapping(value = "/download-employee-feedback-template")
	public ResponseEntity<ByteArrayResource> downloadEmployeeFeedbackTemplate() throws Exception {
		
		String methodName = "downloadEmployeeFeedbackTemplate()";
		logger.info(methodName + " called");
		
		try {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			
			SXSSFWorkbook workbook = feedbackService.downloadEmployeeFeedbackTemplate();
			
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



