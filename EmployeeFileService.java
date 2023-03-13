package com.yash.ems.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yash.ems.helper.ExcelHelper;
import com.yash.ems.model.Employee;
import com.yash.ems.model.EmployeeFile;
import com.yash.ems.repository.EmployeeFileRepository;




@Service
public class EmployeeFileService {
	
	@Autowired 
	EmployeeFileRepository employeeFileRepository;
	
	public void save(MultipartFile file)  {
		try {
			List<EmployeeFile> employees=  ExcelHelper.convertExcelToListOfEmployee(file.getInputStream());
			this.employeeFileRepository.saveAll(employees);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<EmployeeFile> getAllEmployee(){
		
		return this.employeeFileRepository.findAll();
		
	}
	
	
	  public ByteArrayInputStream load() { 
		  List<EmployeeFile> evaluation = employeeFileRepository.findAll();
	  
	  ByteArrayInputStream in = ExcelHelper.employeeToExcel(evaluation);
	  return in;
	  }
	 

}
