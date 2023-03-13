package com.yash.ems.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yash.ems.helper.ExcelHelper;
import com.yash.ems.model.EmployeeFile;
import com.yash.ems.service.EmployeeFileService;



@RestController
@CrossOrigin("*")
public class EmployeeFileController {
	
	@Autowired
	private EmployeeFileService employeeFileService;
	
	@PostMapping("/employee/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file ){
		if(ExcelHelper.checkExcelFormat(file)) {
		
			this.employeeFileService.save(file);
			return ResponseEntity.ok(Map.of("message","File is uploaded data is save in databse"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file");
		
	}
	
	@GetMapping("/employees")
	public List<EmployeeFile> getAllEmployees(){
		return this.employeeFileService.getAllEmployee();
		
	}
	
	@GetMapping("/downloadExcel")
	public ResponseEntity<Resource> getFile() {
		String filename = "EvaluationSheet.xlsx";
		InputStreamResource file = new InputStreamResource(employeeFileService.load());

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
	}


}
