package com.docloud.mq;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component

public class Receiver {

	@RabbitListener(queues = "hello")
	//@RabbitListener(queuesToDeclare = {@Queue("hello")})
	//@RabbitListener(bindings = @QueueBinding(value = @Queue("hello"), exchange = @Exchange("exchange")))
	public void process(String hello) {
		System.out.println("Receiver:" + hello);
	}

	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange("exchange"), key = "computer", value = @Queue("hello")))
	public void processComputer(String hello) {
		System.out.println("Receiver:" + hello);
	}

	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange("exchange"), key = "fruit", value = @Queue("hello")))
	public void processFruit(String hello) {
		System.out.println("Receiver:" + hello);
	}
}
