package com.gradle.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {

	@Autowired
	MyProcessorFirstRoute firstRoute;
	@Autowired
	MyProcessorSecondRoute secondRoute;

	@Override
	public void configure() throws Exception {
		from("file:data/input?noop=true")
		.wireTap("file:data/tap?noop=true")
		.process(firstRoute)
		.to("file:data/firstOutput");

		from("file:data/tap?noop=true")
		.process(secondRoute)
		.to("file:data/secondOutput");

	}
}
