package com.yash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yash.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
	public List<Skill> findBySkillName(String skillName);
}
