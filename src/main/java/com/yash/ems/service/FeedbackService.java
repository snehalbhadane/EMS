package com.yash.ems.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.yash.ems.entity.Employee;
import com.yash.ems.entity.EmployeeFeedback;
import com.yash.ems.entity.Skill;
import com.yash.ems.entity.User;

public interface FeedbackService {
	
	public List<Skill> getSkills();
	
	public List<Employee> getEmployees();

	public List<EmployeeFeedback> getAllEmployeeFedback();
	
	public EmployeeFeedback saveEmployeeFeedback(EmployeeFeedback employeeFeedback);
	
	public List<String> uploadEmployeeFeedback(MultipartFile file, User createdBy)throws IOException;
	
	public XSSFWorkbook downloadEmployeeFeedbackTemplate();
	
	
	
	
}