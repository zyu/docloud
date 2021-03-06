package com.docloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DocloudConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocloudConfigClientApplication.class, args);
	}

}

