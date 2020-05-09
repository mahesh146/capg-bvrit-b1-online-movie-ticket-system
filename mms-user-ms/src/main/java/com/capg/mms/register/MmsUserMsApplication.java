package com.capg.mms.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.capg.mms.register.model.Show;
import com.capg.mms.register.model.Theatre;

@SpringBootApplication
@EnableEurekaClient
public class MmsUserMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmsUserMsApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	

}
