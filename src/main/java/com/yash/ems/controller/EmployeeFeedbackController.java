package com.yash.ems.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback/api")
public class EmployeeFeedbackController {


	@PostMapping("/saveEmployeeFadeback")
	public void getData() {
		System.out.println("Hello");
	}
}