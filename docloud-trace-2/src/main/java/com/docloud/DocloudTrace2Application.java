package com.docloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DocloudTrace2Application {

	public static void main(String[] args) {
		SpringApplication.run(DocloudTrace2Application.class, args);
	}

}

