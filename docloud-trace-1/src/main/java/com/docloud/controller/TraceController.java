package com.docloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TraceController {

	@Autowired
	private RestTemplate restTemplate;

//	@Autowired
//	private LoadBalancerClient loadBalancerClient;

	//超时配置
	//	@HystrixCommand(commandProperties = {
	//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
	//	})

	//	@HystrixCommand(commandProperties = {
	//			@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  				//设置熔断
	//			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),	//请求数达到后才计算
	//			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
	//			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),	//错误率
	//	})
	@HystrixCommand
	@RequestMapping(value = "/trace-1", method = RequestMethod.GET)
	public String trace() {
//		RestTemplate restTemplate = new RestTemplate();
//		ServiceInstance serviceInstance = loadBalancerClient.choose("trace-2");
//		String url = String.format("http://%s:$s", serviceInstance.getHost(), serviceInstance.getPort());
//		return restTemplate.getForEntity(url + "/trace-2", String.class).getBody();
		return restTemplate.getForEntity("http://TRACE-2/trace-2", String.class).getBody();
	}

	private String fallback() {
		return "太拥挤了, 请稍后再试~~";
	}

	private String defaultFallback() {
		return "默认提示：太拥挤了, 请稍后再试~~";
	}
}
