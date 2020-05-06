package com.capg.mms.theatre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
//@EnableJpaRepositories("com.capg.mms.theatre.repository")
public class MmsTheatreMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmsTheatreMsApplication.class, args);
	}

}
