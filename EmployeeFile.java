package com.yash.ems.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="employee_file_data")
public class EmployeeFile {
	
	@Id
	@Column(name = "emp_id")
	private int employeeId;
	@NotEmpty(message = " employee name should not be empty")
	private String employeeName;
	@NotEmpty(message = "employee email should not be blank")
	private String email;
	@NotEmpty(message = "employee designation should not be empty")
	private String designation;
	@NotEmpty(message = "employee grade  should not be empty")
	private String grade;
	@NotEmpty(message = "resource type should not be empty")
	private String resourceType;
	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date date_Of_Joining;
	@NotNull(message = "employee total experience should not be empty")
	private Double totalExp;
	@NotEmpty(message = "employee reporting manager field should not be empty")
	private String IRM;
	@NotEmpty(message = "employee current location should not be blank")
	private String currentLocation;
	@NotEmpty(message = "employee current allocation should not be blank")
	private String currentAllocation;
	@NotEmpty(message = "employee project allocation should not be blank")
	private String project;
	public EmployeeFile() {
		super();
	}
	public EmployeeFile(int employeeId, @NotEmpty(message = " employee name should not be empty") String employeeName,
			@NotEmpty(message = "employee email should not be blank") String email,
			@NotEmpty(message = "employee designation should not be empty") String designation,
			@NotEmpty(message = "employee grade  should not be empty") String grade,
			@NotEmpty(message = "resource type should not be empty") String resourceType, Date date_Of_Joining,
			@NotNull(message = "employee total experience should not be empty") Double totalExp,
			@NotEmpty(message = "employee reporting manager field should not be empty") String iRM,
			@NotEmpty(message = "employee current location should not be blank") String currentLocation,
			@NotEmpty(message = "employee current allocation should not be blank") String currentAllocation,
			@NotEmpty(message = "employee project allocation should not be blank") String project) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.designation = designation;
		this.grade = grade;
		this.resourceType = resourceType;
		this.date_Of_Joining = date_Of_Joining;
		this.totalExp = totalExp;
		IRM = iRM;
		this.currentLocation = currentLocation;
		this.currentAllocation = currentAllocation;
		this.project = project;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public Date getDate_Of_Joining() {
		return date_Of_Joining;
	}
	public void setDate_Of_Joining(Date date_Of_Joining) {
		this.date_Of_Joining = date_Of_Joining;
	}
	public Double getTotalExp() {
		return totalExp;
	}
	public void setTotalExp(Double totalExp) {
		this.totalExp = totalExp;
	}
	public String getIRM() {
		return IRM;
	}
	public void setIRM(String iRM) {
		IRM = iRM;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public String getCurrentAllocation() {
		return currentAllocation;
	}
	public void setCurrentAllocation(String currentAllocation) {
		this.currentAllocation = currentAllocation;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	@Override
	public String toString() {
		return "EmployeeFile [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email
				+ ", designation=" + designation + ", grade=" + grade + ", resourceType=" + resourceType
				+ ", date_Of_Joining=" + date_Of_Joining + ", totalExp=" + totalExp + ", IRM=" + IRM
				+ ", currentLocation=" + currentLocation + ", currentAllocation=" + currentAllocation + ", project="
				+ project + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
