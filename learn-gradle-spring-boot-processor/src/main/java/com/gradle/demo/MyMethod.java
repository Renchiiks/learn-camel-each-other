package com.gradle.demo;

import java.util.Arrays;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class MyMethod implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String message = exchange.getIn().getBody(String.class);
		message = message.concat("Ziema");
		message = message.toUpperCase();
		exchange.getIn().setBody(message);
	}
}
