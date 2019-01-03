package com.docloud.service;

import com.docloud.dto.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/refactor")
public interface DemoService {

	@RequestMapping(value = "/sayHello4", method = RequestMethod.GET)
	String sayHello(@RequestParam("name") String name);

	@RequestMapping(value = "/sayHello5", method = RequestMethod.GET)
	User sayHello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

	@RequestMapping(value = "/sayHello6", method = RequestMethod.POST)
	String sayHello(@RequestBody User user);

}
