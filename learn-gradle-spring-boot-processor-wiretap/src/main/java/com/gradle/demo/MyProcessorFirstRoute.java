package com.gradle.demo;

import java.time.LocalDateTime;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class MyProcessorFirstRoute implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String message = exchange.getIn().getBody(String.class);
		message = ((LocalDateTime.now()).toString()).concat(" " + message);
		exchange.getIn().setBody(message);

	}
}
