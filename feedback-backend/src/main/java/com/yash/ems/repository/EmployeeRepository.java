package com.yash.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.ems.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//	@Query(value = "SELECT id, name, code FROM employee WHERE name =:name AND code =:code", nativeQuery = true)
//	@Query("SELECT e.id, e.name, e.code FROM employee e WHERE e.name = ?1 AND e.code = ?2")
	
	@Query(value = "SELECT * FROM employee WHERE name = ?1 AND code = ?2", nativeQuery = true)
	Employee getEmployeeByNameAndCode(String name, String code);
	
//	@Query("SELECT e FROM employee e WHERE e.name = ?1 and e.code = ?2")
//	Employee getEmployeeByNameAndCode(String name, String code);
}