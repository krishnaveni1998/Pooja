package com.fss.cms.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("test")
public class TestComponent {
	@Value("${env_name}")
	String currentEnvName;
	public String getValueFromProp(){
		System.out.println("c::"+currentEnvName);
		return currentEnvName;
		
	}
	

}
