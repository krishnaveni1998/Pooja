package com.example.demoone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;


/*import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2*/
@EntityScan("com.example.model")

@EnableScheduling
@SpringBootApplication
public class DemooneApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemooneApplication.class, args);
	}

}
