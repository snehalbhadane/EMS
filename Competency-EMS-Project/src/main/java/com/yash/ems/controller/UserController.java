package com.yash.ems.controller;

import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.yash.ems.exception.UserFoundException;
import com.yash.ems.model.Role;
import com.yash.ems.model.User;
import com.yash.ems.model.UserRole;
import com.yash.ems.services.UserService;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
    @Autowired
    private UserService userService;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
    	
    	 Role role = new Role();
 	  
  
      	logger.info("Data From UI"+user);
    	
    	if(user.getEmpDesignation().contains("Competency Member")) {
   		
   		role.setRoleId(44L);
   		role.setRoleName("Competency Member");
   		
   		logger.info("User Register for Role -Competency Member ");
    	}
    	else {
   		role.setRoleId(45L);
           role.setRoleName("Delivery Team/Client");
           logger.info("User Register for Role -Competency Member ");
  		
  	}

    	
    	

       
        //encoding password with bcryptpasswordencoder

//        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        Set<UserRole> roles = new HashSet<>();

//        Role role = new Role();
//        role.setRoleId(44L);
//        role.setRoleName("ADMIN");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        logger.info("Registration Sucessful");
        
        return this.userService.createUser(user, roles);
        
      

    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUser(username);
    }

//    //delete the user by id
//    @DeleteMapping("/{userId}")
//    public void deleteUser(@PathVariable("userId") Long userId) {
//        this.userService.deleteUser(userId);
//    }


    //update api


    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }


}

