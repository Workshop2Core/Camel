package com.javatrainee.batch27.routebuilder;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class DataSahamRouteBuilder extends CamelRouteBuilder   {
	public void configure() throws Exception {
		String mapping = "/workshop2/dataSaham";
		
		/*Get All*/
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/getAllDataSaham")
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/getAllDataSaham");
		
		/*find Data Saham By User Id*/
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/getDataSahamByUserId/{userId}")
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/getDataSahamByUserId/{userId}");
				
		/*Insert*/
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/insert?restletMethod=POST")
		.process(new Processor() {                          
            @Override
            public void process(Exchange exchange) throws Exception {
            	exchange.getOut().setHeader("Content-type", exchange.getIn().getHeader("Content-type"));
                exchange.getOut().setBody(exchange.getIn().getBody());
            }
        })
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/insert?restletMethod=POST");
		
		/*Update*/
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/update?restletMethod=PUT")
		.process(new Processor() {                          
            @Override
            public void process(Exchange exchange) throws Exception {
            	exchange.getOut().setHeader("Content-type", exchange.getIn().getHeader("Content-type"));
            	exchange.getOut().setHeader("idDataSaham", exchange.getIn().getHeader("idDataSaham")); 
                exchange.getOut().setBody(exchange.getIn().getBody());
            }
        })
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/update?restletMethod=PUT");
	
	}
}
