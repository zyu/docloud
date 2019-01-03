package com.docloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableCircuitBreaker
//@EnableEurekaClient
//@SpringBootApplication
@SpringCloudApplication
@EnableFeignClients
@EnableHystrixDashboard
public class DocloudConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocloudConsumerApplication.class, args);
	}

}

