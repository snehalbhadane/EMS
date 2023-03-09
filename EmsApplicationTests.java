package com.yash.ems;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yash.ems.model.Employee;
import com.yash.ems.model.Skill;
import com.yash.ems.repository.EmployeeRepository;
import com.yash.ems.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmsApplicationTests {
	@Mock
    EmployeeRepository employeeRepository;
	
	@InjectMocks
	EmployeeService employeeService;

	@Test
	void testSaveEmployeeData() {
      List<Skill> skill=Arrays.asList(new Skill(1,"java"), new Skill(2,"spring boot"));
		
		Employee employee=new Employee(101, "Priya Patil", "priyapatil@gmail.com", "sr.softwareEngineer", "E2", "experienced", "16-06-2022", 4.5, "Mr.Maruti", "Magarpatta", "project", "BNY", skill);
		
		when(employeeRepository.save(employee)).thenReturn(employee);
		Employee saveEmployee = employeeService.saveEmployeeObject(employee);
		assertThat(saveEmployee.getEmployeeName()).isSameAs(employee.getEmployeeName());
		//assertThat(saveEmployee.employeeName()).isSameAs(employee.employeeName());
		//verify(employeeRepository).save(employee);
		Mockito.verify(employeeRepository, Mockito.atLeastOnce()).save(employee);
	}
	
	@Test
	 void testAllEmployeeList() {
		
		List<Employee>list=new ArrayList<>();
		list.add(new Employee());
		when(employeeRepository.findAll()).thenReturn(list);
		List<Employee> allEmployeeObject = employeeService.getAllEmployeeObject();
		assertEquals(list, allEmployeeObject);
		Mockito.verify(employeeRepository).findAll();
	}
	
	@Test
	 void testDeleteEmployeeObject() {
        List<Skill> skill=Arrays.asList(new Skill(1,"java"), new Skill(2,"spring boot"));
		
		Employee employee=new Employee(101, "Priya Patil", "priyapatil@gmail.com", "sr.softwareEngineer", "E2", "experienced", "16-06-2022", 4.5, "Mr.Maruti", "Magarpatta", "project", "BNY", skill);
		when(employeeRepository.findById(employee.getEmployeeId())).thenReturn(Optional.of(employee));
		employeeService.getSingleEmployeeData(employee.getEmployeeId());
		Mockito.verify(employeeRepository, Mockito.atLeastOnce()).findById(employee.getEmployeeId());
	}
	
	@Test
	 void testUpdateEmployeeObject() {
		List<Skill> skill=Arrays.asList(new Skill(1,"java"), new Skill(2,"spring boot"));
			
		Employee employee=new Employee(101, "Priya Patil", "priyapatil@gmail.com", "sr.softwareEngineer", "E2", "experienced", "16-06-2022", 4.5, "Mr.Maruti", "Magarpatta", "project", "BNY", skill);
			
		List<Skill> skill2=Arrays.asList(new Skill(1,"advancejava"), new Skill(2,"spring boot"));
				
		Employee employee2=new Employee(101, "Piya Patil", "priyapatil@gmail.com", "sr.softwareEngineer", "E2", "experienced", "16-06-2022", 4.5, "Mr.Maruti", "Magarpatta", "project", "BNY", skill2);
		when(employeeRepository.findById(employee.getEmployeeId())).thenReturn(Optional.of(employee));
		employeeService.updateEmployeeObject(employee.getEmployeeId(), employee2);
		Mockito.verify(employeeRepository, Mockito.atLeastOnce()).save(any());
		}
	
	

}
