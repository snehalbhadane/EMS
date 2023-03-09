package com.yash.ems.repository;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import com.yash.ems.model.Employee;
import com.yash.ems.model.Skill;
import com.yash.ems.repository.EmployeeRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
public class EmployeeRepoTest {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Test
	@Order(1)
	void testSaveEmployeeObject() {
		
	    List<Skill> skill=Arrays.asList(new Skill(1,"java"), new Skill(2,"spring boot"));
		
			Employee employee=new Employee(101, "Priya Patil", "priyapatil@gmail.com", "sr.softwareEngineer", "E2", "experienced", "16-06-2022", 4.5, "Mr.Maruti", "Magarpatta", "project", "BNY", skill);
		employeeRepository.save(employee);
		
		assertThat(employee.getEmployeeId()).isPositive();
	
	}
	

	
	@Test
	@Order(2)
	void testGetAllEmployeeObject() {
		
		List<Employee> findAll = employeeRepository.findAll();
		
		assertThat(findAll).isEmpty();
		
	}
	

}
