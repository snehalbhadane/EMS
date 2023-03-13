package com.yash.ems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ems.entity.Employee;
import com.yash.ems.entity.EmployeeFeedback;

@Repository
public interface EmployeeFeedbackRepository extends JpaRepository<EmployeeFeedback, Integer> {
	
	Optional<EmployeeFeedback> getEmployeeFeedbackById(String code);

}