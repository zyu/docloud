package com.docloud.controller;

import com.docloud.mq.TestTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

	@Autowired
	private TestTopic testTopic;

	@GetMapping("/sendMessage")
	public String messageWithMQ(@RequestParam String message) {
		testTopic.output().send(MessageBuilder.withPayload(message).setHeader("version", "1.0").build());
		testTopic.output().send(MessageBuilder.withPayload(message).setHeader("version", "2.0").build());
		//testTopic.output().send(MessageBuilder.withPayload(message).setHeader("x-delay", 5000).build());
		return "ok";
	}

}
