package com.docloud.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface TestTopic {

	String OUTPUT = "example-topic-output";
	String OUTPUT2 = "example-topic-output2";
	String INPUT = "example-topic-input";
	String INPUT2 = "example-topic-input2";

	@Output(OUTPUT)
	MessageChannel output();

	@Input(INPUT)
	SubscribableChannel input();

	@Output(OUTPUT2)
	MessageChannel output2();

	@Input(INPUT2)
	SubscribableChannel input2();
}
