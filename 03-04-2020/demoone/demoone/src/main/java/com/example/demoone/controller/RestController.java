package com.example.demoone.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.RequestData;
import com.example.model.ResponseData;
import com.testcomposcan.TestComponent;
@ComponentScan(basePackages= {"com"})
@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	TestComponent test;
	
	@RequestMapping(path="/hello", method=RequestMethod.GET)
	String sayHello() {
		return "Hello!! ";
		
	}
	
	@PutMapping(value="/put")
	public String saveOrUpdtDtaa(String name) {
		return "Name :"+name+" Saved/Updated";
	}
	
	@PostMapping(value="/post")
	public String saveDtaa(String name) {
		return "Name :"+name+" Saved";
	}
	
	@DeleteMapping(value="/del")
	public String deleteDtaa(String name) {
		return "Name :"+name+" Deleted";
	}
	
	@PostMapping(value="/getData")
	public ResponseData getData(@RequestBody RequestData req) {
		ResponseData resp=new ResponseData();
		resp.setEmail("pooja@gmail.com");
		resp.setId(req.getId());
		resp.setName("Pooja");
		return resp;
	}
	
	@GetMapping("/getEnv")
	String getEnvName(){
		String envName=test.getValueFromProp();
		return envName;
		
	}
	
	
/*	@Scheduled(initialDelay = 2000, fixedDelay = 10000)
	 public void run() {
		System.out.println("Current time is :: " + Calendar.getInstance().getTime());
	 }
*/	@Scheduled(cron = "0 * * ? * *")
	public void cronJobSch() throws Exception {
		System.out.println("Cron Job Triggerred for every 1min ->Date and Time :: "+new Date());
	}

	
}
