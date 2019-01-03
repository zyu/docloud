package com.docloud.service.impl;

import com.docloud.dto.User;
import com.docloud.service.DemoService;
import org.springframework.stereotype.Component;

@Component
public class DemoServiceFallBack implements DemoService {
	@Override
	public String sayHello(String name) {
		return "error";
	}

	@Override
	public User sayHello(String name, Integer age) {
		return null;
	}

	@Override
	public String sayHello(User user) {
		return "error";
	}
}
