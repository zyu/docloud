package com.docloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DocloudProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocloudProviderApplication.class, args);
	}

}

