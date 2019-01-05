package com.docloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringCloudApplication
public class DocloudTrace1Application {

	public static void main(String[] args) {
		SpringApplication.run(DocloudTrace1Application.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
	  return  new RestTemplate();
	}
}

