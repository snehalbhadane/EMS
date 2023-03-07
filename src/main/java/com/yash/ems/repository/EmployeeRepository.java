package com.yash.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.ems.entity.Employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{
	@Query(value = "SELECT id, name, code FROM employee WHERE name =:name AND code =:code", nativeQuery = true)
	Employee getEmployeeByNameAndCode(String name, String code);

}
