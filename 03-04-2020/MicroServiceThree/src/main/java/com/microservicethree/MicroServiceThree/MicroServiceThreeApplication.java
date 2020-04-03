package com.microservicethree.MicroServiceThree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.microservicethree.MicroServiceThree.configribbon.RibbonConfiguration;
@EnableEurekaServer
@EnableAutoConfiguration
@SpringBootApplication
public class MicroServiceThreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceThreeApplication.class, args);
	}
/*	@ConditionalOnMissingBean
	@Bean
	public HttpTraceRepository httpTraceRepository() {
	  return new InMemoryHttpTraceRepository();
	}
*/
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
