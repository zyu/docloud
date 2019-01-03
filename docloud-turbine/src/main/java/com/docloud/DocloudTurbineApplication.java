package com.docloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.netflix.turbine.stream.TurbineStreamProperties;
import org.springframework.context.annotation.Bean;

@EnableTurbine
@EnableDiscoveryClient
@SpringBootApplication
public class DocloudTurbineApplication {

	@Bean
	public TurbineStreamProperties turbineStreamProperties(){
		return new  TurbineStreamProperties();
	}

	public static void main(String[] args) {
		SpringApplication.run(DocloudTurbineApplication.class, args);
	}

}

