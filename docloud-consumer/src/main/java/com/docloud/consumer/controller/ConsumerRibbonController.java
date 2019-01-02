package com.docloud.consumer.controller;

import com.docloud.consumer.service.DemoRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;

@RestController
public class ConsumerRibbonController {


	@Autowired
	DemoRibbonService demoRibbonService;

	@RequestMapping(value = "/ribbon-sayhello/{name}", method = RequestMethod.GET)
	public String sayhello(@PathVariable String name) {
		return demoRibbonService.sayhello(name);
	}

	@RequestMapping(value = "/ribbon-sayhelloasync/{name}", method = RequestMethod.GET)
	public Observable<String> sayhelloasync(@PathVariable String name) {
		return demoRibbonService.sayhelloasync(name);
	}

}
