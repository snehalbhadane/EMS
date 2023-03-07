package com.yash.ems.service;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yash.ems.config.LoggerConfiguration;
import com.yash.ems.controller.EmployeeFeedbackController;
import com.yash.ems.entity.Employee;
import com.yash.ems.entity.EmployeeFeedback;
import com.yash.ems.entity.User;
import com.yash.ems.repository.EmployeeFeedbackRepository;
import com.yash.ems.repository.EmployeeRepository;
;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	
	private Logger logger = LoggerConfiguration.getLogger(FeedbackServiceImpl.class);

	@Autowired
	private EmployeeFeedbackRepository employeeFeedbackRepository;
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	@Override
	public EmployeeFeedback saveEmployeeFeedback(EmployeeFeedback employeeFeedback) {
		
        String methodName = "savEmployeeFeedback()";
		
		logger.info(methodName+ " called");
		
		if(employeeFeedback != null) {
		
			employeeFeedback.setCreatedOn(LocalDateTime.now());
			
			User createdBy = new User();
			createdBy.setId(1);
			employeeFeedback.setCreatedBy(createdBy);
	
			employeeFeedback = employeeFeedbackRepository.save(employeeFeedback);
		}
		
		return employeeFeedback;
	}



	@Override
	public List<EmployeeFeedback> getAllEmployeeFedback() {
		
		String methodName = "getAllEmployeeFedback()";
		logger.info(methodName + " called"); 
		
		return employeeFeedbackRepository.findAll();
	}
	
	@Override
	public List<String> uploadEmployeeFeedback(MultipartFile file, User createdBy) {
		
		String methodName = "uploadEmployeeFeedback()";
		logger.info(methodName + " called");
		
		List<String> errorList = new ArrayList<String>();
		
		List<EmployeeFeedback> employeeFeedbacks = new ArrayList<>();
		
		if(file != null) {

			try {
				
				XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
				
				int startRow = 2;
				XSSFRow inputRow = null;
				XSSFCell cell = null;
				
				if(workbook != null && workbook.getSheetAt(0) != null) {

					XSSFSheet sheet = workbook.getSheetAt(0);
					
					int totalRows = sheet.getPhysicalNumberOfRows();
					int noOfColumns = sheet.getRow(1).getPhysicalNumberOfCells();
					
					for(int i = startRow; i < totalRows; i++) {
					
						inputRow = sheet.getRow(i);
						
						if(inputRow == null) continue;
						
						EmployeeFeedback ef = new EmployeeFeedback();
						
						int cid = 1;
						String empCode = "", empName = "";
						
						for(int j = 1; j < noOfColumns; j++) {
							
							cell = inputRow.getCell(j);
			
							if(cid == 1) {
								if(cell != null) {
									
									empName = cell.getStringCellValue();
								}
								else {
									errorList.add("Cell - " + CellReference.convertNumToColString(j)+""+(inputRow.getRowNum()+1) + ":: is empty.");
								}
							}
							else if(cid == 2) {
								if(cell != null) {
									
									empCode = String.valueOf(String.format("%.0f", cell.getNumericCellValue()));

									if(empName != null && empName.length() > 0 && empCode != null && empCode.length() > 0) {
		
//										Employee employee = employeeRepository.getEmployeeByNameAndCode(empName, empCode);
										Employee employee = new Employee();
										employee.setId(1);
System.out.println(employee);						
										if(employee != null && employee.getId() > 0)
											ef.setEmployee(employee);
										else
											errorList.add("Insert correct employe name and employee code in cell - " + CellReference.convertNumToColString(j)+""+(inputRow.getRowNum()+1));
									}
								}
								else {
									errorList.add("Cell - " + CellReference.convertNumToColString(j)+""+(inputRow.getRowNum()+1) + ":: is empty.");
								}
							}
							else if(cid == 3) {
								if(cell != null) {
									ef.setOverallExperience((int)cell.getNumericCellValue());
								}
								else {
									errorList.add("Cell - " + CellReference.convertNumToColString(j)+""+(inputRow.getRowNum()+1) + ":: is empty.");
								}
							}
							else if(cid == 4) {
								if(cell != null) {
									ef.setProjctExperience((int)cell.getNumericCellValue());
								}
								else {
									errorList.add("Cell - " + CellReference.convertNumToColString(j)+""+(inputRow.getRowNum()+1) + ":: is empty.");
								}
							}
							
							
							
							cid++;
						}
						
						ef.setCreatedBy(createdBy);
						employeeFeedbacks.add(ef);
					}
					
					if(errorList.size() == 0) {

						employeeFeedbackRepository.saveAll(employeeFeedbacks);
					}
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return errorList;
	}
}
	

