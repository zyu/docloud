package com.docloud.service;

import com.docloud.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("PROVIDER")
public interface DemoFeignService {

	@RequestMapping(value = "/sayhello", method = RequestMethod.GET)
	String sayhello(@RequestParam("name")String name);

	@RequestMapping(value = "/sayhello2", method = RequestMethod.GET)
	User sayhello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

	@RequestMapping(value = "/sayhello3", method = RequestMethod.POST)
	String sayhello(@RequestBody User user);

}
