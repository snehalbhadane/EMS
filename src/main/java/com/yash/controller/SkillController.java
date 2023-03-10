package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.Employee;
import com.yash.model.Skill;
import com.yash.service.SkillService;

//@CrossOrigin("*")
@CrossOrigin("http://localhost:49346/createemployee")
@RestController
@RequestMapping("/ems/skill")
public class SkillController {

	@Autowired
	private SkillService skillService;
	
	@PostMapping("/save-skill")
	public Skill addSkills(@RequestBody Skill skill)
	{
		return skillService.addSkill(skill);
	}
	@GetMapping("/get-all-employees-skill")
	public List<Skill> getAllSkillsDetails()
	{
		return skillService.getAllSkill();
	}
	

	@GetMapping("/getSkillData/{skillName}")
	public ResponseEntity<List<Skill>> getAllSkillData(@PathVariable String skillName){
		List<Skill> skillNameContain = skillService.findBySkillNameContain(skillName);
		return new ResponseEntity<>(skillNameContain,HttpStatus.ACCEPTED);
		
	}
}
