package com.docloud.service.impl;

import com.docloud.model.User;
import com.docloud.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCollapser(batchMethod = "findAll", collapserProperties = {@HystrixProperty(name = "timerDelayInMilliseconds", value = "100")})
	@Override
	public User find(Long id) {
		//return restTemplate.getForObject("http://PROVIDER/users/{1}", User.class, id);
		return null;
	}

	@HystrixCommand
	@Override
	public List<User> findAll(List<Long> ids) {
		return restTemplate.getForObject("http://PROVIDER/users?ids ={1}", List.class, StringUtils.join(ids, ","));
	}

}
