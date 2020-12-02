package com.gradle.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {

	@Autowired
	private MyMethod method;

	@Override
	public void configure() throws Exception {
		from("file:data/input?fileName=names.txt&noop=true")
		.process(method)
		.to("file:data/output?fileName=modifiedNames.txt");	
	}
}
