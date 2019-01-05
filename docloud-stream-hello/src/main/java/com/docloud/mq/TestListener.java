package com.docloud.mq;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.SendTo;

@Slf4j
@EnableBinding(TestTopic.class)
public class TestListener {

	int counter = 1;

//	@StreamListener(TestTopic.INPUT)
//	public void receive(String payload) {
//		log.info("Received: " + payload + ", " + counter);
//		//throw new RuntimeException("Message consumer failed!");
//
//		// 计数，模拟重试过程中成功消费
//		//            if (counter == 3) {
//		//                counter = 1;
//		//                return;
//		//            } else {
//		//                counter++;
//		//                throw new RuntimeException("Message consumer failed!");
//		//            }
//
//		// 进入DLQ的逻辑
//		//            if (counter == 3) {
//		//                counter = 1;
//		//                throw new AmqpRejectAndDontRequeueException("tried 3 times failed, send to dlq!");
//		//            } else {
//		//                counter ++;
//		//                throw new RuntimeException("Message consumer failed!");
//		//            }
//	}

	/**
	 * 消息消费失败的降级处理逻辑
	 *
	 * @param message
	 */
//	@ServiceActivator(inputChannel = "test-topic.stream-exception-handler.errors")
//	public void error(Message<?> message) {
//		log.info("Message consumer failed, call fallback!");
//	}
//
//	@StreamListener(value = TestTopic.INPUT, condition = "headers['version']=='1.0'")
//	public void receiveV1(String payload, @Header("version") String version) {
//		log.info("Received v1 : " + payload + ", " + version);
//	}
//
//	@StreamListener(value = TestTopic.INPUT, condition = "headers['version']=='2.0'")
//	public void receiveV2(String payload, @Header("version") String version) {
//		log.info("Received v2 : " + payload + ", " + version);
//	}

	@StreamListener(value = TestTopic.INPUT)
	@SendTo(value = TestTopic.INPUT2)
	public String receiveV3(String payload) {
		log.info("Received v3 : " + payload);
		return  "received";
	}

	@StreamListener(TestTopic.INPUT2)
	public void receiveV4(String payload) {
		log.info("Received v4 : " + payload);
	}
}
