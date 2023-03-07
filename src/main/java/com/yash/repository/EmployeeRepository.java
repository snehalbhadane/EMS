package com.yash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public List<Employee>findBycurrentAllocationContaining(String currentAllocation);
	
	public Employee findByEmployeeIdAndEmployeeName(Integer employeeId, String employeeName);

}
