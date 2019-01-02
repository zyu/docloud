package com.docloud.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.ObservableExecutionMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;


@Service
public class DemoRibbonService {

	@Autowired
	RestTemplate restTemplate;

	public String sayhelloFallback(String name, Throwable e) {
		return "error";
	}


	@HystrixCommand(fallbackMethod = "sayhelloFallback", ignoreExceptions = {
			IllegalAccessError.class}, commandKey = "sayhello", groupKey = "demoGroup", threadPoolKey = "sayhelloThread")
	public String sayhello(String name) {
		return restTemplate.getForEntity("http://PROVIDER/sayhello?name={1}", String.class, name).getBody();
	}

	@HystrixCommand(fallbackMethod = "sayhelloFallback", observableExecutionMode = ObservableExecutionMode.EAGER)
	public Observable<String> sayhelloasync(String name) {
		return Observable.create(new Observable.OnSubscribe<String>() {
			@Override
			public void call(Subscriber<? super String> observer) {
				try {
					if (!observer.isUnsubscribed()) {
						String str = restTemplate.getForEntity("http://PROVIDER/sayhello?name={1}", String.class, name).getBody();
						observer.onNext(str);
						observer.onCompleted();
					}
				} catch (Exception e) { observer.onError(e); }
			}
		});
	}
}


