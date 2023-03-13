package com.yash.ems.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.yash.ems.model.EmployeeFile;



public class ExcelHelper {
	public static String fileType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	   
	public static String[] HEADERs = { "employeeId", "employeeName", "email", "designation", "grade", "resourceType",
				"DOJ", "totalExp", "IRM", "currentLocation", "currentAllocation", "project"
				 };
	
	public static boolean checkExcelFormat(MultipartFile file) {
		
	  

		String contentType=file.getContentType();
		if(contentType.equals(fileType))
		{
			return true;
		}else {
			return false;
		}
			
		
	}
	
	//Convert excel to listOfEmployee	
	 public static List<EmployeeFile> convertExcelToListOfEmployee(InputStream is){
		 
		 List<EmployeeFile> list=new ArrayList<>();
		
		 try (Workbook workbook = new XSSFWorkbook(is)) {
			 Sheet sheet = workbook.getSheet("EvaluationSheet");
			
			int rowNumber=0;
			Iterator<Row> iterator = sheet.iterator();
			while(iterator.hasNext()) {
				Row row = iterator.next();
				if(rowNumber==0) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cells = row.iterator();
				
				int cid=0;
				EmployeeFile employee=new EmployeeFile();
				 
				while(cells.hasNext()) {
					//single cell
					Cell cell = cells.next();
					
					switch(cid) {
					case 0:
						employee.setEmployeeId((int)cell.getNumericCellValue());
						 break;
					case 1: 
						 employee.setEmployeeName(cell.getStringCellValue());
						 break;
						 
					case 2:
						employee.setEmail(cell.getStringCellValue());
						break;
					case 3:
						employee.setDesignation(cell.getStringCellValue());
						break;
					case 4:
						employee.setGrade(cell.getStringCellValue());
						break;
					case 5:
						employee.setResourceType(cell.getStringCellValue());
						break;
					case 6:
						employee.setDate_Of_Joining(cell.getDateCellValue());
						break;
					case 7:
						employee.setTotalExp((double)cell.getNumericCellValue());
						break;
					case 8:
						employee.setIRM(cell.getStringCellValue());
						break;
					case 9:
						employee.setCurrentLocation(cell.getStringCellValue());
						break;
					case 10:
						employee.setCurrentAllocation(cell.getStringCellValue());
						break;
					case 11:
						employee.setProject(cell.getStringCellValue());
						break;
					
					default:
						break;
					
					}
					cid++; 
					
				}
				
				list.add(employee);
				
			}
			 
		 }catch (Exception e) {
			e.printStackTrace();
		}
		 return list;
	 }

	public static ByteArrayInputStream employeeToExcel(List<EmployeeFile> employee) {

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet("EvaluationSheet");

			// Header
			Row headerRow = sheet.createRow(0);
			   CreationHelper createHelper = workbook.getCreationHelper();  
			
			for (int col = 0; col <HEADERs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(HEADERs[col]);
			}

			int rowIdx = 1;
			for (EmployeeFile evaluation : employee) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(evaluation.getEmployeeId());
				row.createCell(1).setCellValue(evaluation.getEmployeeName());
				row.createCell(2).setCellValue(evaluation.getEmail());
				
				
				
				row.createCell(3).setCellValue(evaluation.getDesignation());
				row.createCell(4).setCellValue(evaluation.getGrade());
				row.createCell(5).setCellValue(evaluation.getResourceType());
				Cell cell=row.createCell(6);
				CellStyle cellStyle = workbook.createCellStyle();  
		        cellStyle.setDataFormat(  
		         createHelper.createDataFormat().getFormat("dd-mmm-yyyy"));  
		        cell.setCellValue(evaluation.getDate_Of_Joining());
				cell.setCellStyle(cellStyle);
				row.createCell(7).setCellValue(evaluation.getTotalExp());
				row.createCell(8).setCellValue(evaluation.getIRM());
				row.createCell(9).setCellValue(evaluation.getCurrentLocation());
				row.createCell(10).setCellValue(evaluation.getCurrentAllocation());
				row.createCell(11).setCellValue(evaluation.getProject());
				

			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}


}
