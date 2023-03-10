package com.yash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.exception.ResourceNotFoundException;
import com.yash.model.Employee;
import com.yash.model.Skill;
import com.yash.repository.SkillRepository;




@Service
public class SkillService {
	@Autowired
	private SkillRepository skRepository;
	String message="Employee is not exist with this id ";
	
	public Skill addSkill(Skill skills) {
		
		return skRepository.save(skills);
	}

	
	public List<Skill> getAllSkill() {
		
		return skRepository.findAll();
	}
	
//	public Skill getSingleSkillData(int skillId) {
//		return skRepository.findById(skillId)
//				.orElseThrow(() -> new ResourceNotFoundException(message + skillId));
//	}

//	public Skill findBySkill (String skillName) {
//		return skRepository.findBySkill(skillName);
//		
//	}
	
	public List<Skill> findBySkillNameContain(String skillName){
		List<Skill> findBySkillNameContain = skRepository.findBySkillName(skillName);
		return findBySkillNameContain;
	}
}
