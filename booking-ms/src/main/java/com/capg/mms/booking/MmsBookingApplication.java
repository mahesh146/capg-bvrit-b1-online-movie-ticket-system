package com.capg.mms.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class MmsBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmsBookingApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
