package com.yash.service;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.yash.exception.ResourceNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.model.Employee;
import com.yash.repository.EmployeeRepository;





@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	// Generate excel files
	
	public void generateExcel(HttpServletResponse response)  throws Exception{
		List<Employee> employee = employeeRepository.findAll();
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("EmployeeInfo");
		
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("emp_id");
		row.createCell(1).setCellValue("doj");
		row.createCell(2).setCellValue("irm");
		row.createCell(3).setCellValue("current_allocation");
		row.createCell(4).setCellValue("current_location");
		row.createCell(5).setCellValue("designation");
		row.createCell(6).setCellValue("email");
		row.createCell(7).setCellValue("employee_name");
		row.createCell(8).setCellValue("grade");
		row.createCell(9).setCellValue("project");
		row.createCell(10).setCellValue("resource_type");
		row.createCell(11).setCellValue("total_exp");
		
		int dataROWIndex=1;
		for(Employee employee1:employee ) {
		HSSFRow dataRow = sheet.createRow(dataROWIndex);
		dataRow.createCell(0).setCellValue(employee1.getEmployeeId());
		dataRow.createCell(1).setCellValue(employee1.getDOJ());
		dataRow.createCell(2).setCellValue(employee1.getIRM());
		dataRow.createCell(3).setCellValue(employee1.getCurrentAllocation());
		dataRow.createCell(4).setCellValue(employee1.getCurrentLocation());
		dataRow.createCell(5).setCellValue(employee1.getDesignation());
		dataRow.createCell(6).setCellValue(employee1.getEmail());
		dataRow.createCell(7).setCellValue(employee1.getEmployeeName());
		dataRow.createCell(8).setCellValue(employee1.getGrade());
		dataRow.createCell(9).setCellValue(employee1.getProject());
		dataRow.createCell(10).setCellValue(employee1.getResourceType());
		dataRow.createCell(11).setCellValue(employee1.getTotalExp());
		dataROWIndex ++;
		}
			ServletOutputStream ops=response.getOutputStream();
			workbook.write(ops);
			workbook.close();
			ops.close();
		}
	// End Generate the file
	String message="Employee is not exist with this id ";

	public Employee saveEmployeeObject(Employee employee) {
		return employeeRepository.save(employee);

	}

	public List<Employee> getAllEmployeeObject() {    
		return employeeRepository.findAll();

	}

	public Employee getSingleEmployee(int employeeId) {
		return employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException(message + employeeId));
	}
	

	public Employee updateEmployeeObject(int employeeId, Employee employeeDetails) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException(message + employeeId));
		employee.setEmployeeName(employeeDetails.getEmployeeName());
		employee.setEmail(employeeDetails.getEmail());
		employee.setDesignation(employeeDetails.getDesignation());
		employee.setGrade(employeeDetails.getGrade());
		employee.setResourceType(employeeDetails.getResourceType());
		employee.setDOJ(employeeDetails.getDOJ());
		employee.setTotalExp(employeeDetails.getTotalExp());
		employee.setIRM(employeeDetails.getIRM());
		employee.setCurrentLocation(employeeDetails.getCurrentLocation());
		employee.setCurrentAllocation(employeeDetails.getCurrentAllocation());
		employee.setProject(employeeDetails.getProject());
	    employee.setSkill(employeeDetails.getSkill());
		employeeRepository.save(employee);
		return employee;
	}

	public Integer deleteEmployeeObject(int employeeId) {

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException(message + employeeId));
		int eid2 = employee.getEmployeeId();
		employeeRepository.delete(employee);
		return eid2;
	}

	public List<Employee> fetchBycurrentAllocation(String currentAllocation) {
        
		List<Employee> currentAllocationContaining = employeeRepository.findBycurrentAllocationContaining(currentAllocation);
     return currentAllocationContaining;
    }
	
	
      public Employee fetchByEmployeeIdAndEmployeeName(Integer employeeId, String employeeName) {
		
		return employeeRepository.findByEmployeeIdAndEmployeeName(employeeId, employeeName);
	}
	

}
