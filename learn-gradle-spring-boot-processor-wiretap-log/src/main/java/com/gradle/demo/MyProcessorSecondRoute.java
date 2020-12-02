package com.gradle.demo;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class MyProcessorSecondRoute implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		String message = exchange.getIn().getBody(String.class);
		message = message.toUpperCase();
		exchange.getIn().setBody(message);
		
	}
}
