package com.microserviceone.MicroServiceOne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microserviceone.MicroServiceOne.model.EmployeeDetails;

@RestController
public class ServiceOneController {

	@Autowired
	RestTemplate restTemplate;
	@GetMapping("/getEmpDtl")
	EmployeeDetails getEmpDtls() {
		EmployeeDetails empDtls=restTemplate.getForObject("http://localhost:8761/serviceTwo/getEmpDtls", EmployeeDetails.class);
		return empDtls;
		
	}
	
}
