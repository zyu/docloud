package com.docloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class DocloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocloudConfigServerApplication.class, args);
	}

}

