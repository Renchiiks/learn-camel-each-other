package com.gradle.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		rest().get("/help")
		.produces(MediaType.ALL_VALUE)
		.route()
		.setBody(constant("Help World"));

	}

}
