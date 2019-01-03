package com.docloud.controller;

import com.docloud.model.User;
import com.docloud.service.DemoFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerFeignController {

	@Autowired
	private DemoFeignService demoFeignService;

	@RequestMapping(value = "/feign-sayhello/{name}", method = RequestMethod.GET)
	public String sayhello(@PathVariable String name) {
		return demoFeignService.sayhello(name);
	}

	@RequestMapping(value = "/feign-sayhello1/{name}", method = RequestMethod.GET)
	public String sayhello1(@PathVariable String name) {
		StringBuilder sb = new StringBuilder();
		sb.append(demoFeignService.sayhello(name)).append("\n");
		sb.append(demoFeignService.sayhello(" DIDI")).append("\n");
		sb.append(demoFeignService.sayhello(" DIDI", 30)).append("\n");
		sb.append(demoFeignService.sayhello(new User(" DIDI", 30))).append("\n");
		return sb.toString();
	}


}
