package com.yash.ems.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yash.ems.config.LoggerConfiguration;
import com.yash.ems.entity.Employee;
import com.yash.ems.entity.EmployeeFeedback;
import com.yash.ems.entity.EmployeeFeedbackFile;
import com.yash.ems.entity.EmployeeSkillsRating;
import com.yash.ems.entity.Skill;
import com.yash.ems.entity.User;
import com.yash.ems.repository.EmployeeFeedbackFileRepository;
import com.yash.ems.repository.EmployeeFeedbackRepository;
import com.yash.ems.repository.EmployeeRepository;
import com.yash.ems.repository.SkillRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	Logger logger = LoggerConfiguration.getLogger(FeedbackServiceImpl.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private EmployeeFeedbackRepository employeeFeedbackRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private SkillRepository skillRepository; 
	
	@Autowired
	private EmployeeFeedbackFileRepository employeeFeedbackFileRepository; 
	
	@Override
	public List<Skill> getSkills() {
		
		String methodName = "getSkills()";
		logger.info(methodName + " called"); 
		
		return skillRepository.findAll();
	}
	
	@Override
	public List<Employee> getEmployees() {
		
		String methodName = "getEmployees()";
		logger.info(methodName + " called"); 
		
		return employeeRepository.findAll();
	}

	@Override
	public List<EmployeeFeedback> getAllEmployeeFedback() {
		
		String methodName = "getAllEmployeeFedback()";
		logger.info(methodName + " called"); 
		
		return employeeFeedbackRepository.findAll();
	}
	
	@Override
	public EmployeeFeedback saveEmployeeFeedback(EmployeeFeedback employeeFeedback) {
		
		String methodName = "savEmployeeFeedback()";
		logger.info(methodName + " called"); 
		
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
	public List<String> uploadEmployeeFeedback(MultipartFile file, User createdBy)throws IOException {
		
		String methodName = "uploadEmployeeFeedback()";
		logger.info(methodName + " called");
		
		List<String> errorList = new ArrayList<String>();
		
		List<EmployeeFeedback> employeeFeedbacks = new ArrayList<>();
		
		if(file != null) {

			try {
				
				List<Skill> skills = skillRepository.findAll();
				
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
	
										Employee employee = employeeRepository.getEmployeeByNameAndCode(empName, empCode);
						
										if(employee != null && employee.getId() > 0)
											ef.setEmployee(employee);
										else {
											errorList.add("Insert correct employe name in cell - " + CellReference.convertNumToColString(j-1)+""+(inputRow.getRowNum()+1));
											errorList.add("Insert correct employee code in cell - " + CellReference.convertNumToColString(j)+""+(inputRow.getRowNum()+1));
										}	
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

							if(cid > 4 && cid <= 4+skills.size()) {
								if(skills != null && skills.size() > 0) {
									
									List<EmployeeSkillsRating> esrl = new ArrayList<EmployeeSkillsRating>();
									
									EmployeeSkillsRating esr = null;
									
									for(int s = 0; s < skills.size(); s++) {
										
										for(int k=0; k<2; k++) {
											
											if(k == 0) {
												esr = new EmployeeSkillsRating();
												esr.setSkill(skills.get(s));
												
												if(cell != null) {
													esr.setRating((int)cell.getNumericCellValue());
												}
												else {
													errorList.add("Cell - " + CellReference.convertNumToColString(j)+""+(inputRow.getRowNum()+1) + ":: is empty.");
												}
											}
											else {
												if(cell != null) {
													esr.setRemarks(cell.getStringCellValue());
												}
												else {
													errorList.add("Cell - " + CellReference.convertNumToColString(j)+""+(inputRow.getRowNum()+1) + ":: is empty.");
												}
												
												esrl.add(esr);
											}
											
											cid++;
											j++;
											cell = inputRow.getCell(j);
										}
										
									}
									ef.setEmployeeSkillsRatings(esrl);
								}
								cid--;j--;
							}
							
							else if(cid == noOfColumns - 2) {
								if(cell != null) {
									ef.setComments(cell.getStringCellValue());
								}
								else {
									errorList.add("Cell - " + CellReference.convertNumToColString(j)+""+(inputRow.getRowNum()+1) + ":: is empty.");
								}
							}
							else if(cid == noOfColumns - 1 && cell != null) {
								ef.setSuggestion(cell.getStringCellValue());
							}
							
							cid++;
						}
						
						ef.setCreatedOn(LocalDateTime.now());
						ef.setCreatedBy(createdBy);
						employeeFeedbacks.add(ef);
					}
					
					if(errorList.size() == 0) {
						
						String fileName = file.getOriginalFilename();
						
						EmployeeFeedbackFile  employeeFeedbackFile = this.employeeFeedbackFile(fileName, createdBy);
						
						if(employeeFeedbackFile != null && employeeFeedbackFile.getId() > 0) {
						
							String fileUploadPath = env.getProperty("EMPLOYEE_FEEDBACK_FILE_UPLOAD_PATH");
							String filePath = fileUploadPath + File.separator + employeeFeedbackFile.getId() + "." +
									fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());

							try {
								File f = new File(filePath);
								f.createNewFile();
							}
							catch (IOException e) {
								e.printStackTrace();
							}
							
							employeeFeedbacks.forEach(e -> e.setEmployeeFeedbackFile(employeeFeedbackFile));
						}
						
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
	
	private EmployeeFeedbackFile  employeeFeedbackFile(String fileName, User uploadedBy) {
		
		EmployeeFeedbackFile  employeeFeedbackFile = new EmployeeFeedbackFile();
		
		employeeFeedbackFile.setFileName(fileName);
		employeeFeedbackFile.setUploadedBy(uploadedBy);
		employeeFeedbackFile.setUploadedOn(LocalDateTime.now());
		
		employeeFeedbackFileRepository.save(employeeFeedbackFile);
		
		return employeeFeedbackFile;
	}
	
	@Override
	public XSSFWorkbook downloadEmployeeFeedbackTemplate() {
		
		String methodName = "downloadEmployeeFeedbackTemplate()";
		logger.info(methodName + " called");
		
		int cellCount = 0;
		
		List<Skill> skills = skillRepository.findAll();

		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Employee-feedback");
		
		Row topRow = sheet.createRow(0);
		
		Row headerRow = sheet.createRow(1);
		
		XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		Font font = workbook.createFont();
		font.setColor(IndexedColors.BLACK.getIndex());
		style.setFont(font);
		
		CellStyle style1 = workbook.createCellStyle();
		style1.setFillForegroundColor(IndexedColors.RED.getIndex());
		style1.setAlignment(HorizontalAlignment.CENTER);
		
		Font font1 = workbook.createFont();
		font1.setColor(IndexedColors.RED.getIndex());
		font1.setBold(true);
		style1.setFont(font1);
		
		topRow.createCell(0).setCellValue("Note: Please give rating between 1 to 5.");
		topRow.getCell(0).setCellStyle(style1);
		sheet.addMergedRegion(CellRangeAddress.valueOf("A1:D1"));

		headerRow.createCell(cellCount).setCellValue("Sno");
		headerRow.getCell(cellCount++).setCellStyle(style);
		
		headerRow.createCell(cellCount).setCellValue("Emp Name");
		headerRow.getCell(cellCount++).setCellStyle(style);

		headerRow.createCell(cellCount).setCellValue("Emp Code");
		headerRow.getCell(cellCount++).setCellStyle(style);

		headerRow.createCell(cellCount).setCellValue("Overall Experience (In Years)");
		headerRow.getCell(cellCount++).setCellStyle(style);

		headerRow.createCell(cellCount).setCellValue("Project Experience (In Years)");
		headerRow.getCell(cellCount++).setCellStyle(style);
		
		if(skills != null && skills.size() > 0) {
			
			for(int i = 0; i < skills.size(); i++) {

				topRow.createCell(cellCount).setCellValue(skills.get(i).getName());
				topRow.getCell(cellCount).setCellStyle(style1);
	
				sheet.addMergedRegion(CellRangeAddress.valueOf(CellReference.convertNumToColString(cellCount)+""+1 +":"+ CellReference.convertNumToColString(cellCount+1)+""+1));
				
				headerRow.createCell(cellCount).setCellValue("Rating");
				headerRow.getCell(cellCount++).setCellStyle(style);
				
				headerRow.createCell(cellCount).setCellValue("Comment");
				headerRow.getCell(cellCount++).setCellStyle(style);
			}
		}
		
		headerRow.createCell(cellCount).setCellValue("Overall Comments");
		headerRow.getCell(cellCount++).setCellStyle(style);

		headerRow.createCell(cellCount).setCellValue("Suggestion");
		headerRow.getCell(cellCount++).setCellStyle(style);
	
		autoSizeColumns(sheet, cellCount);
		
		return workbook;
	}
	
	private void autoSizeColumns(XSSFSheet workSheet, int columnCount) {
		
		if(workSheet != null && columnCount > 0) {
			for(int i=0; i<columnCount; i++) {
				workSheet.autoSizeColumn(i);
			}
		}
	}
}