package com.microservicethree.MicroServiceThree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservicethree.MicroServiceThree.model.Address;

@RestController("serviceThree")
public class ServiceThreeController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/getEmpAddr/{id}")
	Address getEmpDtls(@PathVariable(value = "id") int id) {
		Address addr = new Address();
		addr.setFlatno("1A-408");
		addr.setLandmark("siruseri");
		addr.setMobileno("9581293958");
		return addr;

	}

}
