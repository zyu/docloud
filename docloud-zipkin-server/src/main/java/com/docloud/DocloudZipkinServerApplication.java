package com.docloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class DocloudZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocloudZipkinServerApplication.class, args);
	}

}

