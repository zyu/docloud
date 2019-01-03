package com.docloud.controller;

import com.docloud.dto.User;
import com.docloud.service.DemoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorDemoController implements DemoService {

	@Override
	public String sayHello(@RequestParam(" name") String name) {
		return "Hello " + name;

	}

	@Override
	public User sayHello(@RequestHeader(" name") String name, @RequestHeader(" age") Integer age) {
		return new User(name, age);
	}

	@Override
	public String sayHello(@RequestBody User user) {
		return "Hello " + user.getName() + "," + user.getAge();
	}


}
