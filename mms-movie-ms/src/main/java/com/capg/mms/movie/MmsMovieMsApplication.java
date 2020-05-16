package com.capg.mms.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MmsMovieMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmsMovieMsApplication.class, args);
	}

}
