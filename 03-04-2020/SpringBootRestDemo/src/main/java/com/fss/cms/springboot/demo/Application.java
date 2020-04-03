package com.fss.cms.springboot.demo;

import java.sql.Timestamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*@ComponentScan(basePackages = "com")*/
/*@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })*/

/*@EnableBatchProcessing*/
//@EnableAutoConfiguration
/*@EnableEncryptableProperties*/
/*@PropertySource(name="DBconfig.properties", value = "classpath:DBconfig.properties")*/
/*@EnableBatchProcessing*/
@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages= {"com"})

@EnableSwagger2
public class Application {
	@Bean
RestTemplate getRestTemplate(){
	return new RestTemplate();
	
}
	
    @Bean
    public Docket myAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
            
                .build();
    }

	
	
	private ApiInfo apiInfo() {
				return new ApiInfo("DEMO:: swagger title ", "desc", "1.0", "/http://localhost:8761/swagger-ui.html", "9581293958", "@FSS", "www.google.com");
	}

	public static void main(String[] args) { 
	
		SpringApplication.run(Application.class, args);
		/*   SpringApplication app = new SpringApplication(Application.class);
		    app.setBannerMode(Banner.Mode.OFF);
		    app.run(args);
*/
	}

}
