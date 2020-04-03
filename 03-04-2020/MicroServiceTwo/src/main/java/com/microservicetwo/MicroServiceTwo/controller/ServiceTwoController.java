package com.microservicetwo.MicroServiceTwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservicetwo.MicroServiceTwo.model.Address;
import com.microservicetwo.MicroServiceTwo.model.EmployeeDetails;

@RestController("serviceTwo")
public class ServiceTwoController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/getEmpDtls/{id}")
	EmployeeDetails getEmpDtls(@PathVariable(value = "id") int id) {
		EmployeeDetails empDtls = new EmployeeDetails();
		System.out.println("id:" + id);
		Address addr = restTemplate.getForObject("http://localhost:8761/getEmpAddr/" + id, Address.class);
		empDtls.setAddr(addr);
		empDtls.setId(id);
		empDtls.setName("Pooja");
		return empDtls;

	}

}
