package com.yash.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ems.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {

}