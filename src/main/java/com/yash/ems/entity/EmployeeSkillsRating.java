package com.yash.ems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="employee_skills_rating")
public class EmployeeSkillsRating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="remarks")
	private String remarks;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="employee_feedback_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_feedback_id", referencedColumnName = "id")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	@JsonBackReference
	private EmployeeFeedback employeeFeedback;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="skill_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "skill_id", referencedColumnName = "id")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Skill skill;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public EmployeeFeedback getEmployeeFeedback() {
		return employeeFeedback;
	}
	public void setEmployeeFeedback(EmployeeFeedback employeeFeedback) {
		this.employeeFeedback = employeeFeedback;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
}