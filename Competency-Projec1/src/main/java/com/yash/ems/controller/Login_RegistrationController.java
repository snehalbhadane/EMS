package com.yash.ems.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ems.model.User;
import com.yash.ems.service.LoginRegistrationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Login_RegistrationController {
	
	Logger logger = LoggerFactory.getLogger(Login_RegistrationController.class);
	
	@Autowired
	private LoginRegistrationService lgoginRegistrationService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/registeruser")
	public User registerUser(@RequestBody User cm) throws Exception{
		
		//to check if email id is not empty or not null
		String tempEmailId=cm.getEmailId();
		
		if(tempEmailId!=null && !"".equals(tempEmailId)) {
			// if its not null and na then fetch dta by emailid
			User CmObject=lgoginRegistrationService.fetchByEmailId(tempEmailId);
			
			//if data is present it means user alredy exits.
			if(CmObject !=null) {
				
				
				logger.info("registration Failed User Alredy Exist");
				
				throw new Exception("CompetencyMember with "+tempEmailId+"alredy exit");
				
			}
			}
		
		User CmObject=null;
		
		lgoginRegistrationService.saveUser(cm);
		
		logger.info("registration sucessful");
		return 	CmObject;
		
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public User loginUser(@RequestBody User cm) throws Exception {
		
		String tempEmailId=cm.getEmailId();	
		String temppassword=cm.getPassword();
		
		User CmObject=null;
		if(tempEmailId !=null && temppassword !=null) {
			
		//CmObject=lgoginRegistrationService.fetchCompetencyMemberByEmailIdAndPassword(tempEmailId, temppassword);
		CmObject=lgoginRegistrationService.fetchCompetencyMemberByEmailIdAndPassword(tempEmailId, temppassword);
		}
        if(CmObject==null) {
		throw new Exception("this user"+ temppassword +"does not exit");
	}
        logger.info("Loging sucessful---");
	return CmObject;
	}
	
	@GetMapping("/getall")
	public List<User>getAll(@RequestBody User cm){
		return lgoginRegistrationService.getAll(cm);
		
	}
}

