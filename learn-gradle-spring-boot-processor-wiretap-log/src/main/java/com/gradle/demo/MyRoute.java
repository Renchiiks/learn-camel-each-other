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
		.log("Starting route")
		.wireTap("file:data/tap?noop=true")
		.log("creating wireTap")
		.process(firstRoute)
		.log("ending route")
		.to("file:data/firstOutput");

		from("file:data/tap?noop=true")
		.log("starting wireTap route")
		.process(secondRoute)
		.log("ending second route")
		.to("file:data/secondOutput");

	}
}
