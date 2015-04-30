package com.javatrainee.batch27.routebuilder;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CamelRouteBuilder extends RouteBuilder{

	@Value("${camel.restlet.port}")
	protected String camelPort;
	
	@Value("${springcore.rest.port}")
	protected String springCorePort;
	
	@Value("${camel.restlet.ip}")
	protected String camelIp;
	
	@Value("${springcore.rest.ip}")
	protected String springCoreIp;
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
