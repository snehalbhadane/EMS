package com.yash.ems.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.ems.controller.EmployeeController;
import com.yash.ems.model.Employee;
import com.yash.ems.model.Skill;
import com.yash.ems.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	EmployeeService employeeService;
	
	@Test
	void testSaveEmployeeObject() throws JsonProcessingException, Exception {
List<Skill> skill=Arrays.asList(new Skill(1,"java"), new Skill(2,"spring boot"));
		
		Employee employee=new Employee(101, "Priya Patil", "priyapatil@gmail.com", "sr.softwareEngineer", "E2", "experienced", "16-06-2022", 4.5, "Mr.Maruti", "Magarpatta", "project", "BNY", skill);

		when(employeeService.saveEmployeeObject(employee)).thenReturn(employee);
		
		mockMvc.perform(post("/employee/addEmployeeData")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(employee)))
				.andExpect(status().isCreated());
		}
	
	@Test
	void testAllEmployeeObject() throws Exception {
		
List<Skill> skill=Arrays.asList(new Skill(1,"java"), new Skill(2,"spring boot"));
		
		Employee employee=new Employee(101, "Priya Patil", "priyapatil@gmail.com", "sr.softwareEngineer", "E2", "experienced", "16-06-2022", 4.5, "Mr.Maruti", "Magarpatta", "project", "BNY", skill);
		
		List<Employee>listEmployee=Arrays.asList(employee);
		when(employeeService.getAllEmployeeObject()).thenReturn(listEmployee);
		
		mockMvc.perform(get("/employee/getAllEmployeeData")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted());
	

}
}
