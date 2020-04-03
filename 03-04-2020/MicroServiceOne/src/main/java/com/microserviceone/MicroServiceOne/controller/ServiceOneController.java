package com.microserviceone.MicroServiceOne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microserviceone.MicroServiceOne.model.Address;
import com.microserviceone.MicroServiceOne.model.EmployeeDetails;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ServiceOneController {

	@Autowired
	RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "callEmpService_Fallback")
	@GetMapping("/getEmpDtl/{id}")
	EmployeeDetails getEmpDtls(@PathVariable(value = "id") int id) {
    	EmployeeDetails empDtls =null;
    	try {
		 empDtls = restTemplate.getForObject("http://localhost:8082/getEmpDtls/" + id,
				EmployeeDetails.class);
    	}catch(Exception e ) {
    		e.printStackTrace();
    	}
		return empDtls;

	}
    EmployeeDetails callEmpService_Fallback(@PathVariable(value = "id") int id){
    	EmployeeDetails empDtls = new  EmployeeDetails();
    	empDtls.setId(id);
    	empDtls.setName("Dummy Name CB Fallback");
    	Address addr=new Address();
    	addr.setFlatno("DDDDD");
    	addr.setLandmark("DDDD");
    	addr.setMobileno("0000000");
    	
    	empDtls.setAddr(addr);
    	// "Circuit Breaker Enabled!! Fallback method triggered";
		return empDtls;
    	
    }
}
