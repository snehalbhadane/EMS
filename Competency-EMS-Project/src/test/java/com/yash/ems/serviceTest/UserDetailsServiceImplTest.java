package com.yash.ems.serviceTest;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.yash.ems.model.User;
import com.yash.ems.repo.UserRepository;
import com.yash.ems.service.impl.UserDetailsServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserDetailsServiceImplTest {
	
	@Mock
    private UserRepository userRepository;
	
	@InjectMocks
	private UserDetailsServiceImpl userDetailsServiceImpl =new UserDetailsServiceImpl();
	

	private User user;
	
	@BeforeEach
	void setUp() {
	
//		when(userRepository.findByUsername("shubham")).thenReturn("shubham");
	
	
	}
	
	
	
	

}
