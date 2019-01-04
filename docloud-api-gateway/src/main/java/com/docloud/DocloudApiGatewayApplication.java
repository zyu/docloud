package com.docloud;

import com.docloud.filter.AccessFilter;
import com.docloud.filter.RateLimitFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class DocloudApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocloudApiGatewayApplication.class, args);
	}

	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}

	@Bean
	public RateLimitFilter rateLimitFilter() {
		return new RateLimitFilter();
	}

	@Bean
	public PatternServiceRouteMapper patternServiceRouteMapper() {
		return new PatternServiceRouteMapper("（?<name>^.+）-（?<version>v.+$）", "${version}/${name}");
	}
}

