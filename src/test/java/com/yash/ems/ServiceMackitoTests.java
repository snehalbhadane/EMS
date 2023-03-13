package com.yash.ems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.yash.ems.entity.Employee;
import com.yash.ems.entity.EmployeeFeedback;
import com.yash.ems.entity.EmployeeFeedbackFile;
import com.yash.ems.entity.EmployeeSkillsRating;
import com.yash.ems.entity.Skill;
import com.yash.ems.entity.User;
import com.yash.ems.repository.EmployeeFeedbackRepository;
import com.yash.ems.service.FeedbackService;
import com.yash.ems.service.FeedbackServiceImpl;

@SpringBootTest (classes= {ServiceMackitoTests.class})
public class ServiceMackitoTests {
	
	@Mock
	EmployeeFeedbackRepository empFeedRepo;
	
	@InjectMocks
	FeedbackServiceImpl feedbackService ;
	

	
	
	public List<EmployeeFeedback> allFeedbacks;
	
	
	@Test
	@Order(1)
	public void test_getAllEmployeeFeedback() {
		
		List<EmployeeFeedback> allFeedbacks=new ArrayList<EmployeeFeedback>();
		
		List<EmployeeSkillsRating> skillList= new ArrayList<>();
		skillList.add(new EmployeeSkillsRating (1,2,"good",new Skill(1,"java")));
		
		allFeedbacks.add(new EmployeeFeedback(1,6,5,"aaaa","suggestion",LocalDateTime.now(),new Employee(1,"Amol","10156","6"),new EmployeeFeedbackFile(1,"msk",LocalDateTime.now(),new User(1,"2","3","4","5")),new User(1,"2","3","4","5"), skillList));
		allFeedbacks.add(new EmployeeFeedback(1,6,5,"comment","suggestion",LocalDateTime.now(),new Employee(1,"msk","10157","6"),new EmployeeFeedbackFile(1,"msk",LocalDateTime.now(),new User(1,"2","3","4","5")),new User(1,"2","3","4","5"), skillList));
		
		when(empFeedRepo.findAll()).thenReturn(allFeedbacks);
	    
		assertEquals(2,feedbackService.getAllEmployeeFedback().size());
			
	}
	
	
	@Test
	@Order(2)
	public void saveEmployeeFeedback() {
		
		List<EmployeeSkillsRating> skillList= new ArrayList<>();
		skillList.add(new EmployeeSkillsRating (1,2,"good",new Skill(1,"java")));
		skillList.add(new EmployeeSkillsRating (2,5,"very good",new Skill(2,"HTML")));
		
		EmployeeFeedback employeefeedback=new  EmployeeFeedback(1,6,5,"comment","learn more technology",LocalDateTime.now(),new Employee(1,"msk","10157","6"),new EmployeeFeedbackFile(1,"msk",LocalDateTime.now(),new User(1,"2","3","4","5")),new User(1,"2","3","4","5"), skillList);
		
		
		when(empFeedRepo.save(employeefeedback)).thenReturn(employeefeedback);
		
		
		assertEquals(employeefeedback,feedbackService.saveEmployeeFeedback(employeefeedback));
		
		assertEquals(6,feedbackService.saveEmployeeFeedback(employeefeedback).getOverallExperience());
		
		
		assertEquals("learn more technology",feedbackService.saveEmployeeFeedback(employeefeedback).getSuggestion());
	
		//assertEquals(1,"msk","10157","6",feedbackService.saveEmployeeFeedback(employeefeedback).getEmployee());
	}

}
