package com.yash.ems.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.yash.ems.model.User;
import com.yash.ems.repository.LoginRegistrationRepository;



@Service
public class LoginRegistrationService {
	
	@Autowired
	private LoginRegistrationRepository loginRegistrationRepository;
	
	public User saveUser(User cm) {
		
		return loginRegistrationRepository.save(cm);
	}

	public User fetchByEmailId(String emailId) {
		
		return loginRegistrationRepository.findByEmailId(emailId);
		
	}
	
public User fetchCompetencyMemberByEmailIdAndPassword(String emailId,String password) {
		
		return loginRegistrationRepository.findByEmailIdAndPassword(emailId, password);
	}

public List<User>getAll(@RequestBody User cm) {
	
	return loginRegistrationRepository.findAll();
	
}
}



