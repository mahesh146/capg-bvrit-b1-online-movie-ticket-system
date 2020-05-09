package com.capg.mms.user.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MmsUserRegisterMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmsUserRegisterMsApplication.class, args);
	}

}
