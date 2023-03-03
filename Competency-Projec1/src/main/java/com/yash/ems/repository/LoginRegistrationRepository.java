package com.yash.ems.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ems.model.User;

@Repository
public interface LoginRegistrationRepository extends JpaRepository<User, Integer> {
	

	public User findByEmailId(String emailId);
	
	public User findByEmailIdAndPassword(String emailId,String password);

}

