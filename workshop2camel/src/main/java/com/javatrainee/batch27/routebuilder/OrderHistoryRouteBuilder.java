package com.javatrainee.batch27.routebuilder;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class OrderHistoryRouteBuilder extends CamelRouteBuilder  {
	@Override
	public void configure() throws Exception {
		String mapping = "/workshop2/orderHistory";
		
		/*Get All*/
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/getAll")
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/getAll");
		
		/*find Order History By OrderId*/
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/getOrderHistoryByOrderId/{orderId}")
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/getOrderHistoryByOrderId/{orderId}");
				
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
	
	}
}
