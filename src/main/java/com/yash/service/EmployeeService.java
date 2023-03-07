package com.yash.service;

import java.util.List;
import com.yash.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.model.Employee;
import com.yash.repository.EmployeeRepository;





@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	String message="Employee is not exist with this id ";

	public Employee saveEmployeeObject(Employee employee) {
		return employeeRepository.save(employee);

	}

	public List<Employee> getAllEmployeeObject() {    
		return employeeRepository.findAll();

	}

	public Employee getSingleEmployeeData(int employeeId) {
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
