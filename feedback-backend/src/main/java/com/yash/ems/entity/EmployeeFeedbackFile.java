package com.yash.ems.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_feedback_file")
public class EmployeeFeedbackFile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="file_name")
	private String fileName;
	
	@Column(name="uploaded_on")
	private LocalDateTime uploadedOn;

//	@Column(name="uploaded_by_id")
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "uploaded_by_id")
//	private User uploadedBy;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public LocalDateTime getUploadedOn() {
		return uploadedOn;
	}
	public void setUploadedOn(LocalDateTime uploadedOn) {
		this.uploadedOn = uploadedOn;
	}
}