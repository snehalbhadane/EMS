package com.yash.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ems.entity.EmployeeFeedback;

@Repository
public interface EmployeeFeedbackRepository extends JpaRepository<EmployeeFeedback, Integer> {

}