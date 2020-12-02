package com.gradle.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RouteClass extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:data/input?noop=true")
		.wireTap("file:data/tap")
		.to("file:data/output");	
	}
}
