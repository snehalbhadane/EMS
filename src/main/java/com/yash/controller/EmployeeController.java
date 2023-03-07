package com.yash.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yash.model.Employee;
import com.yash.service.EmployeeService;



@CrossOrigin("*")
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	

	
	@PostMapping(value = "/addEmployeeData")
	public ResponseEntity<Employee> addEmployeeObject(@Valid @RequestBody Employee employee) {
		Employee saveEmployeeObject = employeeService.saveEmployeeObject(employee);
		return new ResponseEntity<>(saveEmployeeObject,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllEmployeeData")
	public ResponseEntity<List<Employee>> getAllEmployeeData(){
		List<Employee> allEmployeeObject = employeeService.getAllEmployeeObject();
		return new ResponseEntity<>(allEmployeeObject,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/getEmployeeData/{employeeId}")
	public ResponseEntity<Employee> getSingleEmployeeData(@PathVariable int employeeId) {
		 Employee singleEmployeeData = employeeService.getSingleEmployeeData(employeeId);
		 return ResponseEntity.ok(singleEmployeeData);
		}
	
	@PutMapping(value = "/updateEmployee/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int employeeId,@RequestBody Employee employee){
		Employee updateEmployeeObject = employeeService.updateEmployeeObject(employeeId, employee);
		return new ResponseEntity<>(updateEmployeeObject,HttpStatus.CREATED);
		}
	@DeleteMapping(value = "/deleteEmployee/{employeeId}")
	public ResponseEntity<Map<String,Integer>> deleteEmployee(@PathVariable int employeeId){
		Integer eid2 = employeeService.deleteEmployeeObject(employeeId);
		Map<String,Integer>map=new HashMap<>();
		map.put("deleted id is", eid2);
		return new ResponseEntity<>(map,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{currentAllocation}")
	public List<Employee> getEmployeeBycurrentAllocation(@PathVariable("currentAllocation") String currentAllocation){
        System.out.println("----------------------"+currentAllocation);
		List<Employee> BycurrentAllocation = this.employeeService.fetchBycurrentAllocation(currentAllocation);
		System.out.println("bycurrentAllocation :"+BycurrentAllocation);
		return BycurrentAllocation;
		
	}
	
	@GetMapping("/find-by-id-name/{employeeId}/{employeeName}")
	public ResponseEntity<Employee> findByEmployeeIdAndEmployeeName(
			@PathVariable(value = "employeeId") Integer employeeId,
			@PathVariable(value = "employeeName") String employeeName) {
		Employee employee = employeeService.fetchByEmployeeIdAndEmployeeName(employeeId, employeeName);
		return new ResponseEntity<>(employee, HttpStatus.OK);
		
	}	
	

}
