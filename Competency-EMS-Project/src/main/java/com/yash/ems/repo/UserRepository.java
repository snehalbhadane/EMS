package com.yash.ems.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.ems.model.User;



public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
