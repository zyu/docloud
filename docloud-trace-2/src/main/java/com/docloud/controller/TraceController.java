package com.docloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class TraceController {

	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "/trace-2", method = RequestMethod.GET)
	public String trace() {
		log.info("===<call trace-2,TraceId={},SpanId={}>===", request.getHeader("X-B3-TraceId"), request.getHeader("X-B3-SpanId"));
		return "trace";
	}
}
