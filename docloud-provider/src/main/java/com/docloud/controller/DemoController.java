package com.docloud.controller;


import com.docloud.exceptions.ProviderException;
import com.docloud.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class DemoController {

	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

	@Autowired
	private DiscoveryClient discoveryClient;

	@Value("${server.port}")
	private String port;

	@RequestMapping(value = "sayhello", method = RequestMethod.GET)
	public String sayHello(String name) {
		logger.info("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name);
		List<ServiceInstance> instances = discoveryClient.getInstances(discoveryClient.getServices().get(0));
		logger.info("/ hello, host:" + instances.get(0).getHost() + ", service_id:" + instances.get(0).getServiceId());
		return "Hello " + name + " port:" + port;
	}

	@RequestMapping(value = "dorrror", method = RequestMethod.GET)
	public String doError() {
		throw new ProviderException("this is demo exception");
	}

	@RequestMapping(value = "/sayHello2", method = RequestMethod.GET)
	public User sayHello(@RequestHeader String name, @RequestHeader Integer age) {
		return new User(name, age);
	}

	@RequestMapping(value = "/sayHello3", method = RequestMethod.POST)
	public String sayHello(@RequestBody User user) {
		return "Hello " + user.getName() + "," + user.getAge();
	}
}
