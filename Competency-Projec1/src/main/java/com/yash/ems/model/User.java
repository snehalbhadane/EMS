package com.yash.ems.model;



import javax.persistence.*;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="EmailID")
	private String emailId;
	
	@Column(name="User_Name")
	private String userName;
	
	@Column(name="Password")
	private String password;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int Id, String emailId, String userName, String password) {
		super();
		this.id = Id;
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
	}

	public int getEmpId() {
		return id;
	}

	public void setEmpId(int empId) {
		this.id = empId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

