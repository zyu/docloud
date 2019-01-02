package com.docloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

//@EnableCircuitBreaker
//@EnableEurekaClient
//@SpringBootApplication
@SpringCloudApplication
public class DocloudConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocloudConsumerApplication.class, args);
	}

}

