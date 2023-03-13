package com.yash.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ems.entity.EmployeeFeedbackFile;

@Repository
public interface EmployeeFeedbackFileRepository extends JpaRepository<EmployeeFeedbackFile, Integer> {

}